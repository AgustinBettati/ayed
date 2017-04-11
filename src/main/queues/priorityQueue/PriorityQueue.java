package main.queues.priorityQueue;

import struct.impl.queues.DynamicQueue;
import java.util.HashMap;
/**
 * @author Marcos Khabie
 * @author Agustin Bettati
 * @version 1.0
 *
 * Priority queue is abstract data type that stores elements taking into account a
 * certain value that represents its priority. Each priority has its own queue.
 * When making a dequeue it will remove the element in the front of the queue that
 * has the highest priority.
 *
 * @param <T> Generics parameter
 */
public class PriorityQueue<T> {

    private HashMap<Integer, DynamicQueue<T>> queues;
    private int size;

    /**
     * Creates a priority queue and initializes its variables.
     */
    public PriorityQueue(){
        queues = new HashMap<>();
        size = 0;
    }

    /**
     * Adds an element to the queue given a specific priority for this element.
     * @param element
     * @param priority
     */
    public void enqueue(T element, int priority){
        if(priority <= 0){
            throw new RuntimeException("Invalid priority");
        }
        if(queues.containsKey(priority)){
            queues.get(priority).enqueue(element);
        }
        else{
            DynamicQueue<T> newQueue = new DynamicQueue<T>();
            newQueue.enqueue(element);
            queues.put(priority, newQueue);
        }
        size++;
    }

    /**
     * Returns the first element of the queue which has the highest priority.
     * @return
     */
    public T dequeue(){
        if(queues.isEmpty()){
            throw new RuntimeException("PriorityQueue is empty");
        }
        int queueWithHighestPriority = 1;
        while(!queues.containsKey(queueWithHighestPriority)) {
            queueWithHighestPriority++;
        }
        T value = queues.get(queueWithHighestPriority).dequeue();

        if(queues.get(queueWithHighestPriority).isEmpty()){
            queues.remove(queueWithHighestPriority);
        }
        size--;
        return value;
    }

    /**
     * Returns the amount of elements that are present in the queue.
     * @return
     */
    public int size(){
        return size;
    }


}
