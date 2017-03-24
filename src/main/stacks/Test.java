package main.stacks;

import struct.impl.LinkedStack;
import struct.impl.StaticStack;

public class Test {

    public static void main(String[] args) {
        LinkedStack<Integer> stack1 = new LinkedStack<>();

        stack1.push(12);
        stack1.push(10);
        stack1.push(-3);
        stack1.push(5);
        System.out.println(stack1.size());

        for(int i = 0; i < 4; i++){
            System.out.println(stack1.peek());
            stack1.pop();
        }

        StaticStack<Integer> stack2 = new StaticStack<>(1);

        stack2.push(12);
        stack2.push(10);
        stack2.push(-3);
        stack2.push(5);
        System.out.println(stack2.size());

        for(int i = 0; i < 4; i++){
            System.out.println(stack2.peek());
            stack2.pop();
        }
    }
}
