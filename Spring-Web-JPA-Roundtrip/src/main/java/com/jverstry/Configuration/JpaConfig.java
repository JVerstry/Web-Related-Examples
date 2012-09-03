
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
      
	    LocalContainerEntityManagerFactoryBean lcemfb
            = new LocalContainerEntityManagerFactoryBean();
	   
        lcemfb.setDataSource(this.dataSource());
        lcemfb.setPackagesToScan(new String[] {"com.jverstry"});
		lcemfb.setPersistenceUnitName("MyPU");
      
        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
		lcemfb.setJpaVendorAdapter(va);
		
		Properties ps = new Properties();
		ps.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		ps.put("hibernate.hbm2ddl.auto", "create");
		lcemfb.setJpaProperties(ps);
		
		lcemfb.afterPropertiesSet();

        return lcemfb;
		
    }
	
    @Bean
    public DataSource dataSource(){
   	   
        DriverManagerDataSource ds = new DriverManagerDataSource();
		
        ds.setDriverClassName("org.hsqldb.jdbcDriver");
        ds.setUrl("jdbc:hsqldb:mem:testdb");
        ds.setUsername("sa");
        ds.setPassword("");
	  
        return ds;
	  
    }
   
    @Bean
    public PlatformTransactionManager transactionManager(){
	   
        JpaTransactionManager tm = new JpaTransactionManager();
      
	    tm.setEntityManagerFactory(
            this.entityManagerFactoryBean().getObject() );
      
        return tm;
		
    }
   
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
   
}