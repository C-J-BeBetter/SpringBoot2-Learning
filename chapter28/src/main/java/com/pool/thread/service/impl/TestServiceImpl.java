package com.pool.thread.service.impl;

import com.pool.thread.service.TestService;
import com.pool.thread.service.TestService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @title: TestServiceImpl
 * @description: TODO
 * @date 2020/6/215:47
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    TestService1 testService1;

    @Override
    public void print(Integer size) {
        size = size == null ? 10 : size;
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        for (int i = 0; i < size; i++ ) {
            list.add("aaaaaaaaaa");
            list1.add("bbbbbbbbbb");
            list2.add("ccccccccccc");
            list3.add("dddddddddddddddddd");
        }
        testService1.run(list);
        testService1.run(list1);
        testService1.run(list2);
        testService1.run(list3);
    }
}
