//package com.twentythree.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//public class DatabaseConfig {
//
//    @Value("${db.driver}")
//    private String DB_DRIVER;
//
//    @Value("${db.url}")
//    private String DB_URL;
//
//    @Value("${db.username}")
//    private String DB_USERNAME;
//
//    @Value("${db.password}")
//    private String DB_PASSWORD;
//
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName(DB_DRIVER);
//        dataSource.setUsername(DB_USERNAME);
//        dataSource.setPassword(DB_PASSWORD);
//        dataSource.setUrl(DB_URL);
//
//        return dataSource;
//    }
//
//
//
//
//}
