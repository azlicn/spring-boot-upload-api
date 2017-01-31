package com.azlicn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootUploadApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootUploadApp.class, args);
    }


}