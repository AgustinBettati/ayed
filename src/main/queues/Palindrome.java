package main.queues;

import struct.impl.queues.DynamicQueue;
import struct.impl.stacks.LinkedStack;
import struct.istruct.Queue;
import struct.istruct.Stack;

/**
 * Created by marcos on 10/4/17.
 */
public class Palindrome {



    public boolean isPalindrome(String word) {
        Stack<Character> wordInStack= new LinkedStack<>();
        Queue<Character> wordInQueue= new DynamicQueue<>();

        for (int i = 0; i < word.length(); i++) {
            wordInQueue.enqueue(word.charAt(i));
            wordInStack.push(word.charAt(i));
        }
        while (!wordInQueue.isEmpty()) {
            if (!(wordInQueue.dequeue().equals(wordInStack.peek()))) {
                return false;
            }
            wordInStack.pop();
        }
        return true;
    }


    public static void main(String[] args) {
        String a = "hola";
        String b = "ala";
        Palindrome c= new Palindrome();
        System.out.println(c.isPalindrome(a));
        System.out.println(c.isPalindrome(b));
    }
}