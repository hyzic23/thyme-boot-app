package com.twentythree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SuppressWarnings("ALL")
@SpringBootApplication(scanBasePackages={"com.twentythree.repository","com.twentythree.service"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ThymeBootAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeBootAppApplication.class, args);
    }

}
