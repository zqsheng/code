package com.muzi.stu.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExample3 {
    public static void main(String[] args){
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(3);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable produceTask = () -> {
            int value = 0;
            while(true){
                try {
                    blockingQueue.put(value);
                    System.out.println("produce:" + value);
                    value++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable consumeTask = () -> {
            while(true){
                try {
                    int value = blockingQueue.take();
                    System.out.println("consume:" + value);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        executorService.execute(produceTask);
        executorService.execute(consumeTask);
        executorService.shutdown();
    }
}
