package com.pandeyar;

public class ImplicitSubClassTest {

	
	public static void main(String[] args) {
		
		
		Runnable runnable=new Runnable() {
			
			public void run() {
				System.out.println("Started doing something.");
				
			}
		};
		
		
		Thread t=new Thread(runnable);
		t.start();
	}
}
