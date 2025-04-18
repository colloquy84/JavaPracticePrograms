package com.pandeyar.concurrent.thread;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {

        final Processor4 processor = new Processor4();

        Thread t1 = new Thread(new Runnable() {

            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {


            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}


class Processor4 {

    private final LinkedList<Integer> list = new LinkedList<Integer>();
    private final int LIMIT = 10;
    private final Object lock = new Object();

    public void produce() throws InterruptedException {

        int value = 0;

        while (true) {

            synchronized (lock) {

                while (list.size() == LIMIT) {
                    lock.wait();
                }

                list.add(value++);
                lock.notify();
            }

        }
    }

    public void consume() throws InterruptedException {

        Random random = new Random();

        while (true) {

            synchronized (lock) {

                while (list.size() == 0) {
                    lock.wait();
                }

                System.out.print("List size is: " + list.size());
                int value = list.removeFirst();
                System.out.println("; value is: " + value);
                lock.notify();
            }

            Thread.sleep(random.nextInt(100));
        }
    }
}
