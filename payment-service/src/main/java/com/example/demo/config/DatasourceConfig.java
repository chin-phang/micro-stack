package com.example.demo.config;

import com.cosium.spring.data.jpa.entity.graph.repository.support.EntityGraphJpaRepositoryFactoryBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan("com.wou.project.entity")
@EnableJpaRepositories(
    basePackages = {"com.wou.project.repository"},
    repositoryFactoryBeanClass = EntityGraphJpaRepositoryFactoryBean.class
)
@EnableTransactionManagement
public class DatasourceConfig {
}
