package struct.impl;

import struct.istruct.Stack;

/**
 * @author Marcos Khabie
 * @author Agustin Bettati
 * @version 1.0
 *
 * A Stack is a data structure in which items are removed in the reverse order from
 * that in which they are added, so the most recently added item is the first one removed.
 * This is also called last-in, first-out (LIFO). Adding an item to a stack is called pushing.
 * The static stack is implemented using a generic array.
 *
 * @param <T> Generics parameter
 */
public class StaticStack<T> implements Stack<T>{
    private int top;
    private int capacity;
    private T[] data;

    /**
     * creates a stack with an initial capacity.
     * @param x
     */
    public StaticStack(int x) {
        top = -1;
        capacity = x;
        data = (T[])new Object[capacity];
    }

    /**
     * This method is used to add an element to the stack.
     * @param element
     */
    @Override
    public void push(T element) {
        if(top+1==data.length){
            grow();
        }
        top++;
        data[top]= element;

    }

    /**
     * This method removes the element at the top of the stack.
     */
    @Override
    public void pop() {
        top--;

    }

    /**
     * Returns the element at the top of the stack
     * @return
     */
    @Override
    public T peek() {
        if (!isEmpty()){
            return data[top];
        }
        return null;

    }

    /**
     * Evaluates if the stack is empty.
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (top == -1){
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
        return top + 1;
    }

    /**
     * Removes all the elements from the stack
     */
    @Override
    public void empty() {
        top=-1;
    }

    private void grow(){
        T[] temp = (T[]) new Object[2*capacity];
        for (int i =0; i<capacity;i++){
            temp[i]=data[i];
        }
        data = temp;
        capacity = 2*capacity;
    }
}
