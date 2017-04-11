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
public class StaticQueue<T> implements Queue<T> {

    private int front;
    private int back;
    private int size;
    private T[] data;

    /**
     * Creates a queue, and initializes all of its variables.
     * @param initialCapacity
     */
    public StaticQueue(int initialCapacity){
        front = 0;
        back = 0;
        size = 0;
        data = (T[])new Object[initialCapacity];
    }

    /**
     * Adds a element to the back of the queue.
     * @param o
     */
    @Override
    public void enqueue(T o) {

        if(size < data.length){
            data[back] = o;
            back = nextIndex(back);
            size++;
        }
        else {
            grow();
            data[back] = o;
            back = nextIndex(back);
            size++;
        }

    }

    /**
     * Returns and removes the element that is found in the front of the queue.
     * @return
     */
    @Override
    public T dequeue() {
        if(!isEmpty()){
            T valueToReturn = data[front];
            front = nextIndex(front);
            size--;
            return valueToReturn;
        }
        else {
            throw  new RuntimeException("Empty queue");
        }

    }

    /**
     * Examines if the queue is empty, meaning it has no elements.
     * @return
     */
    @Override
    public boolean isEmpty() {


        if(size <= 0){
            return true;
        }
        return false;
    }

    /**
     * Return the size of the array that contains the elements of the queue.
     * @return
     */
    @Override
    public int length() {
        return data.length;
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

        front = 0;
        back = 0;
        size = 0;
    }

    private void grow(){
        T[] newArray = (T[])new Object[data.length *2];

        int j= 0;
        for(int i = front; i < data.length; i++, j++){
            newArray[j] = data[i];
        }
        for(int i = 0;i < back;j++, i++){
            newArray[j] = data[i];
        }

        data = newArray;
        front = 0;
        back = size;
    }

    private int nextIndex(int currentIndex){
        if(currentIndex + 1 >= data.length)
            return 0;

        return currentIndex + 1;

    }
}
