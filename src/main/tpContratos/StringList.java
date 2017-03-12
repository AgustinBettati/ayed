package main.tpContratos;

/**
 *  This is a functional class that is used to store Strings.
 *  @author Agustin Bettati
 *  @author Marcos Khabie
 *  @version 1.0
 */
public class StringList {

    private String name;
    private int size = 0;
    /*@ invariant
      size >= 0 && size <= items.length;
     @*/
    private String[] items;
    /*@ invariant
     (\forall int i; 0 <= i && i < size - 1;
            items[i] != null);
     @*/

    /**
     * Creates a StringList with an initial array of size 10
     * @param name gives a name to the list
     */
    public StringList(/*@ non_null @*/ String name) {
        items = new String[10];
        this.name = name;
    }

    /**
     * Creates a StringList with the specified initial size
     * @param initialSize number that represents the initial size
     * @param name gives a name to the list
     */

    /*@
      requires initialSize > 0;
     @*/
    public StringList(/*@ non_null @*/ String name, int initialSize) {

        items = new String[initialSize];
        this.name = name;
    }

    /**
     * adds a String to the list
     * @param item the String that will be added
     */
    /*@
      ensures size == \old(size) + 1;
     @*/
    public void add( /*@ non_null @*/ String item) {
        if(size == items.length){
            String[] temp = new String[size*2];
            //@ assert temp.lenght == size * 2;
            for(int i = 0; i < items.length; i++){
                temp[i] = items[i];
            }
            items = temp;
        }
        items[size] = item;
        size++;
    }

    /**
     * lets you find out the index of an item in the array, if it is contained
     * @param item the String which will be searched
     * @return if the item is found returns the index of the item, and if not
     * it returns -1
     * @exception IllegalArgumentException when the item is not present in the list
     */
    /*@
      ensures \result >= 0;
     @*/
    public /*@ pure @*/ int indexOf(/*@ non_null @*/ String item) {
        for (int i = 0; i < items.length; i++){

            if (item.equals(items[i])){
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * removes an item from the list given a specific index, and then re orders
     * all items so no empty slot are found inbetween.
     * @param index position in the array that will be removed
     */
    /*@
      requires index >= 0 && index < size;
      ensures size == \old(size) - 1;
     @*/
    public void remove(int index) {
        items[index] = null;

        for(;index + 1 < size; index++){
            items[index] = items[index + 1];
            items[index + 1] = null;
        }
        size--;
    }

    /**
     * @return A String that contains all the items of the list
     * separated by comas
     */
    public /*@ pure @*/ String toString() {
        String result = "[";
        for(int i = 0; i < size; i++){
            if(i == size - 1)
                result += "'" + items[i] + "']";
            else
                result += "'" + items[i] + "', ";
        }
        return result;
    }

    /*@
      assignable name;
     @*/
    public void setName(String name) {
        this.name = name;
    }

    public /*@ pure @*/ String getName() {
        return name;
    }

    /**
     * @return A integer that represents the amount of items in the list
     */
    public int size() {
        return size;
    }

}
