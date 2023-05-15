package com.example.kafka.config.database.db;

import com.example.kafka.config.database.db.properties.DataSourceProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Arrays;

public abstract class DataSourceConfig {

    private static final String PROFILE_TEST = "test";

    protected HikariDataSource dataSourceConfig(DataSourceProperties properties) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(properties.getDriverClassName());
        hikariConfig.setJdbcUrl(properties.getUrl());
        hikariConfig.setUsername(properties.getUserName());
        hikariConfig.setPassword(properties.getPassword());
        hikariConfig.setMaximumPoolSize(properties.getMaxPoolSize());
        hikariConfig.setMinimumIdle(properties.getMinIdle());

        return new HikariDataSource(hikariConfig);
    }

    protected SqlSessionFactory sqlSessionConfig(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfiguration(this.getConfiguration());
        sqlSessionFactoryBean.setTypeAliasesPackage("com.example.kafka");

        return sqlSessionFactoryBean.getObject();
    }

//    protected void setDbAccount(DataSourceProperties properties, Account account) {
//        properties.setUserName(account.getUsername());
//        properties.setPassword(account.getPassword());
//    }

    protected boolean hasNotProfileTest(String[] activeProfiles) {
        return !Arrays.asList(activeProfiles).contains(PROFILE_TEST);
    }

    private Configuration getConfiguration() {
        Configuration config = new Configuration();
        config.setMapUnderscoreToCamelCase(true);
        return config;
    }
}

