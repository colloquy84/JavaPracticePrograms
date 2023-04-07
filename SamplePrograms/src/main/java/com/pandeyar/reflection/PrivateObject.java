package com.pandeyar.reflection;

public class PrivateObject {

	  private String privateString = "ABC";

	  private PrivateObject(String privateString) {
	    this.privateString = privateString;
	  }
	  
	  private PrivateObject(){
		  
	  }

	  private String getPrivateString(){
	    return this.privateString;
	  }
	}

