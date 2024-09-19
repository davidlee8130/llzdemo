package com.llz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.llz.dao")
public class LlzSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LlzSpringbootApplication.class, args);
    }

}
