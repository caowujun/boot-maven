package com.example.bootmaven;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.bootmaven.dao")
public class BootMavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootMavenApplication.class, args);
    }

}
