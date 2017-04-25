package main.parcialMarcosKhabie;

import struct.impl.BinarySearchTree;
import struct.istruct.BinaryTree;

/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class Bank {

    private BinarySearchTree<Account> binarySearchTreeA;
    private BinarySearchTree<Account> binarySearchTreeB ;

    public Bank(BinaryTree<Account> oldBinaryTree) {
        this.binarySearchTreeA =new BinarySearchTree<>();
        this.binarySearchTreeB = new BinarySearchTree<>();
        divideInTwo(oldBinaryTree);
    }

    private void divideInTwo(BinaryTree<Account> accounts) {


        if (!accounts.isEmpty()) {
            if (accounts.getRoot().getSucursal().equals("A")) {
                binarySearchTreeA.insert(accounts.getRoot());
                divideInTwo(accounts.getLeft());
                divideInTwo(accounts.getRight());
            } else if (accounts.getRoot().getSucursal().equals("B")) {
                binarySearchTreeB.insert(accounts.getRoot());
                divideInTwo(accounts.getLeft());
                divideInTwo(accounts.getRight());
            }

        }

    }

    public BinarySearchTree<Account> getBinarySearchTreeA() {
        return binarySearchTreeA;
    }

    public BinarySearchTree<Account> getBinarySearchTreeB() {
        return binarySearchTreeB;
    }
}
