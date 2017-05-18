package struct.impl.tree234;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Tree234<Integer> arbol = new Tree234<>();
        arbol.insert(new Integer(5));
        arbol.insert(new Integer(6));
        arbol.insert(new Integer(4));
        arbol.insert(new Integer (2));
        arbol.insert(new Integer (10));
        arbol.insert(new Integer (20));
        arbol.insert(new Integer (8));

        arbol.print();

    }
}
