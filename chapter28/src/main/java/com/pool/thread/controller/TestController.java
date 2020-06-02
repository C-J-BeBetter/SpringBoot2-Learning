package com.pool.thread.controller;

import com.pool.thread.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @title: TestController
 * @description: TODO
 * @date 2020/6/215:42
 */

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/{size}")
    public void run(@PathVariable Integer size) {
        System.out.println("-------------------------------");
        testService.print(size );
        System.out.println("-------------------------------");
    }

}
