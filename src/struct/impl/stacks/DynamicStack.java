package struct.impl.stacks;
import struct.istruct.Stack;

/**
 * @author Marcos Khabie
 * @author Agustin Bettati
 * @version 1.0
 *
 * A Stack is a data structure in which items are removed in the reverse order from
 * that in which they are added, so the most recently added item is the first one removed.
 * This is also called last-in, first-out (LIFO). Adding an item to a stack is called pushing.
 * The linked stack is implemented using nodes.
 *
 * @param <T> Generics parameter
 */
public class DynamicStack<T> implements Stack<T>{

    private int size = 0;
    private Node first;

    /**
     * Inner class which is used to store data and connect all the information.
     */
    private class Node{
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }
    }


    /**
     * This method is used to add an element to the stack.
     * @param element
     */
    @Override
    public void push(T element) {
        Node newNode = new Node(element);

        if(first == null){
            first = newNode;
        }
        else{
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    /**
     * This method removes the element at the top of the stack.
     */
    @Override
    public void pop() {
        if(!isEmpty()){
            first = first.next;
            size--;
        }
    }

    /**
     * Returns the element at the top of the stack
     * @return
     */
    @Override
    public T peek() {
        if(first == null){
            return null;
        }
        return first.data;
    }

    /**
     * Evaluates if the stack is empty.
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (first == null){
            return true;
        }
        return false;
    }

    /**
     * Return the amount of elements contained in the stack
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all the elements from the stack
     */
    @Override
    public void empty() {
        first = null;
    }

}
