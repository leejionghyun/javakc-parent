package com.javakc.mes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.javakc"})
public class MesApplication {
    public static void main(String[] args) {
        SpringApplication.run(MesApplication.class,args);
    }
}
