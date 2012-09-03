
package com.jverstry.Configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JpaConfig {
   
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
      
	    LocalContainerEntityManagerFactoryBean factoryBean
            = new LocalContainerEntityManagerFactoryBean();
	   
        factoryBean.setDataSource( this.restDataSource() );
        factoryBean.setPackagesToScan( new String[ ] { "com.jverstry" } );
		factoryBean.setPersistenceUnitName("MyPU");
      
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		factoryBean.setJpaVendorAdapter( vendorAdapter );
		
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		props.put("hibernate.hbm2ddl.auto", "create");
		factoryBean.setJpaProperties(props);
		
		factoryBean.afterPropertiesSet();

        return factoryBean;
		
    }
	
    @Bean
    public DataSource restDataSource(){
   	   
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        dataSource.setUrl("jdbc:hsqldb:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
	  
        return dataSource;
	  
    }
   
    @Bean
    public PlatformTransactionManager transactionManager(){
	   
        JpaTransactionManager transactionManager = new JpaTransactionManager();
      
	    transactionManager.setEntityManagerFactory(
            this.entityManagerFactoryBean().getObject() );
      
        return transactionManager;
		
    }
   
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
   
}