package com.redbee.batchjobs.conf;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DatasourceConfiguration {

    @Bean(name = "emiDataSource")
    @Primary
    @ConfigurationProperties(prefix = "datasource.emi")
    public DataSource emiDataSource(){
        return DataSourceBuilder.create().build();
    }

}
