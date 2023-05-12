package com.example.kafka.config.database.db;

import com.example.kafka.config.database.db.properties.CoreDataSourceProperties;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(CoreDataSourceProperties.class)
public class SlaveDataSourceConfig extends DataSourceConfig {

    private final CoreDataSourceProperties properties;
    private final Environment environment;

    @Bean(name = "coreSlaveDataSource")
    public DataSource dataSource() {
        properties.getSlave().setUserName("user");
        properties.getSlave().setPassword("password");
        HikariDataSource dataSource = dataSourceConfig(properties.getSlave());
        return new LazyConnectionDataSourceProxy(dataSource);
    }

    @Bean(name = "coreSlaveSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("coreSlaveDataSource") DataSource dataSource) throws Exception {
        return sqlSessionConfig(dataSource);
    }

    @Bean(name = "coreSlaveSqlSessionTemplate")
    public SqlSessionTemplate coreSqlSessionTemplate(@Qualifier("coreSlaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
