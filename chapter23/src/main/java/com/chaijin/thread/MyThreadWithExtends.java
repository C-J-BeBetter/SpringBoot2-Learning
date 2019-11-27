package com.chaijin.thread;

import java.util.Random;

public class MyThreadWithExtends extends Thread {
    private String flag;

    public MyThreadWithExtends(String flag) {
        this.flag = flag;
    }

    public void run(){
        String name = Thread.currentThread().getName();
        System.out.println(name + "线程的方法开始执行");
        Random random = new Random();
        for (int i = 0; i < 20; i++){
            try {
                Thread.sleep(random.nextInt(10)*100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("线程的方法开始执行 end");
    }

    public static void main(String[] args) {
        Thread thread1 = new MyThreadWithExtends("a");
        Thread thread2 = new MyThreadWithExtends("b");
        thread1.start();
        thread2.start();
    }
}
