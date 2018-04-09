package com.examples;


class Target{

}

class FirstThread implements  Runnable{
     Target target1,target2;
    FirstThread(Target target1,Target target2){
        this.target1 = target1;
        this.target2 = target2;
    }
    @Override
    public void run() {
        System.out.println("First Thread  " + Thread.currentThread().getId());
        try {
            synchronized (this.target1) {
                synchronized (this.target2) {
                    Thread.sleep(1000);
                }
            }
        }catch (InterruptedException ie){
        }
    }
}
class SecondThread implements  Runnable{
    Target target1,target2;
    SecondThread(Target target1,Target target2){
        this.target1 = target1;
        this.target2 = target2;
    }
    @Override
    public void run() {
        try {
            System.out.println("Second Thread  " + Thread.currentThread().getId());
            synchronized (this.target1) {
                Thread.sleep(1000);
                synchronized (this.target2) {
                    Thread.sleep(1000);
                }
            }
        }catch (InterruptedException ie){
        }
    }
}


public class DeadLockExample {
    public static void main(String[] args) {
        Target target1 = new Target();
        Target target2 = new Target();
        Thread t1 = new Thread(new FirstThread(target1,target2));
        Thread t2 = new Thread(new SecondThread(target1,target2));
        t1.start();
        t2.start();
    }
}
