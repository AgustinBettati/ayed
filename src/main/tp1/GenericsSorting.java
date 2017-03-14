package main.tp1;


import java.util.Comparator;
import java.util.List;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class contains three different sorting algorithms, which take in a list
 * and a specific criteria that will be used to then sort the list.
 *
 * @param <T> the type of object this sorting class will be capable of managing.
 */
public class GenericsSorting<T extends Comparable<T>>{

    public T[] selectionSort(T[] array){

        for(int i = 0; i < (array.length -1); i++){
            int min = i;

            for(int j = i+1; j < array.length; j++){
                if(array[min].compareTo(array[j]) > 0){
                    min = j;
                }
            }
            //A swap needs to be made
            if(min != i){
                T temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }

    public T[] insertionSort(T[] array){

        for(int i = 1; i < array.length; i++){
            T key = array[i];
            int j = i-1;
            while ( (j > -1) && ( array [j].compareTo(key) > 0 ) ) {
                array [j+1] = array [j];
                j--;
            }
            array[j+1] = key;
        }

        return array;
    }

    public T[] bubbleSort(T[] array){
        int n = array.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if(array[j].compareTo(array[j+1]) > 0){
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }



}
