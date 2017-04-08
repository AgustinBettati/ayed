package struct.impl.queues;
import struct.istruct.Queue;


/**
 * Created by marcos on 5/4/17.
 */


public class StaticQueue<T> implements Queue<T> {

    private int front;
    private int back;
    private int size;
    private T[] data;

    public StaticQueue(int initialCapacity){
        front = 0;
        back = 0;
        size = 0;
        data = (T[])new Object[initialCapacity];
    }

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

    @Override
    public boolean isEmpty() {


        if(size <= 0){
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
