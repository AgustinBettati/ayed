package struct.impl;

import java.util.Scanner;

/**
 * Created by marcos on 19/4/17.
 */
public class Exercise {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        DynamicList<Integer> integerDynamicList= new DynamicList<>();
        int a=-1;

        while (a!=0) {
            System.out.println("Ingrese un numero");
            a = scanner.nextInt();

            integerDynamicList.insertNext(a);
        }
        System.out.println(sumList(integerDynamicList));

    }
  public static int sumList(DynamicList<Integer> dynamicList){
        int result=0;
        dynamicList.goTo(0);
for (int i= dynamicList.size()-1;i>0;i--){

    result+=dynamicList.getActual();
    dynamicList.goNext();

      }
      return result;
  }

}
