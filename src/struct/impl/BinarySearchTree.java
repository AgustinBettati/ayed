package struct.impl;


/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class BinarySearchTree<T extends Comparable<T>>{
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
    // precondicion: árbol distinto de vacío
    public T getMin(){ return getMin(root).data;
    }
    // precondicion: árbol distinto de vacío
    public T getMax(){ return getMax(root).data;
    }

    public T search(T x){ return buscar(root, x).data;
    }

//    public void insertar(Comparable x){ root = insertar(root, x);
//    }
//
//    public void eliminar(Comparable x){ root = eliminar(root, x);
//    }

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
    private DoubleNode buscar(DoubleNode t, T x){
        if (x.compareTo( t.data)== 0)
            return t;
        else if (x.compareTo( t.data)< 0)
            return buscar(t.left, x);
        else
            return buscar(t.right, x);
    }
//    private NodoDoble insertar (NodoDoble t, Comparable x) { if (t == null){
//        t = new NodoDoble();
//        t.elem = x; }
//    else if (x.compareTo(t.elem) < 0) t.izq = insertar(t.izq, x);
//    else
//        t.der = insertar(t.der, x); return t;
//    }
//    private NodoDoble eliminar (NodoDoble t, Comparable x) {
//        if (x.compareTo(t.elem) < 0)
//        t.izq = eliminar(t.izq, x); else if (x.compareTo(t.elem) > 0) t.der = eliminar(t.der, x);
//    else
//    if (t.izq != null && t.der != null ) {
//        t.elem = getMin(t.der).elem;
//        t.der = eliminarMin(t.der);
//    }
//    else if (t.izq != null) t = t.izq;
//    else
//        t =t.der; return t;
//    }
    private DoubleNode eliminarMin(DoubleNode t){
        if (t.left != null){
            t.left = eliminarMin(t.left);
        }
        else {
            t = t.right;
        }

        return t;
    }
}

