package main.tp1;

import java.util.NoSuchElementException;

/**
 * Created by agustin on 9/3/17.
 */
public class Exercise1 {

    public static void main(String[] args) {
        int[] array = {2, 5, 7, 8, 14, 17, 20};
        System.out.println(linearSearch(array, 8));
        System.out.println(binarySearch(array, 8));
    }

    public static int linearSearch(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * has to recieve a sorted array
     */
    public static int binarySearch(int[] array, int number){

        return binarySearch(array, number, 0, array.length - 1);
    }
    private static int binarySearch(int[] array, int number, int first, int last){

        if(first > last){
            throw new NoSuchElementException();
        }

        int middleIndex = (first + last) /2;

        if (array[middleIndex] == number)
            return middleIndex;

        if(array[middleIndex] < number){
            return binarySearch(array, number, middleIndex +1, last);
        }
        else{
            return binarySearch(array, number, first, middleIndex -1 );
        }
    }

}
