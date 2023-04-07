package com.pandeyar.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
	
	public static void main(String[] args) {
		modifyChilds(new ArrayList<GrandChild>());
		modifyParennts(new ArrayList<Parent>());
	}
	
	
	
	public static void modifyChilds(List<? extends Parent> list){
		//No modification allowed of the List
	}
	
	public static void modifyParennts(List<? super GrandChild> list){
		
		list.add(new GrandChild());
		list.add(new GrandChild());
		
	}

}
