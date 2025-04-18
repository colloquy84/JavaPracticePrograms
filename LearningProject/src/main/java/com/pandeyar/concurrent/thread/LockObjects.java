package com.pandeyar.concurrent.thread;

class Worker {

    Object lock1 = new Object();
    Object lock2 = new Object();

    public void stageOne() {
        synchronized (lock1) {
            sleep();
        }
    }

    public void stageTwo() {
        synchronized (lock2) {
            sleep();
        }
    }

    public void sleep() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void process() {
        for (int i = 0; i < 500; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void run() {

        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Time taken: " + (System.currentTimeMillis() - start));
    }
}

public class LockObjects {
    public static void main(String[] args) {
        Worker ww = new Worker();
        ww.run();
    }
}

