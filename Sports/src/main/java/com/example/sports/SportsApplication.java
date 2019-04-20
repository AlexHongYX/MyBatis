package com.example.sports;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@MapperScan("com.example.sports.mapper")
@SpringBootApplication
public class SportsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsApplication.class, args);
    }




}
