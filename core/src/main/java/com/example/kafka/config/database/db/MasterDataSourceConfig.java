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
public class MasterDataSourceConfig extends DataSourceConfig {

    private final CoreDataSourceProperties properties;
    private final Environment environment;

    @Bean(name = "coreDataSource")
    public DataSource dataSource() {
        properties.getMaster().setUserName("user");
        properties.getMaster().setPassword("password");
        HikariDataSource dataSource = dataSourceConfig(properties.getMaster());
        return new LazyConnectionDataSourceProxy(dataSource);
    }

    @Bean(name = "coreSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("coreDataSource") DataSource dataSource) throws Exception {
        return sqlSessionConfig(dataSource);
    }

    @Bean(name = "coreSqlSessionTemplate")
    public SqlSessionTemplate coreSqlSessionTemplate(@Qualifier("coreSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
