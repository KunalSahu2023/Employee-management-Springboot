package com.indiabulls.employeemangementspringboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.indiabulls.employeemangementspringboot.repository.postgres")
public class PostgresConfig {

    @Bean
    @ConfigurationProperties(prefix="postgres.datasource")
    public DataSource postgresDataSource(){
        return DataSourceBuilder.create().build();
    }
}
