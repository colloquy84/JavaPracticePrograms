package com.pandeyar;

public class TestCharToInt {

	public static void main(String[] args) throws Exception{

		String aString = "224545.23";

		char[] charArray = aString.toCharArray();
		int number = 0;
		int divisiorCount = 0;

		for (int count = 0; count < charArray.length; count++) {
			if (charArray[count] >= 48 && charArray[count] <= 57) {
				int sequence = charArray[count]-'0';
				number = number * 10 + sequence;
			} else if (charArray[count] == 46 && divisiorCount==0) {
				divisiorCount = (charArray.length - count) - 1;
			}else{
				throw new NumberFormatException(" Input String can not be converted into float");
			}
		}
		int divisor=1;
		for(int i=0; i<divisiorCount;i++){
			divisor=divisor*10;
		}
		float floatNumber = ((float)number )/ divisor;
		System.out.println("Float value is " + floatNumber);
	}

}
