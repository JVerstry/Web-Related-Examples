package com.jverstry.Configuration;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class InMemoryDataSource implements DisposableBean {
    
    private EmbeddedDatabase ed;
    
    @Bean(name="hsqlInMemory")
	public EmbeddedDatabase hsqlInMemory() {
        
        if ( this.ed == null ) {
            
            EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
            
            this.ed = builder.setType(EmbeddedDatabaseType.HSQL)
                .addScript("aclSchema.sql").build();
            
        }
        
        return this.ed;
        
	}
    
    @Override
    public void destroy() {

        if ( this.ed != null ) {
            this.ed.shutdown();
        }

    }
    
}