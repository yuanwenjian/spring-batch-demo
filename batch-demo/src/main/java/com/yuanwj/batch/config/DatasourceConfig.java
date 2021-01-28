package com.yuanwj.batch.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 *  Copyright 天阳宏业科技股份有限公司 - All Rights Reserved
 *
 * @description:
 * @author: yuanwj
 * @date: 2020/10/09 09:42
 **/
@Configuration
public class DatasourceConfig {
    @Bean("batchDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.batch")
    public DataSource batchDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "batchTransactionManager")
    @Primary
    public DataSourceTransactionManager batchTransactionManager() {
        return new DataSourceTransactionManager(batchDataSource());
    }

    @Bean("slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "slaveSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("slaveDataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/**/*.xml"));
        sessionFactory.setTypeAliasesPackage("com.yuanwj.batch.model");
//        sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(SlaveDataSourceConfig.CONFIG_LOCATION));
        return sessionFactory.getObject();
    }
    @Bean(name = "slaveTransactionManager")
    public DataSourceTransactionManager slaveTransactionManager() {
        return new DataSourceTransactionManager(batchDataSource());
    }
}
