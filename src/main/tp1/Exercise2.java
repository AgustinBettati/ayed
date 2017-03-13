package main.tp1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Exercise2 {
    public static void main(String[] args) {

        for(int n = 100; n <= 100000; n= n*10) {

            int[] array1 = createRandomArrayOfInts(n);
            int[] array2 = cloneArray(array1);
            int[] array3 = cloneArray(array1);

            long startTime = System.nanoTime();
            insertionSort(array1);
            long insertionSortTime = TimeUnit.MICROSECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
            startTime = System.nanoTime();
            selectionSort(array2);
            long selectionSortTime = TimeUnit.MICROSECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);

            startTime = System.nanoTime();
            bubbleSort(array3);
            long bubbleSortTime = TimeUnit.MICROSECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);

            System.out.println("n: " + n + "\ninsertion sort: " + insertionSortTime +
                   "\nselection sort: " + selectionSortTime +
                   "\nbubble sort:    " + bubbleSortTime);
            System.out.println();

        }
    }


    public static int[] selectionSort(int[] array){

        for(int i = 0; i < (array.length -1); i++){
            int min = i;

            for(int j = i+1; j < array.length; j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            //A swap needs to be made
            if(min != i){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }



    public static int[] insertionSort(int[] array){

        for(int i = 1; i < array.length; i++){
            int key = array[i];
            int j = i-1;
            while ( (j > -1) && ( array [j] > key ) ) {
                array [j+1] = array [j];
                j--;
            }
            array[j+1] = key;
        }

        return array;
    }

    public static int[] bubbleSort(int[] array){
        int n = array.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        return array;
    }

    // g)
    private static int[] recursiveSelectionSort(int[] array, int startIndex){
        if(startIndex >= array.length - 1){
            return array;
        }

        int min = startIndex;
        for(int j = startIndex + 1; j < array.length; j++){
            if(array[j] < array[min]){
                min = j;
            }
        }
        if(min != startIndex){
            int temp = array[startIndex];
            array[startIndex] = array[min];
            array[min] = temp;
        }

        return recursiveSelectionSort(array, startIndex + 1);
    }

    public static int[] recursiveSelectionSort(int[] array){
        return recursiveSelectionSort(array, 0);
    }

    public static int[] createRandomArrayOfInts(int n){
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            arrayList.add(i);
        }
        Collections.shuffle(arrayList);

        int[] arr = new int[arrayList.size()];

        for(int i = 0; i < arr.length; i++){
            arr[i] = arrayList.get(i);
        }
        return arr;
    }

    public static void printArray(int[] array){
        String result = "[";
        for(int i = 0; i < array.length; i++){
            if(i == array.length - 1)
                result += "'" + array[i] + "']";
            else
                result += "'" + array[i] + "', ";
        }
        System.out.println(result);
    }

    public static int[] cloneArray(int[] arr){
        int[] newArray = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            newArray[i] = arr[i];
        }

        return newArray;
    }
}
