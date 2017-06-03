package main.testOfRedBlackAnd234Tree;

import main.util.Scanner;
import struct.impl.RedBlackTree;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class RedBlackTreeTest {

    public static void main(String[] args) {
        RedBlackTree<Integer> rbTree = new RedBlackTree<>();
        RedBlackImageCreator imageCreator = new RedBlackImageCreator();

        System.out.println("Enter 0 when you want to view the red-black tree. ");
        while(true){
            int newDni = Scanner.getInt("Enter DNI: ");
            if(newDni == 0){
                imageCreator.drawTree(rbTree);
                System.exit(0);
            }
            rbTree.insert(newDni);
        }
    }

}
