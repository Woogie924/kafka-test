package com.example.kafka.config.database.db.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "spring.datasources.core")
public class CoreDataSourceProperties {
    private final DataSourceProperties master;
    private final DataSourceProperties slave;
}
