package main.distanciaDePalabras;

/**
 * Created by marcos on 16/3/17.
 */
public class WordsDistance {

    private static double hamming(String word1, String word2,int index, double r){
        double result=r;
        int i =index;
        if (i>=word1.length()|| i>=word2.length()){
            if (word1.length()>word2.length()){
              return result=result+ (word1.length()-i);
            }
            else
                return result=result+(word2.length()-i);
        }
        if (word1.charAt(i)!=word2.charAt(i)){
            result++;
        }
        i++;
       return hamming(word1,word2,i,result);
    }

    public static double hamming(String word1,String word2){
       return hamming(word1,word2,0,0);
    }


    private static double levenshtein(String word1,String word2){

            
    }

    public static void main(String[] args) {
        String wo="aaaaa";
        String h="eeeee";
        System.out.println(hamming(wo,h,0,0));
    }
}

