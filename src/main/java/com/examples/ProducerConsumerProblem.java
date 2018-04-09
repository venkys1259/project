package com.examples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Producer implements Runnable{
    Queue<Integer> sharedQueue;
    int maxSize;
    Producer(Queue sharedQueue,int maxSize){
        this.sharedQueue = sharedQueue;
        this.maxSize = maxSize;
    }
    @Override
    public void run() {
         while(true){
             synchronized (sharedQueue){
                 while(sharedQueue.size() == maxSize){
                     try {
                         sharedQueue.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                 int number = new Random().nextInt();
                 sharedQueue.add(number);
                 System.out.println("produced "+number );
                 sharedQueue.notify();
             }
         }
    }
}

class Consumer implements Runnable{
    Queue<Integer> sharedQueue;
    int maxSize;
    public Consumer(Queue sharedQueue,int maxSize){
        this.sharedQueue = sharedQueue;
        this.maxSize = maxSize;
    }
    @Override
    public void run() {
        while(true){
            synchronized (sharedQueue){
                while(sharedQueue.isEmpty()){
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer number = sharedQueue.poll();
                System.out.println("Consumed " +number);
                sharedQueue.notify();
            }
        }

    }
}
public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 4;
        Producer producer = new Producer(queue,maxSize);
        Consumer consumer = new Consumer(queue,maxSize);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
    }
}
