package struct.impl.tree234Jorge;
/**
 * Created by IntelliJ IDEA.
 * User: guest
 * Date: 02-jun-2006
 * Time: 14:15:51
 * To change this template use File | Settings | File Templates.
 */
public abstract class Node {
    private Node father;
    public int type;
    int x;
    int y;
    public abstract Node search(Comparable c);
    public abstract boolean isLeaf();
    public abstract Node insert(Object object);
    public abstract void setChild(Comparable o,Node child);
    public abstract void print();
    public Node getFather() {
        return father;
    }
    public abstract Object[] getData();
    public void setFather(Node father) {
        this.father = father;
    }

}
