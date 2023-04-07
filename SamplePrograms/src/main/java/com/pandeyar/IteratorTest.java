package com.pandeyar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class IteratorTest {
	
	public static void main(String[] args) {
		
		List<String> list=new ArrayList<String>();
		
		for(int i=0; i<=20;i++){
			list.add("ABC"+i);	
		}
		
//		
//		for(String string:list){
//			
//			if(string.equals("ABC3") || string.equals("ABC19")){
//				list.remove(string);
//			}
//		}
		
		Iterator<String> iterator=list.iterator();
		
		while(iterator.hasNext()){
			
			String value=iterator.next();
			
			if(value.equals("ABC3") || value.equals("ABC19")){
				iterator.remove();
			}
		}
//		
		System.out.println("The value in list is "+list);
	}

}
