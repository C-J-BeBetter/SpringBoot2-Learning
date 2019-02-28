package com.chaijin;

import com.chaijin.entity.User;
import com.chaijin.mapper.UserMapper;
import com.chaijin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class Chapter5Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter5Application.class, args);
    }

    @Autowired
    UserService userService;


    @GetMapping("/getUser")
    public String getUser(){
        User user = new User();
        user.setPageNum(1);
        user.setPageSize(1);
        return userService.pageUser(user);
    }
}
