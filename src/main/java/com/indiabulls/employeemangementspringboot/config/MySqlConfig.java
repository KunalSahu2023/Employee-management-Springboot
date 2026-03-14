package com.indiabulls.employeemangementspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages="com.indiabulls.employeemangementspringboot.repository.mysql"
)
public class MySqlConfig {
}
