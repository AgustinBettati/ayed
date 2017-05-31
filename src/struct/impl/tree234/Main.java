package struct.impl.tree234;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Tree234<Integer> arbol = new Tree234<>();
        arbol.insert(5);
        arbol.insert(6);
        arbol.insert(4);
        arbol.insert(2);
        arbol.insert(10);
        arbol.insert(20);
        arbol.insert(8);

        arbol.print();

    }
}
