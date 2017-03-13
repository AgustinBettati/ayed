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
public class GenericsSorting<T> {

    public List<T> selectionSort(List<T> list, Comparator<T> criteria){

        for(int i = 0; i < (list.size() -1); i++){
            int min = i;

            for(int j = i+1; j < list.size(); j++){
                if(criteria.compare(list.get(j), list.get(min)) < 0){
                    min = j;
                }
            }
            //A swap needs to be made
            if(min != i){
                T temp = list.get(i);
                list.set(i, list.get(min));
                list.set(min, temp);
            }
        }
        return list;
    }

    public List<T> insertionSort(List<T> list, Comparator<T> criteria){

        for(int i = 1; i < list.size(); i++){
            T key = list.get(i);
            int j = i-1;
            while ( (j > -1) && (criteria.compare(list.get(j),key)>0)) {
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, key);
        }

        return list;
    }

    public List<T> bubbleSort(List<T> list, Comparator<T> criteria){
        int n = list.size();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if(criteria.compare(list.get(j), list.get(j+1))>0)
                {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }


}
