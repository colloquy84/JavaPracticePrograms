package com.pandeyar;

public class StringTest {
	
	public static void main(String[] args) {
		
		StringBuffer abc=new StringBuffer("abc");
		StringBuffer ABC=new StringBuffer("abc");
		
		
		String abcString= "abc";
		String ABCString= "abc";
		
		System.out.println(abcString==ABCString);
		System.out.println(abcString.equals(ABCString));
		
		System.out.println(abcString.compareTo(ABCString));
	}
}
