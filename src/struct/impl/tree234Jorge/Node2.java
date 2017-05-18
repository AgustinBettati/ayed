package struct.impl.tree234Jorge;
/**
 * Created by IntelliJ IDEA.
 * User: guest
 * Date: 02-jun-2006
 * Time: 14:17:16
 * To change this template use File | Settings | File Templates.
 */
public class Node2 extends Node{
    Object data1;
    private Node left;
    private Node right;

    public Node2() {
        type = 2;
    }


    public Node3 convertTo3(Object o){
        Node3 node3 = new Node3();
        node3.setFather(this.getFather());
        node3.setLeft(left);
        node3.setRight(right);
        Comparable c = (Comparable)o;
        if(c.compareTo(data1)>0){
            node3.data2 = c;
            node3.data1 = data1;
        }else{
            node3.data2 = data1;
            node3.data1 = c;
        }
        if(getFather()!=null)getFather().setChild((Comparable) o,node3);
        return node3;
    }

    public Node search(Comparable c) {
        int comparedWithData1 = c.compareTo(data1);
        if(this.isLeaf()) return this;
        else{
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

    public Node insert(Object o) {
        if(data1==null){
            data1 = o;
            return this;
        }else{
            return convertTo3(o);
        }
    }

    public void setChild(Comparable o,Node child) {
        int comparedWithData1 = o.compareTo(data1);
        if(comparedWithData1>0) this.setRight(child);
        else this.setLeft(child);
    }

    public void print() {
        System.out.println("D1: "+data1);
        if(left!=null) left.print();
        if(right!=null) right.print();
    }

    public Object[] getData() {
        Object[] array = new Object[1];
        array[0] = data1;
        return array ;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
        if(left!=null){
            left.setFather(this);
        }
    }


    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
        if(right!=null){
            right.setFather(this);
        }
    }

}
