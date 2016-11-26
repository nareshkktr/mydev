package com.kasisripriyawebapps.myindia.configs;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	@Autowired
	private Environment env;

	@Bean
	public TomcatEmbeddedServletContainerFactory tomcatFactory() {

		return new TomcatEmbeddedServletContainerFactory() {

			@Override
			protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(Tomcat tomcat) {
				tomcat.enableNaming();
				return super.getTomcatEmbeddedServletContainer(tomcat);
			}

			@Override
			protected void postProcessContext(Context context) {
				ContextResource resource = new ContextResource();
				resource.setName(env.getProperty("datasource.resource.name"));
				resource.setType(DataSource.class.getName());
				resource.setProperty("driverClassName", env.getProperty("datasource.driver-class-name"));
				resource.setProperty("url", env.getProperty("datasource.url"));
				resource.setProperty("password", env.getProperty("datasource.password"));
				resource.setProperty("username", env.getProperty("datasource.username"));
				resource.setProperty("testWhileIdle", env.getProperty("spring.datasource.testWhileIdle"));
				resource.setProperty("timeBetweenEvictionRunsMillis",
						env.getProperty("spring.datasource.timeBetweenEvictionRunsMillis"));
				resource.setProperty("validationQuery", env.getProperty("spring.datasource.validationQuery"));
				context.getNamingResources().addResource(resource);
			}
		};
	}

	@Bean
	public DataSource myIndiaDataSource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName(env.getProperty("datasource.jndi-name"));
		jndiObjectFactoryBean.setProxyInterface(DataSource.class);
		jndiObjectFactoryBean.setLookupOnStartup(false);
		jndiObjectFactoryBean.afterPropertiesSet();
		return (DataSource) jndiObjectFactoryBean.getObject();

	}

	/**
	 * Session factory.
	 *
	 * @param myIndiaDataSource
	 *            the my india data source
	 * @return the local session factory bean
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource myIndiaDataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myIndiaDataSource);
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty(ApplicationConstants.HIBERNATE_DAILECT_LBL,
				env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty(ApplicationConstants.HIBERNATE_DEFAULT_SCHEMA_LBL,
				env.getProperty("hibernate.default-schema"));
		hibernateProperties.setProperty(ApplicationConstants.HIBERNATE_SHOW_SQL_LBL,
				env.getProperty("hibernate.show-sql"));
		hibernateProperties.setProperty(ApplicationConstants.HIBERNATE_FORMAT_SQL_LBL,
				env.getProperty("hibernate.format-sql"));
		hibernateProperties.setProperty(ApplicationConstants.HIBERNATE_HBM2DDL_AUTO_LBL,
				env.getProperty("hibernate.ddl-auto"));
		hibernateProperties.setProperty(ApplicationConstants.HIBERNATE_CONNECTION_USE_UNICODE_LBL,
				env.getProperty("hibernate.connection.use_unicode"));
		hibernateProperties.setProperty(ApplicationConstants.HIBERNATE_CONNECTION_CHARACTER_ENCODING_LBL,
				env.getProperty("hibernate.connection.character-encoding"));
		hibernateProperties.setProperty(ApplicationConstants.HIBERNATE_CONNECTION_CHARSET_LBL,
				env.getProperty("hibernate.connection.char-set"));
		hibernateProperties.setProperty(ApplicationConstants.HIBERNATE_JDBC_BATCH_SZIE_LBL,
				String.valueOf(env.getProperty("hibernate.jdbc.batch-size")));
		hibernateProperties.setProperty(ApplicationConstants.HIBERNATE_ORDER_INSERTS_LBL,
				env.getProperty("hibernate.order-inserts"));
		hibernateProperties.setProperty(ApplicationConstants.HIBERNATE_ORDER_UPDATES_LBL,
				env.getProperty("hibernate.order-updates"));
		hibernateProperties.setProperty(ApplicationConstants.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE_LBL,
				env.getProperty("hibernate.cache.use-second-level-cache"));
		hibernateProperties.setProperty(ApplicationConstants.HIBERNATE_BATCH_VERSIONED_DATA_LBL,
				env.getProperty("hibernate.jdbc.batch-versioned-data"));
		sessionFactory.setHibernateProperties(hibernateProperties);
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packages-to-scan"));

		return sessionFactory;
	}

	/**
	 * Transaction manager.
	 *
	 * @param myIndiaDataSource
	 *            the my india data source
	 * @param sessionFactory
	 *            the session factory
	 * @return the hibernate transaction manager
	 */
	@Bean
	public HibernateTransactionManager transactionManager(DataSource myIndiaDataSource, SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setDataSource(myIndiaDataSource);
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource myIndiaDataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(myIndiaDataSource);
		return jdbcTemplate;
	}

}
