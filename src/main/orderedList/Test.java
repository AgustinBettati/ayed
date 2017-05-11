package main.orderedList;

import struct.impl.sortedLists.StaticSortedList;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Test {

    public static void main(String[] args) {
        StaticSortedList<Integer> orderedList = new StaticSortedList<>();

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

        System.out.println();

        for(int i =0; i< orderedList.size(); i++){
            orderedList.goTo(i);
            System.out.println(orderedList.getActual());
        }

    }
}
