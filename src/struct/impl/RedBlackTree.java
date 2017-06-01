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

    public class RedBlackNode{
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
            if(grandfather == null){
                throw new RuntimeException("cannot find uncle");
            }
            if(grandfather.left == parent){
                return grandfather.right;
            }
            else{
                return grandfather.left;
            }
        }

        public boolean isLeftNode(){
            if(parent.left == this){
                return true;
            }
            else{
                return false;
            }
        }

        public T getData(){
            return data;
        }
        public int getColor(){
            return color;
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
                if(node.getUncle() == null || node.getUncle().color == RedBlackNode.BLACK){
                    if(isExternal(node)){
                        simpleRotation(node);
                    }
                    else{
                        doubleRotation(node);
                    }
                }
                else{
                    // Caso 4
                    parent.color = RedBlackNode.BLACK;
                    node.getUncle().color = RedBlackNode.BLACK;
                    parent.parent.color = RedBlackNode.RED;
                    fixInsertion(parent.parent);
                }
            }
        }
        else {
            node.color = RedBlackNode.BLACK;
        }
    }

    private boolean isExternal(RedBlackNode node){
        RedBlackNode grandfather = node.parent.parent;
        RedBlackNode parent = node.parent;

        if(node.data.compareTo(parent.data) > 0
                && parent.data.compareTo(grandfather.data) > 0){
            return true;
        }
        if(node.data.compareTo(parent.data) < 0
                && parent.data.compareTo(grandfather.data) < 0){
            return true;
        }
        return false;
    }

    /**
     * Caso 2
     * @param node
     */
    private void simpleRotation(RedBlackNode node){
        RedBlackNode grandfather = node.parent.parent;
        RedBlackNode parent = node.parent;

        if(grandfather == root){
            root = parent;
        }
        else{
            RedBlackNode upperNode = grandfather.parent;
            if(grandfather.isLeftNode()){
                upperNode.left = parent;
            }
            else {
                upperNode.right = parent;
            }
        }
        if(node.data.compareTo(parent.data) < 0){
            RedBlackNode q = parent.right;

            parent.parent = grandfather.parent;
            parent.right = grandfather;

            grandfather.left = q;
            grandfather.parent = parent;
        }
        else{
            RedBlackNode q = parent.left;

            parent.parent = grandfather.parent;
            parent.left = grandfather;

            grandfather.parent = parent;
            grandfather.right = q;
        }

        grandfather.color = RedBlackNode.RED;
        parent.color = RedBlackNode.BLACK;
        node.color = RedBlackNode.RED;
    }

    /**
     * Caso 3
     * @param node
     */
    private void doubleRotation(RedBlackNode node){
        RedBlackNode grandfather = node.parent.parent;
        RedBlackNode parent = node.parent;
        RedBlackNode r = node.left;
        RedBlackNode q = node.right;

        if(grandfather == root){
            root = node;
        }
        else{
            RedBlackNode upperNode = grandfather.parent;
            if(grandfather.isLeftNode()){
                upperNode.left = node;
            }
            else {
                upperNode.right = node;
            }
        }
        if(node.data.compareTo(parent.data) > 0){

            node.left = parent;
            node.right = grandfather;
            node.parent = grandfather.parent;

            grandfather.parent = node;
            grandfather.left = q;

            parent.parent = node;
            parent.right = r;
        }
        else{
            node.parent = grandfather.parent;
            node.left = grandfather;
            node.right = parent;

            grandfather.parent = node;
            grandfather.right = r;

            parent.parent = node;
            parent.left = q;
        }
        node.color = RedBlackNode.BLACK;
        parent.color = RedBlackNode.RED;
        grandfather.color = RedBlackNode.RED;
    }

    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    @Override
    public T getRoot() {
        return root.data;
    }

    /**
     * This method is only used to simplify the process of printing the tree
     * @return
     */
    public RedBlackNode getNode(){
        return root;
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
