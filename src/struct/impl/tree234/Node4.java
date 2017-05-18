package struct.impl.tree234;



/**
 * Created by IntelliJ IDEA.
 * User: guest
 * Date: 02-jun-2006
 * Time: 14:17:36
 * To change this template use File | Settings | File Templates.
 */
public class Node4<T extends Comparable<T>> extends Node3<T> {
    T data3;
    Node<T> center2;

    public Node4() {
        type = 4;
    }

    public Node<T> getCenter2() {
        return center2;
    }

    public void setCenter2(Node<T> center2) {
        if(center2!=null){
            center2.setFather(this);
        }
        this.center2 = center2;
    }

    public Node<T> search(T c) {
        Node<T> node = destroy();
        return node.search(c);
    }

    public void print() {
        System.out.println("Type4 (d1: "+data1 + ", d2: "+data2+", d3: "+data3+ ")");
        if(getLeft()!=null) getLeft().print();
        if(getCenter1()!=null) getCenter1().print();
        if(center2!=null) center2.print();
        if(getRight()!=null) getRight().print();
    }

    public Node<T> insert(T o) {
        setFather(destroy());
        return getFather().insert(o);
    }

    public Node<T> destroy() {
        if(getFather()==null){
            setFather(new Node2<T>());
        }
        setFather(getFather().insert(data2));
        Node2<T> nodeR = new Node2<T>();
        nodeR.data1 = data3;
        nodeR.setFather(getFather());
        nodeR.setLeft(center2);
        nodeR.setRight(getRight());
        Node2<T> nodeL = new Node2<T>();
        nodeL.data1 = data1;
        nodeL.setFather(getFather());
        nodeL.setLeft(getLeft());
        nodeL.setRight(getCenter1());
        getFather().setChild(nodeR.data1,nodeR);
        getFather().setChild(nodeL.data1,nodeL);
        return getFather();
    }

    public void setChild(T o, Node<T> child) {
        int comparedWithData1 = o.compareTo(data1);
        int comparedWithData2 = o.compareTo(data2);
        int comparedWithData3 = o.compareTo(data3);
        if(comparedWithData1<0) setLeft(child);
        else{
            if(comparedWithData2<0) setCenter1(child);
            else{
                if(comparedWithData3<0) setCenter2(child);
                else{
                    setRight(child);
                }
            }
        }
    }
    public T[] getData() {
        T[] array = (T[])new Object[3];
        array[0] = data1;
        array[1] = data2;
        array[2] = data3;
        return array ;
    }
}
