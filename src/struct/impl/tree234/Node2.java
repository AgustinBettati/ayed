package struct.impl.tree234;



/**
 * Created by IntelliJ IDEA.
 * User: guest
 * Date: 02-jun-2006
 * Time: 14:17:16
 * To change this template use File | Settings | File Templates.
 */
public class Node2<T extends Comparable<T>> extends Node<T>{
    T data1;
    private Node<T> left;
    private Node<T> right;

    public Node2() {
        type = 2;
    }


    public Node3<T> convertTo3(T o){
        Node3<T> node3 = new Node3();
        node3.setFather(this.getFather());
        node3.setLeft(left);
        node3.setRight(right);
        if(o.compareTo(data1)>0){
            node3.data2 = o;
            node3.data1 = data1;
        }else{
            node3.data2 = data1;
            node3.data1 = o;
        }
        if(getFather()!=null)getFather().setChild(o,node3);
        return node3;
    }

    public Node<T> search(T c) {

        if(this.isLeaf()) return this;
        else{
            int comparedWithData1 = c.compareTo(data1);
            if(comparedWithData1>0){
                return right.search(c);
            }else{
                return left.search(c);
            }
        }
    }

    public boolean isLeaf() {
        if(left ==null && right == null) return true;
        else return false;
    }

    public Node<T> insert(T o) {
        if(data1==null){
            data1 = o;
            return this;
        }else{
            return convertTo3(o);
        }
    }

    public void setChild(T o,Node<T> child) {
        int comparedWithData1 = o.compareTo(data1);
        if(comparedWithData1>0) this.setRight(child);
        else this.setLeft(child);
    }

    public void print() {
        System.out.println("Type2 (d1: "+data1 + ")");
        if(left!=null) left.print();
        if(right!=null) right.print();
    }

    public Object[] getData() {
        Object[] array = new Object[1];
        array[0] = data1;
        return array ;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
        if(left!=null){
            left.setFather(this);
        }
    }


    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
        if(right!=null){
            right.setFather(this);
        }
    }

}
