package com.chaijin.timer;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ProjectName: SpringBoot2-Learning
 * @Package: com.chaijin.timer
 * @ClassName: TimerDemo
 * @Description:
 * @Author: 柴进
 * @Date: 2019/3/6 11:50
 * @Version: 1.0
 */
public class TimerDemo {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("我是定时任务"+ LocalDateTime.now());
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,5000,2000);
    }
}
