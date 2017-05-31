package struct.impl;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class RedBlackTest {

    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(5);
        tree.insert(7);
        tree.insert(9);
        tree.insert(4);
        tree.insert(3);
    }
}
