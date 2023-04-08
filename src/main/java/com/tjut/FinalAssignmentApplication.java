package com.tjut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.tjut.dao")
public class FinalAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalAssignmentApplication.class, args);
    }

}
