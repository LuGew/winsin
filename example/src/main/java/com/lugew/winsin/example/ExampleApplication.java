package com.lugew.winsin.example;

import com.lugew.winsin.mybatis.configuration.EnableMyBatisPlus;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableMyBatisPlus
//@MapperScan("com.lugew.winsin.example.repository")
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

}
