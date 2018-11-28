package com.muzi.stu.thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample2 {
    static class Buffer{
        private Queue<Integer> list;
        private int size;
        public Buffer(int size){
            this.size = size;
            this.list = new LinkedList<Integer>();
        }
        public void add(int value) throws InterruptedException {
            synchronized (this){
                while (true){
                    if(list.size() >= size){
                        wait();
                    }
                    list.add(value);
                    notify();
                }
            }
        }
        public int poll() throws InterruptedException {
            synchronized (this){
                while(list.size() == 0){
                    wait();
                }
                int value = list.poll();
                notify();
                return value;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        final Buffer buffer = new Buffer(2);
        Thread produceThread = new Thread(new Runnable() {
            public void run() {
                int value = 0;
                while(true){
                    try {
                        buffer.add(value);
                        System.out.println("produce:" + value);
                        value++;
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread consumeThread  = new Thread(new Runnable() {
            public void run() {
                while(true){
                    try {
                        int value = buffer.poll();
                        System.out.println("consume:" + value);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        produceThread.start();
        consumeThread.start();
        produceThread.join();
        consumeThread.join();
    }
}
