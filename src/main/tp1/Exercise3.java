package main.tp1;


public class Exercise3 <T extends Comparable<T>> {


    public Comparable<T>[] merge(T[] arrayA, T[] arrayB) {
        Comparable<T>[] arrayC = new Comparable[arrayA.length + arrayB.length];

        int indiceA = 0;
        int indiceB = 0;
        int indiceC = 0;

        while (indiceA < arrayA.length && indiceB < arrayB.length) {
            if (arrayB[indiceB].compareTo(arrayA[indiceA]) > 0) {
                arrayC[indiceC] = arrayA[indiceA];
                indiceA++;
            } else {
                arrayC[indiceC] = arrayB[indiceB];
                indiceB++;
            }
            indiceC++;

        }

        if (indiceA == arrayA.length) {

            for (; indiceC < arrayC.length; indiceC++, indiceB++) {

                arrayC[indiceC] = arrayB[indiceB];

            }

        } else {

            for (; indiceC < arrayC.length; indiceC++, indiceA++) {

                arrayC[indiceC] = arrayA[indiceA];
               
            }

        }
        return arrayC;
    }

}

