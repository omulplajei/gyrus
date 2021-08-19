package com.gyrus.config;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "datasource")
public class DataSourceConfig {

    private String url;
    private String username;
    private String password;

    @Bean
    public DataSource getDataSource() {
        var builder = DataSourceBuilder.create();
        builder.driverClassName("org.h2.Driver");
        builder.username(username);
        builder.password(password);
        builder.url(url);

        return builder.build();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
