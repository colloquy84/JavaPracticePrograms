package com.pandeyar.other;

public class InterfaceDefaultMethods implements I2, I3 {
    public static void main(String[] args) {
        InterfaceDefaultMethods interfaceDefaultMethods = new InterfaceDefaultMethods();
        interfaceDefaultMethods.abc();
    }

    @Override
    public void abc() {
        I3.super.abc();
    }
}

interface I1 {
    default void abc1() {
        System.out.println("I1 ABC");
    }
}

interface I2 extends I1 {
    default void abc() {
        System.out.println("I2 ABC");
        abc1();
    }
}

interface I3 extends I1 {
    default void abc() {
        System.out.println("I3 ABC");
        abc1();
    }
}
