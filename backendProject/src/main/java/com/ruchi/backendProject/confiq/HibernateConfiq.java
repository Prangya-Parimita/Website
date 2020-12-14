package com.ruchi.backendProject.confiq;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.ruchi.backendProject.dto")
@EnableTransactionManagement
public class HibernateConfiq {
	
	private String DATABASE_URL      =" jdbc:h2:~/onlineShopping";
	private String DATABASE_DRIVER   ="org.h2.Driver";
	private String DATABASE_DIALECT  ="org.hibernate.dialect.H2Dialect";
	private String DATABASE_USERNAME ="sa";
	private String DATABASE_PASSWORD ="";
	
	// dataSource bean will be available
		@Bean
		public DataSource getDataSource() {
			
			BasicDataSource dataSource = new BasicDataSource();
			
			// Providing the database connection information
			dataSource.setDriverClassName(DATABASE_DRIVER);
			dataSource.setUrl(DATABASE_URL);
			dataSource.setUsername(DATABASE_USERNAME);
			dataSource.setPassword(DATABASE_PASSWORD);
					
			
			return dataSource;
			
			}
		// sessionFactory bean will be available
		
		@Bean
		public SessionFactory getSessionFactory(DataSource dataSource) {
			
			LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
			
			builder.addProperties(getHibernateProperties());
			builder.scanPackages("com.ruchi.backendProject.dto");
			
			return builder.buildSessionFactory();
			
		}

		private Properties getHibernateProperties()
		{
			Properties properties = new Properties();
			
			
			properties.put("hibernate.dialect", DATABASE_DIALECT);		
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.format_sql", "true");
			
			//properties.put("hibernate.hbm2ddl.auto", "create");
			
			
			return properties;
			
		}
		
		// transactionManager bean
		@Bean
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}
		

}
