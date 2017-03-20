package main.distanciaDePalabras;


public class WordsDistance {

    /**
     * This method returns the distance of two words using Hammings algorithm.
     * This algorithm consists in checking the same position in the 2 words and
     * checks if both characters are equal, and if not the distance is incremented by 1.
     *
     * This method only recieves strings of the same size.
     * @param word1
     * @param word2
     * @return
     */
    public static int hammingDistance(String word1,String word2){
        if(word1.length() != word2.length()){
            throw new RuntimeException();
        }
        return hammingDistance(word1,word2,0,0);
    }

    private static int hammingDistance(String word1, String word2,int index, int partialResult){
        int i =index;
        if (i>=word1.length()){
            return partialResult;
        }
        if (word1.charAt(i)!=word2.charAt(i)){
            partialResult++;
        }
        return hammingDistance(word1,word2,i + 1,partialResult);
    }


    /**
     * This method returns the distance of two words using Levenshteins algorithm.
     * This algorithm consists in finding the amount of operations need to transform one
     * word to another. These operations are either insertion, substitution, or elimination.
     * Both strings dont need to be of the same size.
     * @param s1
     * @param s2
     * @return
     */
    public static int levenshteinDistance( String s1, String s2 ) {

        int[][] matrix = new int[ s1.length() + 1 ][ s2.length() + 1 ];

        for( int i = 0; i < s1.length() + 1; i++ ) {
            matrix[ i ][ 0 ] = i;
        }

        for(int j = 0; j < s2.length() + 1; j++) {
            matrix[ 0 ][ j ] = j;
        }

        for( int i = 1; i < s1.length() + 1; i++ ) {
            for( int j = 1; j < s2.length() + 1; j++ ) {
                int up = matrix[ i - 1 ][ j ] + 1;
                int left = matrix[ i ][ j - 1 ] + 1;
                int diagonal = matrix[ i - 1 ][ j - 1 ];
                if ( s1.charAt(i - 1) != s2.charAt(j - 1) ) {
                    diagonal += 1;
                }
                matrix[ i ][ j ] = Math.min( Math.min( up, left ), diagonal );
            }
        }
        return matrix[ s1.length() ][ s2.length() ];
    }


    public static void main(String[] args) {
        String word = "holajuanlalala";
        String word2 = "quehacesjojojo";
        System.out.println(levenshteinDistance(word,word2));
        System.out.println(hammingDistance(word,word2));
    }
}

