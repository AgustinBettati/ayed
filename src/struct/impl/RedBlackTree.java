package struct.impl;

import struct.istruct.BinaryTree;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 */
public class RedBlackTree<T extends Comparable<T>> implements BinaryTree<T> {

    private RedBlackNode root;

    public RedBlackTree(){
        root = null;
    }

    private class RedBlackNode{
        public static final int RED = 1;
        public static final int BLACK = 0;

        T data;
        int color;
        RedBlackNode left;
        RedBlackNode right;
        RedBlackNode parent;

        public RedBlackNode(T data, int color){
            this.data = data;
            this.color = color;
            left = null;
            right = null;
            parent = null;
        }

        public RedBlackNode getUncle(){
            RedBlackNode grandfather = parent.parent;
            if(grandfather.left == parent){
                return grandfather.right;
            }
            else{
                return grandfather.left;
            }
        }
    }

    public void insert(T data){
        RedBlackNode newNode = new RedBlackNode(data, RedBlackNode.RED);
        accomodateInTree(newNode);
        fixInsertion(newNode);
    }

    private void accomodateInTree(RedBlackNode newNode){

        RedBlackNode currentNode = null;
        RedBlackNode ahead = root;
        while(ahead != null){
            currentNode = ahead;

            if(newNode.data.compareTo(ahead.data) < 0){
                ahead = ahead.left;
            }
            else {
                ahead = ahead.right;
            }
        }
        newNode.parent = currentNode;
        if(currentNode == null){
            root = newNode;
        }
        else if(newNode.data.compareTo(currentNode.data) < 0){
            currentNode.left = newNode;
        }
        else{
            currentNode.right = newNode;
        }
    }

    private void fixInsertion(RedBlackNode node){
        if(node != root){
            if(node.parent.color == RedBlackNode.RED){

                RedBlackNode parent = node.parent;
                if(node.getUncle().color == RedBlackNode.BLACK){
                    //rotacion
                }
                else{
                    parent.color = RedBlackNode.BLACK;
                    node.getUncle().color = RedBlackNode.BLACK;
                    parent.parent.color = RedBlackNode.RED;
                    fixInsertion(parent.parent);
                }
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    @Override
    public T getRoot() {
        return root.data;
    }

    @Override
    public RedBlackTree<T> getLeft() {
        RedBlackTree<T> tree = new RedBlackTree<>();
        tree.root = root.left;
        return tree;
    }

    @Override
    public RedBlackTree<T> getRight() {
        RedBlackTree<T> tree = new RedBlackTree<>();
        tree.root = root.right;
        return tree;
    }
}
