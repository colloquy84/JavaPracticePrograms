package com.pandeyar;

public class SingletonCloneTest implements Cloneable{

	int aNumber;

	public static void main(String[] args) {
		try {
			SingletonCloneTest singletonCloneTest = new SingletonCloneTest();
			singletonCloneTest.aNumber = 23;

			SingletonCloneTest singletonCloneTestClone = (SingletonCloneTest) singletonCloneTest
					.clone();
			
			singletonCloneTestClone.aNumber=28;
			
			System.out.println("singletonCloneTest.aNumber is "+singletonCloneTest.aNumber);
			System.out.println("singletonCloneTestClone.aNumber is "+singletonCloneTestClone.aNumber);
			
			System.out.println(singletonCloneTest);
			System.out.println(singletonCloneTest.getClass().getName()+'@'+Integer.toHexString(singletonCloneTest.hashCode()));
			
			
			

		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
