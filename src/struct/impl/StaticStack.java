package struct.impl;

import struct.istruct.Stack;

/**
 * Created by marcos on 24/3/17.
 */
public class StaticStack implements Stack{
    private int top;
    private int capacity;
    private int count;
    private Object[] data;

    public StaticStack(int x) {
        this.top = -1;
        this.capacity = x;

        this.data = new Object[capacity];
    }

    @Override
    public void push(Object o) {
        if(top+1==data.length){
            grow();
        }
        top++;
        data[top]= o;

    }

    @Override
    public void pop() {
        top--;

    }

    @Override
    public Object peek() {
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

        return top;
    }

    @Override
    public void empty() {
        top=-1;

    }
    private void grow(){
        Object [] data2 = new Object[2*capacity];
        for (int i =0; i<capacity;i++){
            data2[i]=data[i];
        }
        data = data2;
    }
}
