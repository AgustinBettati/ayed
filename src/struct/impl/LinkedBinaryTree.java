package struct.impl;

import struct.istruct.BinaryTree;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class LinkedBinaryTree<T> implements BinaryTree<T>{

    private DoubleNode root;

    public LinkedBinaryTree(){
        root = null;
    }

    public LinkedBinaryTree(T o){
        root = new DoubleNode(o);
    }

    public LinkedBinaryTree(T o, LinkedBinaryTree<T> leftTree, LinkedBinaryTree<T> rightTree){
        root = new DoubleNode(o, leftTree.root, rightTree.root);
    }

    private class DoubleNode{
        T data;
        DoubleNode left;
        DoubleNode right;

        public DoubleNode(T data){
            this.data = data;
        }

        public DoubleNode(T data, DoubleNode left, DoubleNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }
    @Override
    public boolean isEmpty() {
        if(root == null){
            return true;
        }
        return false;
    }

    @Override
    public T getRoot() {
        return root.data;
    }

    @Override
    public BinaryTree<T> getLeft() {
        LinkedBinaryTree<T> leftTree = new LinkedBinaryTree<>();
        leftTree.root = root.left;
        return leftTree;

    }

    @Override
    public BinaryTree<T> getRight() {
        LinkedBinaryTree<T> rightTree = new LinkedBinaryTree<>();
        rightTree.root = root.left;
        return rightTree;
    }
}
