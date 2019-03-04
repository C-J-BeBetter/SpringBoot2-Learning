package com.chaijin;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
public class Chapter8Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter8Application.class, args);
    }

}
