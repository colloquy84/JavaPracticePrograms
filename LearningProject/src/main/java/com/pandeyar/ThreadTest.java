package com.pandeyar;

public class ThreadTest {
	public synchronized void m1() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie) {
		}
	}

	public synchronized void m2() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie) {
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final ThreadTest t = new ThreadTest();
		Thread t1 = new Thread() {
			public void run() {
				t.m1();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				t.m2();
			}
		};
		t1.start();
		Thread.sleep(1000);
		t2.start();
		Thread.sleep(500);
	
			System.out.println("State of Thread T1 --> "+t1.getState());
			System.out.println("State of Thread T2 --> "+t2.getState());
			Thread.sleep(2000);
			System.out.println("State of Thread T1 --> "+t1.getState());
			System.out.println("State of Thread T2 --> "+t2.getState());
			Thread.sleep(2000);
			System.out.println("State of Thread T1 --> "+t1.getState());
			System.out.println("State of Thread T2 --> "+t2.getState());
			

		
	}
}