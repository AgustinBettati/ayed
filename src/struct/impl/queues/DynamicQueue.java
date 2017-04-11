package struct.impl.queues;
import struct.istruct.Queue;

/**
 * @author Marcos Khabie
 * @author Agustin Bettati
 * @version 1.0
 *
 * A Queue is a data structure in which items are removed in the order in which they
 * where initially added, so the most recently added item is the last one removed.
 * This is also called first-in, first-out (FIFO).
 *
 * @param <T> Generics parameter
 */
public class DynamicQueue <T> implements Queue <T> {

    private Node back ;
    private int size = 0;
    private Node front;

    /**
     * Inner class which is used to store and connect all the information.
     */
    private class Node{
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * Adds a element to the back of the queue.
     * @param o
     */
    @Override
    public void enqueue(T o) {

        Node newNode = new Node(o);

        if(front == null){
            front = newNode;
            back=front;
        }
        else{
            back.next = newNode;
            back = newNode;
        }
        size++;
    }

    /**
     * Returns and removes the element that is found in the front of the queue.
     * @return
     */
    @Override
    public T dequeue() {
        Node result;
        if (back==null){
            throw new RuntimeException("Your queue is empty");
        }
        else {
            result=front;
            front=front.next;
            size--;
        }
        return result.data;
    }

    /**
     * Examines if the queue is empty, meaning it has no elements.
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (size==0){
            return true;
        }
        return false;
    }

    /**
     * Return the amount of elements present in the queue.
     * This method is identical to size() as it is a dynamic implementation.
     * @return
     */
    @Override
    public int length() {
        return size;
    }

    /**
     * Returns the amount of elements present in the queue.
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all the elements from the queue.
     */
    @Override
    public void empty() {
        size=0;
        back=front=null;
    }
}
