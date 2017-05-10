package main.queues;

import struct.impl.queues.DynamicQueue;
import struct.impl.stacks.DynamicStack;
import struct.istruct.Queue;
import struct.istruct.Stack;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * A class that tests and contains the functionality of seeing if a phrase or word is
 * palindrome.
 */
public class Palindrome {

    /**
     * Examines if a word or phrase is palindrome.
     * @param word
     * @return
     */
    public boolean isPalindrome(String word) {
        Stack<Character> wordInStack= new DynamicStack<>();
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

    /**
     * Simple test.
     * @param args
     */
    public static void main(String[] args) {
        String a = "hola aloh";
        String b = "ala";
        Palindrome c= new Palindrome();
        System.out.println(c.isPalindrome(a));
        System.out.println(c.isPalindrome(b));
    }
}