package com.bysj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.bysj.dao.**")
@ComponentScan(basePackages = "com.bysj.**")
public class Bbsv1Application {

    public static void main(String[] args) {
        SpringApplication.run(Bbsv1Application.class, args);
    }

}

