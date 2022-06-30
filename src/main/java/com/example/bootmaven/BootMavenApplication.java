package com.example.bootmaven;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.example.bootmaven.dao")
//@EnableTransactionManagement
public class BootMavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootMavenApplication.class, args);
    }

}
