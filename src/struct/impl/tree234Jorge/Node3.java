package struct.impl.tree234Jorge;
/**
 * Created by IntelliJ IDEA.
 * User: guest
 * Date: 02-jun-2006
 * Time: 14:17:32
 * To change this template use File | Settings | File Templates.
 */
public class Node3 extends Node2{
    Object data2;
    private Node center1;

    public Node3() {
        type = 3;

    }

    public Node getCenter1() {
        return center1;
    }

    public void setCenter1(Node center1) {
        if(center1!=null){
            center1.setFather(this);
        }
        this.center1 = center1;
    }

    public Node4 convertTo4(Object o){
        Node4 node4 = new Node4();
        node4.setFather(getFather());
        node4.setLeft(getLeft());
        node4.setCenter1(center1);
        node4.setCenter2(center1);
        //tengo que ver aca cual realmente se asigna, si center1 o center2;
        node4.setRight(getRight());
        Comparable c = (Comparable)o;
        int comparedWithData1 = c.compareTo(data1);
        int comparedWithData2 = c.compareTo(data2);
        if(comparedWithData1<0){
            node4.data3 = data2;
            node4.data2 = data1;
            node4.data1 = c;
        }else{
            if(comparedWithData2<0){
                node4.data1 = data1;
                node4.data2 = c;
                node4.data3 = data2;
            }else{
                node4.data1= data1;
                node4.data2= data2;
                node4.data3= c;
            }
        }
        if(getFather()!=null) getFather().setChild((Comparable) o,node4);
        return node4;
    }

    public Node search(Comparable c) {
        int comparedWithData1 = c.compareTo(data1);
        int comparedWithData2 = c.compareTo(data2);
        if(this.isLeaf()) return this;
        else{
            if(comparedWithData1<0) return getLeft().search(c);
            else{
                if(comparedWithData2<0) return getCenter1().search(c);
                else{
                    return getRight().search(c);
                }
            }
        }
    }

    public void print() {
        System.out.println("D1: "+data1 + " D2: "+data2);
        if(getLeft()!=null) getLeft().print();
        if(center1!=null) center1.print();
        if(getRight()!=null) getRight().print();
    }

    public Node insert(Object o) {
        return convertTo4(o);
    }

    public void setChild(Comparable o, Node child) {
        int comparedWithData1 = o.compareTo(data1);
        int comparedWithData2 = o.compareTo(data2);
        if(comparedWithData1<0) setLeft(child);
        else{
            if(comparedWithData2<0) setCenter1(child);
            else{
                setRight(child);
            }
        }
    }
    public Object[] getData() {
        Object[] array = new Object[2];
        array[0] = data1;
        array[1] = data2;
        return array ;
    }
}
