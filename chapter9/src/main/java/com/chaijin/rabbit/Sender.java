package com.chaijin.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ProjectName: SpringBoot2-Learning
 * @Package: com.chaijin.rabbit
 * @ClassName: Sender
 * @Description: 发送者
 * @Author: 柴进
 * @Date: 2019/3/4 18:16
 * @Version: 1.0
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "hello " + new Date();
//        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("hello", context);
    }
}
