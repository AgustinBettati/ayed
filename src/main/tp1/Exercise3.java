package main.tp1;

/**
 * Created by marcos on 13/3/17.
 */
public class Exercise3 {


    public static int[] merge(int[] arrayA, int[] arrayB) {
        int[] arrayC = new int[arrayA.length + arrayB.length];

        int indiceA = 0;
        int indiceB = 0;
        int indiceC = 0;
    
        while (indiceA < arrayA.length && indiceB < arrayB.length) {
            if (arrayA[indiceA] < arrayB[indiceB]) {
                arrayC[indiceC] = arrayA[indiceA];
                indiceA++;
            } else {
                arrayC[indiceC] = arrayB[indiceB];
                indiceB++;
            }
            indiceC++;

        }

        if (indiceA == arrayA.length) {
            for (; indiceB < arrayB.length; ) {
                for (; indiceC < arrayC.length; indiceC++) {

                    arrayC[indiceC] = arrayB[indiceB];
                    indiceB++;
                }

            }

        } else {
            for (; indiceA < arrayA.length; ) {
                for (; indiceC < arrayC.length; indiceC++) {

                    arrayC[indiceC] = arrayA[indiceA];
                    indiceA++;
                }

            }
            return arrayC;
        }
        return arrayC;
    }

    public static void main(String[] args) {


        int[] a = {1,4,7};
        int[] b = {5,6,8,10};

      Exercise2.printArray( merge(a,b));

    }

}

