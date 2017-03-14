package main.tp1;

/**
 * Created by marcos on 13/3/17.
 */
public class Exercise3 {


    public  static int[] merge (int[] arrayA,int[]arrayB){
        int[] arrayC= new int[arrayA.length+arrayB.length];

        int indiceA;
        int indiceB;
        int indiceC;
        for (indiceA=0;indiceA<arrayA.length;){
            for (indiceB=0;indiceB<arrayB.length;){
                for (indiceC=0;indiceC<arrayC.length;indiceC++){
                    if (arrayA[indiceA]<arrayB[indiceB]){
                        arrayC[indiceC]=arrayA[indiceA];
                        indiceA++;
                    }
                    else arrayC[indiceC]=arrayB[indiceB];
                    indiceB++;
                }

            }
        }
        if (arrayA.length<arrayB.length){
            for (indiceB=0;indiceB<arrayB.length;indiceB++){
                for (indiceC=arrayA.length;indiceC<arrayC.length;indiceC++){
                    if (arrayC[indiceC]<arrayB[indiceB]){

                    }

                else{
                        arrayC[indiceC]=arrayB[indiceB];
                    }

                }

            }

        }
return arrayC;
    }

}
