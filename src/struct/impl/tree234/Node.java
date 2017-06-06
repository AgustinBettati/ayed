package struct.impl.tree234;
/**
 * Created by IntelliJ IDEA.
 * User: guest
 * Date: 02-jun-2006
 * Time: 14:15:51
 * To change this template use File | Settings | File Templates.
 */
public abstract class Node <J extends Comparable<J>> {
    private Node<J> father;
    public int type;
    public int x;
    public int y;
    public abstract Node<J> search(J c);
    public abstract boolean isLeaf();
    public abstract Node<J> insert(J object);
    public abstract void setChild(J o,Node<J> child);
    public abstract void print();
    public Node<J> getFather() {
        return father;
    }
    public abstract Object[] getData();
    public void setFather(Node<J> father) {
        this.father = father;
    }

}
