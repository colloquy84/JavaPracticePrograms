package com.pandeyar;

public class PStack {
    protected Object[] head;
    protected int pointer;

    public PStack(int capacity) {
        head = new Object[capacity];
        pointer = -1;
    }

    public static void main(String[] args) {
        PStack stack = new PStack(200);
        stack.push("abc");
        stack.push("abc1");
        stack.push("abc2");
        stack.push("abc3");
        stack.push("abc4");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public boolean isEmpty() {
        return pointer == -1;
    }

    public void push(Object i) {
        if (pointer + 1 < head.length)
            head[++pointer] = i;
    }

    public Object pop() {
        if (isEmpty())
            return null;
        return head[pointer--];
    }
}
