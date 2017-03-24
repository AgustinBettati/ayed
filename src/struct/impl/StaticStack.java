package struct.impl;

import struct.istruct.Stack;


public class StaticStack<T> implements Stack<T>{
    private int top;
    private int capacity;
    private T[] data;

    public StaticStack(int x) {
        top = -1;
        capacity = x;
        data = (T[])new Object[capacity];
    }

    @Override
    public void push(T element) {
        if(top+1==data.length){
            grow();
        }
        top++;
        data[top]= element;

    }

    @Override
    public void pop() {
        top--;

    }

    @Override
    public T peek() {
        if (!isEmpty()){
            return data[top];
        }
        return null;

    }

    @Override
    public boolean isEmpty() {
        if (top == -1){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return top + 1;
    }

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
