package struct.impl;


import struct.istruct.BinaryTree;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 */
public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T>{
    private DoubleNode root;

    public BinarySearchTree(){
        root = null;
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

    public boolean isEmpty(){
        return (root == null);
    }

    public T getRoot(){
        return root.data;
    }

    public BinarySearchTree<T> getLeft(){
        BinarySearchTree<T> tree = new BinarySearchTree<T>();
        tree.root = root.left;
        return tree;
    }

    public BinarySearchTree<T> getRight(){
        BinarySearchTree<T> tree = new BinarySearchTree<T>();
        tree.root = root.right;
        return tree;
    }

    public boolean isPresent(T x){
        return isPresent(root, x);
    }

    public T getMin(){ return getMin(root).data;
    }

    public T getMax(){ return getMax(root).data;
    }

    public T search(T x){
        return search(root, x).data;
    }

    public void insert(T x){
        if (isPresent(x)){
            throw new RuntimeException("this element is already present in the tree");
        }
        root = insert(root, x);


    }

    public void delete(T x){
        if (!isPresent(x)){
            throw new RuntimeException("this element is not present in the tree");
        }
        root = delete(root, x);
    }

    private boolean isPresent(DoubleNode t, T x) {
        if (t == null)
        return false;
        if (x.compareTo(t.data) == 0)
            return true;
        else if (x.compareTo( t.data)< 0)
            return isPresent(t.left, x);
        else
            return isPresent(t.right, x);
    }

    private DoubleNode getMin(DoubleNode t){
        if (t.left == null)
            return t;
        else
            return getMin(t.left);
    }

    private DoubleNode getMax(DoubleNode t){
        if (t.right == null)
            return t;
        else
            return getMax(t.right);
    }
    private DoubleNode search(DoubleNode t, T x){
        if (x.compareTo( t.data)== 0)
            return t;
        else if (x.compareTo( t.data)< 0)
            return search(t.left, x);
        else
            return search(t.right, x);
    }


    private DoubleNode insert (DoubleNode t, T x)  {
        if (t == null)
            t = new DoubleNode(x);

        else if (x.compareTo(t.data) < 0)
            t.left = insert(t.left, x);

        else
            t.right = insert(t.right, x);

        return t;
    }
    private DoubleNode delete (DoubleNode t, T x) {
        if (x.compareTo(t.data) < 0)
            t.left = delete(t.left, x);
        else if (x.compareTo(t.data) > 0)
            t.right = delete(t.right, x);
        else {
            if (t.left != null && t.right != null) {
                t.data = getMin(t.right).data;
                t.right = deleteMin(t.right);
            }
            else if (t.left != null) t = t.left;
            else
                t = t.right;
        }
        return t;

    }


    private DoubleNode deleteMin(DoubleNode t){
        if (t.left != null){
            t.left = deleteMin(t.left);
        }
        else {
            t = t.right;
        }

        return t;
    }
}

