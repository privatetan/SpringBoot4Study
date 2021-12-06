package com.springstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springstudy.mybatisplus.mapper")

public class SpringBoot4StudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot4StudyApplication.class, args);
    }

}
