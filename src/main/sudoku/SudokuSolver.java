package main.sudoku;
import struct.impl.LinkedStack;


/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class contains all the logic needed to solve a sudoku board.
 */
public class SudokuSolver {

    private boolean isSolved;
    private int i;
    private int j;
    private int[][] board;
    private LinkedStack<Integer>[][] stacks;

    /**
     * created a sudoku solver with an empty multi array of stacks, and counter pointing
     * to the initial position of the board.
     */
    public SudokuSolver(){
        stacks = new LinkedStack[9][9];
        i = 0;
        j = 0;
        isSolved = false;
    }

    /**
     * Inner class that is used to represent positions in the sudoku board.
     */
    private class IndexOfMatrix{
        int row;
        int column;


        public IndexOfMatrix(){
        }
        public IndexOfMatrix(int i, int j){
            row = i;
            column = j;
        }
    }

    /**
     * This method is used to load a new board to the solver.
     * It will load the new board and prepare all other needed variables in order to
     * prepare for the process of the solution.
     * @param values a sudoku board.
     */
    public void loadNewBoard(int[][] values){
        i = 0;
        j = 0;
        isSolved = false;
        board = values;
        stacks = new LinkedStack[9][9];
    }

    /**
     * States if the board contained in the solver has been solved or not.
     * @return
     */
    public boolean boardIsSolved(){
        return isSolved;
    }

    /**
     * Returns the values of the board in its current state.
     * @return
     */
    public int[][] getValues(){
        return board;
    }

    /**
     * Taking into count its current position in the board, it runs the following
     * step to resolving the board.
     */
    public void runNextStep(){
        if(i >= 9){
            isSolved = true;
        }
        else {

            // There is a number of the original board which cannot be changed.
            if (board[i][j] != 0 && stacks[i][j] == null) {
                IndexOfMatrix newPostion = moveForward(i, j);
                i = newPostion.row;
                j = newPostion.column;
            }

            /* There is a number that is not from the original board and its value
               is incorrect. */
            else if (board[i][j] != 0 &&
                    (usedInRowOrCol(i, j, board[i][j]) || usedInSquare(i, j, board[i][j]))) {

                int size = stacks[i][j].size();
                while (size <= 1) {
                    board[i][j] = 0;
                    stacks[i][j] = null;
                    IndexOfMatrix newPostion = findClosestStackBackwards(i, j);
                    i = newPostion.row;
                    j = newPostion.column;
                    size = stacks[i][j].size();
                }

                stacks[i][j].pop();
                board[i][j] = stacks[i][j].peek();

            }

            /* There is a number that is not from the original board and its value
               is correct. */
            else if (board[i][j] != 0 && !usedInRowOrCol(i, j, board[i][j]) &&
                    !usedInSquare(i, j, board[i][j])) {
                IndexOfMatrix newPostion = moveForward(i, j);
                i = newPostion.row;
                j = newPostion.column;
            }

            // Position has no value and no stack.
            else if (board[i][j] == 0 && (stacks[i][j] == null)) {

                stacks[i][j] = createStackForPosition(i, j);

                if (stacks[i][j].isEmpty()) {
                    stacks[i][j] = null;
                    IndexOfMatrix newPostion = findClosestStackBackwards(i, j);
                    i = newPostion.row;
                    j = newPostion.column;

                    while (stacks[i][j].size() <= 1) {
                        board[i][j] = 0;
                        stacks[i][j] = null;
                        IndexOfMatrix auxPostion = findClosestStackBackwards(i, j);
                        i = auxPostion.row;
                        j = auxPostion.column;
                    }
                    stacks[i][j].pop();
                    board[i][j] = stacks[i][j].peek();

                } else {
                    board[i][j] = stacks[i][j].peek();
                    IndexOfMatrix newPostion = moveForward(i, j);
                    i = newPostion.row;
                    j = newPostion.column;
                }
            }
        }

    }

    /**
     * States if a board complies with the rules of sudoku, to make sure that
     * it can be resolved.
     * @return
     */
    public boolean boardIsValid(){
        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != 0 &&
                        (usedInSquare(i,j,board[i][j]) || usedInRowOrCol(i,j,board[i][j])) ){
                    boolean usedInSquare = usedInSquare(i,j,board[i][j]);
                    boolean usedInRowOrCol = usedInRowOrCol(i,j,board[i][j]);
                    return false;
                }
            }
        }
        return true;
    }

    private IndexOfMatrix moveForward(int i, int j){
        IndexOfMatrix newPosition = new IndexOfMatrix();
        if(j == 8){
            newPosition.column = 0;
            newPosition.row = i + 1;
        }
        else {
            newPosition.column = j + 1;
            newPosition.row = i;
        }
        return newPosition;
    }


    private IndexOfMatrix findClosestStackBackwards(int row,int column){

        for(int i = row; i >= 0; i--){
            int j = column - 1;
            if(i < row){
                j = 8;
            }
            for(;j >= 0; j--){
                if( stacks[i][j] != null && !stacks[i][j].isEmpty() ){
                    return new IndexOfMatrix(i,j);
                }
            }
        }
        throw new RuntimeException("No stack found to pop");
    }


    private LinkedStack<Integer> createStackForPosition(int row, int col){
        LinkedStack<Integer> stack = new LinkedStack<>();

        for (int k = 1; k <= 9; k++){
            if (!usedInRowOrCol(row, col, k) && !usedInSquare(row,col, k)){
                stack.push(k);
            }
        }
        return stack;
    }


    private boolean usedInSquare(int row, int col, int n){
        int squareStartRow = row - (row % 3);
        int squareStartCol = col - (col % 3);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i + squareStartRow][j + squareStartCol] == n &&
                        i+squareStartRow!= row && j+squareStartCol != col){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean usedInRowOrCol(int row, int col, int n){
        for (int i = 0; i < 9; i++){
            if( (board[row][i] == n & i != col ) || (board[i][col] == n && i != row) ){
                return true;
            }
        }
        return false;
    }


}