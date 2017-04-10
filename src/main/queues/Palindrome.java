package main.queues;

import struct.istruct.Queue;
import struct.istruct.Stack;

/**
 * Created by marcos on 10/4/17.
 */
public class Palindrome {

    private Stack<Character> wordInStack;
    private Queue<Character> wordInQueue;

    public boolean isPalindrome(String word) {
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
        return false;
    }


    public static void main(String[] args) {
        String a = "hola";
        String b = "ala";
        Palindrome c= new Palindrome();
        System.out.println(c.isPalindrome(a));
        System.out.println(c.isPalindrome(b));
    }
}