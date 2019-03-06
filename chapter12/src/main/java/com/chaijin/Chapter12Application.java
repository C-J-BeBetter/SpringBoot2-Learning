package com.chaijin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @EnableAsync 支持多线程执行
 * @Async @Async为异步注解，放到方法上，表示调用该方法的线程与此方法异步执行，需要配合@EnableAsync注解使用
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class Chapter12Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter12Application.class, args);
    }
    /**
     * 很关键：默认情况下 TaskScheduler 的 poolSize = 1
     *
     * @return 线程池
     */
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(1);
        return taskScheduler;
    }

}
