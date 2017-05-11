package struct.impl.sortedLists;

import struct.istruct.list.GeneralList;
import struct.istruct.list.SortedList;

import java.util.NoSuchElementException;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 */
public class StaticSortedList<T extends Comparable<T>>  implements SortedList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Comparable<T>[] data;
    private int window;
    private int size;
    private final int capacity;

    public StaticSortedList() {
        this(DEFAULT_CAPACITY);
    }

    public StaticSortedList(int capacity) {
        this.data = new Comparable[capacity];
        this.capacity = capacity;
        this.window = 0;
        this.size = 0;
    }
    private StaticSortedList(int window, int size, int capacity, Comparable<T>[] data) {
        this.window = window;
        this.size = size;
        this.capacity = capacity;
        this.data = data;
    }

    @Override
    public void insert(T obj) {
        if (size == data.length) enlarge();
        binaryInsert(data, obj, 0, size-1);
    }

    private void binaryInsert(Comparable<T>[] array, T element, int first, int last){

        if(first > last){
            goTo(first);
            insertPrev(element);
            return;
        }

        int middleIndex = (first + last) / 2;

        if (array[middleIndex].compareTo(element) == 0){
            goTo(middleIndex);
            insertNext(element);
            return;
        }

        if(array[middleIndex].compareTo(element) < 0){
            binaryInsert(array, element, middleIndex +1, last);
        }
        else{
            binaryInsert(array, element, first, middleIndex -1 );
        }
    }

    private void insertPrev(T obj) {
        for (int i = data.length - 1; i > window; i--) data[i] = data[i - 1];
        data[window] = obj;
        size++;
    }
    private void insertNext(T obj) {
        if (!isVoid()) window++;
        insertPrev(obj);
    }



    @Override
    public void goNext() {
        if (window == size - 1) throw new IndexOutOfBoundsException("Reached the end of the list");
        window++; }
    @Override
    public void goPrev() {
        if (window == 0) throw new IndexOutOfBoundsException("Reached the beginning of the list");
        window--; }
    @Override
    public void goTo(int index) {
        if (index < 0 || index >= data.length)
            throw new IndexOutOfBoundsException("There is no such index in this list");
        window = index;
    }
    @Override
    public void remove() {
        for (int i = window; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        if (window >= size) window = size - 1;
    }

    public void removeWithKey(T element){
        int index = binarySearch(data, element, 0, size-1);
        goTo(index);
        remove();

    }

    private int binarySearch(Comparable<T>[] array, T element, int first, int last){

        if(first > last){
            throw new NoSuchElementException();
        }

        int middleIndex = (first + last) /2;

        if (array[middleIndex].compareTo(element) == 0)
            return middleIndex;


        if(array[middleIndex].compareTo(element) < 0){
            return binarySearch(array, element, middleIndex +1, last);
        }
        else{
            return binarySearch(array, element, first, middleIndex -1 );
        }
    }



    @Override
    public int size() {
        return size;
    }


    @Override
    @SuppressWarnings("unchecked")
    public T getActual() {
        if (isVoid()) throw new NullPointerException("The list is empty");
        return (T) data[window];
    }
    @Override
    public int getActualPosition() {
        return window;
    }

    @Override
    public boolean isVoid() {
        return data[0] == null;
    }

    @Override
    public boolean endList() {
        return window == data.length - 1;
    }

    @Override
    public GeneralList<T> clone() {
        Comparable<T>[] cloned = new Comparable[data.length];
        for (int i = 0; i < data.length; i++) cloned[i] = data[i];
        return new StaticSortedList<T>(window, size, capacity, cloned);
    }

    private void enlarge() {
        Comparable<T>[] tempObjects = (T[])new Object[data.length + DEFAULT_CAPACITY];
        for (int i = 0; i < data.length; i++) tempObjects[i] = data[i];
        data = tempObjects;
    }
}
