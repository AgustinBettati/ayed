package main.testOfRedBlackAnd234Tree;

import main.util.Scanner;
import struct.impl.tree234.Tree234;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Tree234Test {
    public static void main(String[] args) {
        Tree234<Integer> tree234 = new Tree234<>();

        System.out.println("Enter 0 when you want to view the 234 tree. ");
        while(true){
            int newDni = Scanner.getInt("Enter DNI: ");
            if(newDni == 0){
              //  print234Tree(tree234);
                System.exit(0);
            }
            tree234.insert(newDni);
        }
    }


}
