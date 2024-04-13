package com.stefanini.apitodolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.stefanini.apitodolist.tasks")
@EnableJpaRepositories("com.stefanini.apitodolist.tasks")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}