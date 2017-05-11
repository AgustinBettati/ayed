package main.orderedList;

import struct.impl.sortedLists.DynamicSortedList;
import struct.impl.sortedLists.StaticSortedList;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Test {

    public static void main(String[] args) {
        DynamicSortedList<Integer> orderedList = new DynamicSortedList<>();

        orderedList.insert(20);
        orderedList.insert(-1);
        orderedList.insert(3);
        orderedList.insert(-6);
        orderedList.insert(20);
        orderedList.insert(18);
        orderedList.insert(40);
        orderedList.insert(30);
        orderedList.insert(20);

        for(int i =0; i< orderedList.size(); i++){
            orderedList.goTo(i);
            System.out.println(orderedList.getActual());
        }

        orderedList.removeWithKey(-6);
        orderedList.removeWithKey(40);
        orderedList.removeWithKey(20);
        orderedList.removeWithKey(20);
        orderedList.removeWithKey(-1);
        orderedList.removeWithKey(3);
        orderedList.removeWithKey(18);
        orderedList.removeWithKey(20);
        orderedList.removeWithKey(30);


        System.out.println(orderedList.isVoid());

        for(int i =0; i< orderedList.size(); i++){
            orderedList.goTo(i);
            System.out.println(orderedList.getActual());
        }

    }
}
