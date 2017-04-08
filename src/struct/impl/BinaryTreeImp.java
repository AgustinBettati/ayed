package struct.impl;

import struct.istruct.BinaryTree;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class BinaryTreeImp<T> implements BinaryTree<T>{

    private DoubleNode root;

    public BinaryTreeImp(){
        root = null;
    }

    public BinaryTreeImp(T o){
        root = new DoubleNode(o);
    }

    public BinaryTreeImp(T o, BinaryTreeImp<T> leftTree, BinaryTreeImp<T> rightTree){
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
        BinaryTreeImp<T> leftTree = new BinaryTreeImp<>();
        leftTree.root = root.left;
        return leftTree;

    }

    @Override
    public BinaryTree<T> getRight() {
        BinaryTreeImp<T> rightTree = new BinaryTreeImp<>();
        rightTree.root = root.left;
        return rightTree;
    }
}
