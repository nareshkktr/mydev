package com.kasisripriyawebapps.myindia.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;

import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface BaseDao<PK, T> {

	/**
	 * Save object.
	 *
	 * @param entity
	 *            the entity
	 * @return the long
	 * @throws CommonException
	 *             the common exception
	 */
	long save(T entity) throws InternalServerException;

	/**
	 * Update object.
	 *
	 * @param entity
	 *            the entity
	 * @throws CommonException
	 *             the common exception
	 */
	void update(T entity) throws InternalServerException;

	/**
	 * Save or update object.
	 *
	 * @param entity
	 *            the entity
	 * @throws CommonException
	 *             the common exception
	 */
	void saveOrUpdate(T entity) throws InternalServerException;

	/**
	 * Delete object.
	 *
	 * @param entity
	 *            the entity
	 * @throws CommonException
	 *             the common exception
	 */
	void delete(T entity) throws InternalServerException;

	/**
	 * Gets the object.
	 *
	 * @param <T>
	 *            the generic type
	 * @param entityClass
	 *            the entity class
	 * @param entityId
	 *            the entity id
	 * @return the object
	 * @throws CommonException
	 *             the common exception
	 */
	T getById(PK entityId) throws InternalServerException;

	List<T> getAll(SortCriteriaData sortCriteria) throws InternalServerException;

	/**
	 * Gets the objects.
	 *
	 * @param entityClass
	 *            the entity class
	 * @param criterions
	 *            the criterions
	 * @param orderByField
	 *            the order by field
	 * @return the objects
	 * @throws CommonException
	 *             the common exception
	 */
	List<T> getAllByConditions(List<Criterion> criterions, SortCriteriaData sortCriteria)
			throws InternalServerException;

	@SuppressWarnings("unchecked")
	List<T> getAllByPrimaryKeys(SortCriteriaData sortCriteria, PK... primaryKey) throws InternalServerException;

	int size() throws InternalServerException;

	T getByConditions(List<Criterion> criterions) throws InternalServerException;

	int executeUpdateNativeNamedQuery(String queryName, Map<String, Object> parameters) throws InternalServerException;

	List<T> executeNativeNamedQuery(String queryName, Map<String, Object> parameters, Class<?> tansformerClass)
			throws InternalServerException;

	T getByCondition(Criterion criterion) throws InternalServerException;

	void saveOrUpdateBatch(List<T> entities) throws InternalServerException;

	void deleteBatch(List<T> entities) throws InternalServerException;

	void saveOrUpdateBatchAsManualCommit(List<T> entities) throws InternalServerException;

	List<T> getAllByPage(SortCriteriaData sortCriteria, Integer pageNo, Integer pageLimit)
			throws InternalServerException;

	void updateBatch(List<T> entities) throws InternalServerException;

	void mergeBatch(List<T> entities) throws InternalServerException;

	void saveBatch(List<T> entities) throws InternalServerException;

}
