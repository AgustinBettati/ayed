package struct.impl.sortedLists;
import struct.istruct.list.GeneralList;
import struct.istruct.list.List;
import struct.istruct.list.SortedList;

/**
 * Created by marcos on 19/4/17.
 */


public class DynamicSortedList<T extends Comparable<T>> implements SortedList<T> {
    private Node<T> head, window, sentinel;
    private int size;
    public DynamicSortedList(){
        head = new Node<>();
        sentinel = new Node<>();
        head.next = sentinel;
        window = head;
        size = 0;
    }
    @Override
    public T getActual() {
        return window.obj;
    }
    @Override
    public int getActualPosition() {
        int pos = 0;
        if (!isVoid()) {
            Node<T> aux = head;
            for (; aux.next != window; pos++) aux = aux.next;
        }
        return pos; }
    @Override
    public boolean isVoid() {
        return head.next == sentinel;
    }
    @Override
    public boolean endList() {
        return window.next == sentinel;
    }
    @Override
    public GeneralList<T> clone() {
        return null;
    }

    private void insertPrev(T obj) {
        if (!isVoid()) {
            goBack(); }
        insertNext(obj);
    }

    private void insertNext(T obj) {
        window.next = new Node<>(obj, window.next);
        window = window.next;
        size++;
    }
    @Override
    public void goNext() {
        if(window.next == sentinel) throw new IndexOutOfBoundsException("Reached the end of this List");
        window = window.next;
    }
    @Override
    public void goPrev() {
        if(window == head.next) throw new IndexOutOfBoundsException("Reached the beginning of this List");
        goBack(); }
    private void goBack(){
        Node<T> aux = head;
        while(window != aux.next){
            aux = aux.next;
        }
        window = aux;
    }
    @Override
    public void goTo(int index) {
        window = head.next;
        for(int i = 0; i < index; i++){
            window = window.next;
        }
    }
    @Override
    public void remove() {
        if(isVoid()) throw new NullPointerException("This List is empty");
        goBack();
        window.next = window.next.next;
        window = window.next;
        if(window == sentinel) goBack();
        size--;
    }


    public void removeWithKey(T element){
        goTo(0);
        int i=0;
        while (element!=getActual()){

            if(endList()){
              throw new RuntimeException("The element is not in the list");
            }
            i++;
            goTo(i);
        }
        remove();

    }
    @Override
    public void insert(T element) {
        goTo(0);
        int i=0;
        while (element.compareTo(getActual())>0&&!window.hasNoObj()){

            if (endList()){
                insertNext(element);
                return;
            }
            i++;
            goTo(i);
        }
        insertPrev(element);
    }
    @Override
    public int size() {
        return size;
    }



    private static class Node<E> {
        E obj;
        Node<E> next;
        Node() {
            obj = null;
            next = null; }
        Node(E o) {
            obj = o;
            next = null; }
        Node(E o, Node<E> next) {
            this(o);
            this.next = next;
        }
        boolean hasNoObj() {
            return obj == null;
        }
    }

}



