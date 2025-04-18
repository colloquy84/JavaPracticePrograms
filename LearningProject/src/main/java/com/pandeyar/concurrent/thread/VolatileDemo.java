package com.pandeyar.concurrent.thread;


import java.util.Scanner;

class Processor6 extends Thread {

    private volatile boolean running = true;

    public void run() {

        while (running) {
            System.out.println("Running");

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class VolatileDemo {

    public static void main(String[] args) {
        Processor6 pro = new Processor6();
        pro.start();

        // Wait for the enter key
        new Scanner(System.in).nextLine();

        pro.shutdown();
    }

}
