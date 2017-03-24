package struct.impl;


import struct.istruct.Stack;

public class LinkedStack<T> implements Stack<T>{

    private int size = 0;
    private Node first;

    private class Node{
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }
    }

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

    @Override
    public void pop() {
        if(!isEmpty()){
            first = first.next;
            size--;
        }
    }

    @Override
    public T peek() {
        return first.data;
    }

    @Override
    public boolean isEmpty() {
        if (first == null){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void empty() {
        first = null;
    }

}
