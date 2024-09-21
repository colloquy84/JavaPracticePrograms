package com.pandeyar.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SeamaphoreExample {
	public static void main(String[] args) throws Exception {
		 
        ExecutorService executor = Executors.newCachedThreadPool();
 
        for(int i=0; i < 200; i++) {
            executor.submit(new Runnable() {
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }
 
        executor.shutdown();
 
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
 
}

 class Connection {
	 
    private static final Connection instance = new Connection();
 
    private final Semaphore sem = new Semaphore(5, true);
 
    private int connections = 0;
 
    private Connection() {
 
    }
 
    public static Connection getInstance() {
        return instance;
    }
 
    public void connect() {
        try {
            sem.acquire();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
 
        try {
            doConnect();
        } finally {
 
            sem.release();
        }
    }
 
    public void doConnect() {
 
        synchronized (this) {
            connections++;
            System.out.println("Current connections: " + connections);
        }
 
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        synchronized (this) {
            connections--;
        }
 
    }
}