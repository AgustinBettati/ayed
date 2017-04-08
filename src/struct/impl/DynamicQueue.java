package struct.impl;

import struct.istruct.Queue;

/**
 * Created by marcos on 8/4/17.
 */
public class DynamicQueue <T> implements Queue <T> {

    private Node back ;
    private int size = 0;
    private Node front;

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

    @Override
    public void enqueue(T t) {

        Node newNode = new Node(t);

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

    @Override
    public boolean isEmpty() {
        if (size==0){
            return true;
        }
        return false;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void empty() {
        size=0;
        back=front=null;
    }
}
