package com.chaijin.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 基于 Spring 自带的
 *
 * @author Levin
 * @since 2018/5/29 0029
 */
@Component
public class SpringTaskDemo {

    private static final Logger log = LoggerFactory.getLogger(SpringTaskDemo.class);

    /**
     * @EnableAsync 支持多线程执行
     * @Async @Async为异步注解，放到方法上，表示调用该方法的线程与此方法异步执行，需要配合@EnableAsync注解使用
     * @throws InterruptedException
     */
    @Async
    @Scheduled(cron = "0/1 * * * * *")
    public void scheduled1() throws InterruptedException {
        Thread.sleep(3000);     //每个线程休眠3s,由其他线程执行
        log.info("scheduled1 每1秒执行一次：{}", LocalDateTime.now(), Thread.currentThread().getName());
    }

    /**
     * fixedRate 每1000ms执行一次
     * @throws InterruptedException
     */
    @Scheduled(fixedRate = 1000)
    public void scheduled2() throws InterruptedException {
        Thread.sleep(3000);
        log.info("scheduled2 每1秒执行一次：{}", LocalDateTime.now(), Thread.currentThread().getName());
    }

    /**
     * 上次任务执行完，隔3000ms执行
     * @throws InterruptedException
     */
    @Scheduled(fixedDelay = 3000)
    public void scheduled3() throws InterruptedException {
        Thread.sleep(5000);
        log.info("scheduled3 上次执行完毕后隔3秒继续执行：{}", LocalDateTime.now(), Thread.currentThread().getName());
    }

}
