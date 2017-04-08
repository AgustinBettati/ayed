package main.stacks.lexicalAnalyzer;


import struct.impl.stacks.LinkedStack;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class contains a simple lexicographic analyzer that checks that symbols open and
 * close correctly
 */
public class LexicalAnalyzer {

    public static void main(String[] args) {
        System.out.println(lexicalAnalyzer("content.txt"));
    }

    /**
     * Evaluates the content of the text file to see that all symbols close respectively
     * @param fileName relative path to the file.
     * @return
     */
    public static boolean lexicalAnalyzer(String fileName){
        FileIO io = new FileIO();
        String content = io.getStringFromFile(fileName);
        content = content.replaceAll("\\s+",""); // removes all spaces.
        char[] arrayOfContent = content.toCharArray();

        if(arrayOfContent.length % 2 != 0)
            return false;

        LinkedStack<Character> stack = new LinkedStack<>();

        for(int i = 0; i < arrayOfContent.length; i++) {
            if(stack.isEmpty())
                stack.push(arrayOfContent[i]);

            else if(symbolsCloseEachOther(stack.peek(), arrayOfContent[i]))
                stack.pop();

            else
                stack.push(arrayOfContent[i]);
        }

        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    /**
     * Evaluates if the symbols correspond to each other and close themselves.
     * Takes in the following symbols: [, {, (, "
     * @param a the opening symbol
     * @param b the closing symbol
     * @return
     */
    public static boolean symbolsCloseEachOther(char a, char b){
        if(a == '(' && b == ')')
            return true;
        if(a == '[' && b == ']')
            return true;
        if(a == '{' && b == '}')
            return true;
        if (a == '"' && b == '"')
            return true;

        return false;
    }

}
