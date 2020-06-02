package com.pool.thread.service.impl;

import com.pool.thread.service.TestService1;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @title: TestServiceImpl
 * @description: TODO
 * @date 2020/6/215:47
 */
@Service
public class TestServiceImpl1 implements TestService1 {

    @Override
    @Async("taskExecutor")
    public void run(List<String> List) {
        System.out.println(">>>" + Thread.currentThread().getId());
        List.forEach(s -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(s);
        });
    }
}
