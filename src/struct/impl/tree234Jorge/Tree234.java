package struct.impl.tree234Jorge;
/**
 * Created by IntelliJ IDEA.
 * User: guest
 * Date: 02-jun-2006
 * Time: 14:15:42
 * To change this template use File | Settings | File Templates.
 */
public class Tree234 {

    private Node root;

    public Tree234(Comparable o) {
        Node2 node2 = new Node2();
        node2.data1 = o;
        root = node2;
        root.x = 400;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(Object o){
        Node node = root.search((Comparable) o);
        node = node.insert(o);
        Node father = node.getFather();
        if(father!=null){
            while(father.getFather() != null){
                father = father.getFather();
            }
            root = father;
        }
        else{
            root = node;
        }
    }

    public void print() {
        root.print();
    }
}
