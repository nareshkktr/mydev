/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.dao.BaseDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Class BaseDaoImpl.
 */

public class BaseDaoImpl<PK extends Serializable, T> implements BaseDao<PK, T> {

	private final Class<T> persistentClass;

	private int jdbcBatchSize = 50;

	/** The session factory. */

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public long save(T entity) throws InternalServerException {
		long savedId = Long.valueOf(0);
		try {
			savedId = (Long) getSession().save(entity);
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
		return savedId;
	}

	@Override
	public void update(T entity) throws InternalServerException {
		try {
			getSession().update(entity);
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	@Override
	public void saveOrUpdate(T entity) throws InternalServerException {
		try {
			getSession().saveOrUpdate(entity);
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	@Override
	public void delete(T entity) throws InternalServerException {
		try {
			getSession().delete(entity);
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	public Criteria getCriteria() throws InternalServerException {
		Criteria criteria = getSession().createCriteria(persistentClass);
		return criteria;
	}

	public Criteria getCriteria(SortCriteriaData sortCriteria) throws InternalServerException {
		Criteria criteria = getSession().createCriteria(persistentClass);
		addSortCriteria(criteria, sortCriteria);
		return criteria;
	}

	private void addSortCriteria(Criteria criteria, SortCriteriaData sortCriteria) {

		if (sortCriteria != null) {
			final String property = sortCriteria.getProperty();
			final boolean ascending = sortCriteria.getIsAscending();
			final Order order = ascending ? Order.asc(property) : Order.desc(property);
			criteria.addOrder(order);
		}
	}

	@Override
	public int size() throws InternalServerException {
		try {
			final Criteria criteria = getCriteria();
			criteria.setProjection(Projections.rowCount());
			return (Integer) criteria.uniqueResult();
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	@Override
	public T getById(PK primaryKey) throws InternalServerException {
		try {
			return (T) getSession().get(persistentClass, primaryKey);
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(SortCriteriaData sortCriteria) throws InternalServerException {
		return getCriteria(sortCriteria).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAllByPrimaryKeys(SortCriteriaData sortCriteria, PK... primaryKeys)
			throws InternalServerException {
		try {
			Criteria criteria = getCriteria(sortCriteria);
			criteria.add(Restrictions.in(getPrimaryKeyPropertyName(), primaryKeys));
			return criteria.list();
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	private String getPrimaryKeyPropertyName() {
		ClassMetadata classMetadata = sessionFactory.getClassMetadata(persistentClass);
		String primaryKeyPropertyName = classMetadata.getIdentifierPropertyName();
		return primaryKeyPropertyName;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAllByConditions(List<Criterion> criterions, SortCriteriaData sortCriteria)
			throws InternalServerException {
		List<T> objects = null;
		try {
			Criteria criteria = getCriteria(sortCriteria);
			if (criterions != null) {
				for (Criterion criterion : criterions) {
					criteria.add(criterion);
				}
			}
			objects = criteria.list();
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
		return objects;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAllByCondition(Criterion criterion, SortCriteriaData sortCriteria)
			throws InternalServerException {
		List<T> objects = null;
		Criteria criteria = getCriteria(sortCriteria);
		if (criterion != null) {
			criteria.add(criterion);
		}
		objects = criteria.list();
		if (objects != null && !objects.isEmpty()) {
			return objects;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getByCondition(Criterion criterion) throws InternalServerException {
		List<T> objects = null;
		Criteria criteria = getCriteria();
		if (criterion != null) {
			criteria.add(criterion);
		}
		objects = criteria.list();
		if (objects != null && !objects.isEmpty()) {
			return (T) objects.get(0);
		}
		return null;
	}

	@Override
	public T getByConditions(List<Criterion> criterions) throws InternalServerException {
		List<T> objects = getAllByConditions(criterions, null);
		if (objects != null && !objects.isEmpty()) {
			return (T) objects.get(0);
		}
		return null;
	}

	@Override
	public int executeUpdateNativeNamedQuery(String queryName, Map<String, Object> parameters)
			throws InternalServerException {
		int result;
		Query query = null;
		try {
			query = getSession().getNamedQuery(queryName);
			if (parameters != null) {
				for (String name : parameters.keySet())
					query.setParameter(name, parameters.get(name));
			}
			result = query.executeUpdate();
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> executeNativeNamedQuery(String queryName, Map<String, Object> parameters, Class<?> tansformerClass)
			throws InternalServerException {
		List<T> objects = null;
		Query query = null;
		try {
			query = getSession().getNamedQuery(queryName);
			if (parameters != null) {
				for (String name : parameters.keySet())
					query.setParameter(name, parameters.get(name));
			}
			if (tansformerClass != null) {
				query.setResultTransformer(Transformers.aliasToBean(tansformerClass));
			}
			objects = query.list();
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
		return objects;
	}

	@Override
	public void saveOrUpdateBatch(List<T> entities) throws InternalServerException {
		try {
			for (int i = 0; i < entities.size(); i++) {
				try {
					getSession().saveOrUpdate(entities.get(i));
					if (i % jdbcBatchSize == 0 && i > 0) {
						getSession().flush();
						getSession().clear();
					}
				} catch (Exception e) {
					throw new InternalServerException(e.getMessage());
				}

			}
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	@Override
	public void deleteBatch(List<T> entities) throws InternalServerException {
		try {
			for (int i = 0; i < entities.size(); i++) {
				try {
					getSession().delete(entities.get(i));
					if (i % jdbcBatchSize == 0 && i > 0) {
						getSession().flush();
						getSession().clear();
					}
				} catch (Exception e) {
					throw new InternalServerException(e.getMessage());
				}
			}
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	@Override
	public void saveOrUpdateBatchAsManualCommit(List<T> entities) throws InternalServerException {
		Transaction tx = null;
		try {
			tx = getSession().beginTransaction();
			for (int i = 0; i < entities.size(); i++) {
				try {
					getSession().saveOrUpdate(entities.get(i));
					if (i % jdbcBatchSize == 0 && i > 0) {
						getSession().flush();
						getSession().clear();
					}
				} catch (Exception e) {
					throw new InternalServerException(e.getMessage());
				}

			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new InternalServerException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAllByPage(SortCriteriaData sortCriteria, Integer pageNo, Integer pageLimit)
			throws InternalServerException {
		Criteria criteria = getCriteria();
		criteria.setFirstResult((pageNo - 1) * pageLimit);
		criteria.setMaxResults(pageLimit);
		return criteria.list();
	}

	@Override
	public void saveBatch(List<T> entities) throws InternalServerException {
		try {
			for (int i = 0; i < entities.size(); i++) {
				try {
					getSession().save(entities.get(i));
					if (i % jdbcBatchSize == 0 && i > 0) {
						getSession().flush();
						getSession().clear();
					}
				} catch (Exception e) {
					throw new InternalServerException(e.getMessage());
				}

			}
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	@Override
	public void updateBatch(List<T> entities) throws InternalServerException {
		try {
			for (int i = 0; i < entities.size(); i++) {
				try {
					getSession().update(entities.get(i));
					if (i % jdbcBatchSize == 0 && i > 0) {
						getSession().flush();
						getSession().clear();
					}
				} catch (Exception e) {
					throw new InternalServerException(e.getMessage());
				}
			}
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	@Override
	public void mergeBatch(List<T> entities) throws InternalServerException {
		try {
			for (int i = 0; i < entities.size(); i++) {
				try {
					getSession().merge(entities.get(i));
					if (i % jdbcBatchSize == 0 && i > 0) {
						getSession().flush();
						getSession().clear();
					}
				} catch (Exception e) {
					throw new InternalServerException(e.getMessage());
				}

			}
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}
}
