package struct.impl;

import struct.istruct.Queue;

/**
 * Created by marcos on 5/4/17.
 */
public class StaticQueue<T> implements Queue<T> {

        private int size;
        private int front;
        private T[] data;
        private int back;

    public StaticQueue(int capacity) {
        this.size = 0;
        this.front = 0;
        this.data = (T[])new Object[capacity];
        this.back = 0;
    }

    @Override
    public void enqueue(T t) {

    if (size== data.length-1){
      grow();
        size++;
      data[back]=t;
      back++;


    }
    else if (back== data.length-1){
        back=0;
        data[back]= t;
        size++;
    }
    else{
        data[back]=t;
       back++;
       size++;

    }
    }

    @Override
    public T dequeue() {
        T result;
        if (!isEmpty()&& front== data.length-1){
            result= data[front];
            front=0;
            size--;


        }
        else if (!isEmpty()){
            result=data[front];
            front++;
            size--;

        }
        else {
           throw new RuntimeException("The queue is empty");
        }
        return result;
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
        return data.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void empty() {
        front=0;
        back=0;

    }

    public void grow(){
        T[] aux=(T[])new Object[data.length*2];
        int auxiliar=0;
        for (int i= front;i<data.length;i++, auxiliar++){

            aux[auxiliar]= data[i];
        }
        for (int i=auxiliar,j=0;j<auxiliar;i++,j++){
            aux[i]= data[j];
        }
        back=size;
        front=0;

        data =aux;
    }

//    public static void main(String[] args) {
//        Queue<Integer> test= new StaticQueue<Integer>(4);
//
//        test.enqueue(1);
//        test.enqueue(2);
//        test.enqueue(3);
//        test.enqueue(3);
//        test.enqueue(4);
//        test.enqueue(5);
//        test.enqueue(6);
//        for (int i=0;i< 7;i++){
//            System.out.println(test.dequeue());
//        }
////        System.out.println(test.dequeue());
//    }

    public static void main(String[] args) {
        StaticQueue<Integer> queue = new StaticQueue<>(4);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);


        for (int i =0 ; i < 4; i++){
            System.out.println(queue.dequeue());
        }
        System.out.println();
        System.out.println(queue.size());
    }
}
