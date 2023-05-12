package com.example.kafka.config.database.db.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class DataSourceProperties {
    private final String driverClassName;
    private final String url;
    private final int maxPoolSize;
    private final int minIdle;

    @Setter
    private String userName;
    @Setter
    private String password;
}
