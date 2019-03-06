package com.chaijin.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: SpringBoot2-Learning
 * @Package: com.chaijin.scheduled
 * @ClassName: ScheduledExecutorServiceDemo
 * @Description:
 * @Author: 柴进
 * @Date: 2019/3/6 15:07
 * @Version: 1.0
 */
public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("scheduledExecutorService定时任务"),5000,2000, TimeUnit.MILLISECONDS);
    }
}
