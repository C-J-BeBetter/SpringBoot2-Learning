package com.chaijin.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: SpringBoot2-Learning
 * @Package: com.chaijin.rabbit
 * @ClassName: Sender
 * @Description: 接收者
 * @Author: 柴进
 * @Date: 2019/3/4 18:16
 * @Version: 1.0
 */
@Component
public class Receiver {

    @RabbitListener(queues = "hello")
    public void process(String hello){
        System.out.println("receiver:"+hello);
    }

}
