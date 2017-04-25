package main.parcialMarcosKhabie;

import struct.impl.LinkedBinaryTree;
import struct.istruct.BinaryTree;

/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class Test {


    public static void main(String[] args) {
        Account account1= new Account("A",12);
        Account account2= new Account("A",9);
        Account account3= new Account("B",15);
        Account account4= new Account("A",21);
        Account account5= new Account("B",3);
        Account account6= new Account("A",4);
        Account account7= new Account("B",30);
        LinkedBinaryTree<Account> subBinaryTree= new LinkedBinaryTree<>(account3,new LinkedBinaryTree<>(account4),new LinkedBinaryTree<>(account5,new LinkedBinaryTree<>(account6),new LinkedBinaryTree<>(account7)));
        LinkedBinaryTree<Account> oldLinkedBinaryTree= new LinkedBinaryTree<>(account1,new LinkedBinaryTree<>(account2),subBinaryTree);

        Bank bank=new Bank(oldLinkedBinaryTree);
        System.out.println("Elements from the old tree:");
        printBinaryTree(oldLinkedBinaryTree);
        System.out.println("------------------");
        System.out.println("Elements from the tree A");
        printBinaryTree(bank.getBinarySearchTreeA());
        System.out.println("------------------");
        System.out.println("Elements from the tree B:");
        printBinaryTree(bank.getBinarySearchTreeB());








    }
    private static void printBinaryTree(BinaryTree<Account> binaryTree){

        if (!binaryTree.isEmpty()){
            System.out.println(binaryTree.getRoot().getNumber() + binaryTree.getRoot().getSucursal());

            printBinaryTree(binaryTree.getRight());
            printBinaryTree(binaryTree.getLeft());

        }

    }
}
