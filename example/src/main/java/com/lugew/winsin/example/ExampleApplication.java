package com.lugew.winsin.example;

import com.lugew.winsin.mybatis.configuration.EnableMyBatisPlusPaging;
import com.lugew.winsin.web.configuration.EnableStandardResponse;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lugew.winsin.example.repository")
@EnableMyBatisPlusPaging
@EnableStandardResponse
public class ExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }
}