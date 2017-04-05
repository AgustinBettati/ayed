package main.sudoku;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class represents the exception found when a invalid board is loaded.
 */
public class InvalidBoardException extends RuntimeException {

    public InvalidBoardException(String m){
        super(m);
    }
    public InvalidBoardException(){}



}
