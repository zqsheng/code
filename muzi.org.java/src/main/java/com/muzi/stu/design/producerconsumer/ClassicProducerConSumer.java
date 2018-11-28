package com.muzi.stu.design.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ClassicProducerConSumer {

    private static class Buffer{
        private Queue<Integer> queue;
        private int size;
        public Buffer(int size){
            this.queue = new LinkedList<Integer>();
            this.size = size;
        }
        public void produce() throws InterruptedException{
            int value = 0;
            while(true){
               synchronized (this){
                   while (queue.size() >= size){
                       wait();
                   }
                   queue.add(value);
                   System.out.println("produced:" + value);
                   value++;
                   notify();
                   Thread.sleep(1000);
               }
           }
        }
        public void consume() throws InterruptedException{
            while (true){
                synchronized (this){
                    while (queue.size() == 0){
                        wait();
                    }
                    int value = queue.poll();
                    System.out.println("consume:" + value);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
    }
    public static void main(String[] args) throws  InterruptedException{
        final Buffer buffer = new Buffer(2);
        Thread produceThread = new Thread(new Runnable(){
            public void run() {
                try{
                    buffer.produce();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread consumeThread = new Thread(new Runnable(){

            public void run() {
                try{
                    buffer.consume();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        produceThread.start();
        consumeThread.start();
        produceThread.join();
        consumeThread.join();
    }
}
