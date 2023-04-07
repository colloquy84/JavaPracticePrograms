package com.pandeyar.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionTest {

	public static void main(String[] args) throws Exception {

		PrivateObject privateObject = null;
		Class privateObjectClass = PrivateObject.class;

		Constructor[] constructors = privateObjectClass
				.getDeclaredConstructors();

		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			
			Class[] parameterTypes = constructor.getParameterTypes();
			if (parameterTypes != null && parameterTypes.length!=0) {
				for (Class parameterType : parameterTypes) {
					System.out.println(parameterType);
				}
				privateObject = (PrivateObject) constructor.newInstance("ABCDEFGH");
			}else{
				privateObject = (PrivateObject) constructor.newInstance();
			}
		}
		Method privateStringMethod = PrivateObject.class.getDeclaredMethod(
				"getPrivateString", null);

		privateStringMethod.setAccessible(true);

		String returnValue = (String) privateStringMethod.invoke(privateObject,
				null);

		System.out.println("returnValue = " + returnValue);

	}
}
