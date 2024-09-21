package com.pandeyar;

public class StaticClass {
	
	public int aMethod() throws Exception{
		
		try{
			throwException();
			System.out.println("Retruning from the try block");
			return 1;
		}catch(Exception e){
			throwException();
			System.out.println("Returning from the catch block");
			return 2;
		}finally{
			System.out.println("Returning from the finally block");
			return 3;
		}		
	}
	
	public static void main(String[] args) throws Exception{
		StaticClass staticClass=new StaticClass();
		System.out.println(staticClass.aMethod());
	}
	
	private void throwException() throws Exception{
		Exception exception =new Exception();
		System.out.println("Going to throw this exception -->" +exception);
		throw exception;
	}

}
