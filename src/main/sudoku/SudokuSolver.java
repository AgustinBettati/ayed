package main.sudoku;
import struct.impl.LinkedStack;
import struct.impl.StaticStack;

public class SudokuSolver {

    private int[][] board;
    private StaticStack<Integer>[][] stacks;

    public SudokuSolver(){
        stacks = new StaticStack[9][9];
    }

    public class IndexOfMatrix{
        public IndexOfMatrix(){
        }
        public IndexOfMatrix(int i, int j){
            row = i;
            column = j;
        }
        int row;
        int column;
    }

    public void loadValues(int[][] values){
        board = values;
    }

    public int[][] getValues(){
        return board;
    }

    public void solveBoard(){
        int i = 0;
        int j = 0;

        while(i <8 || j <8){

            // Hay un numero del board original.
            if(board[i][j] != 0 && stacks[i][j] == null){
                IndexOfMatrix newPostion = moveForward(i,j);
                i = newPostion.row;
                j = newPostion.column;
            }

            // Hay un numero que no es del board original y esta mal.
            else if(board[i][j] != 0 &&
                    (usedInRowOrCol(i,j,board[i][j]) || usedInSquare(i, j, board[i][j] ))){

                int size = stacks[i][j].size();
                while(size <= 1){
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

            // Hay un numero que no es del board original y esta bien.
            else if(board[i][j] != 0 && !usedInRowOrCol(i,j,board[i][j]) &&
                    !usedInSquare(i , j, board[i][j])){
                IndexOfMatrix newPostion = moveForward(i,j);
                i = newPostion.row;
                j = newPostion.column;
            }

            // Lugar sin numero y ningun stack presente
            else if(board[i][j] == 0 && (stacks[i][j] == null ) ){

                stacks[i][j] = createStackForPosition(i,j);

                if(stacks[i][j].isEmpty()){
                    stacks[i][j] = null;
                    IndexOfMatrix newPostion = findClosestStackBackwards(i, j);
                    i = newPostion.row;
                    j = newPostion.column;

                    while(stacks[i][j].size() <= 1){
                        board[i][j] = 0;
                        stacks[i][j] = null;
                        IndexOfMatrix auxPostion = findClosestStackBackwards(i, j);
                        i = auxPostion.row;
                        j = auxPostion.column;
                    }
                    stacks[i][j].pop();
                    board[i][j] = stacks[i][j].peek();

                }
                else{
                    board[i][j] = stacks[i][j].peek();
                    IndexOfMatrix newPostion = moveForward(i,j);
                    i = newPostion.row;
                    j = newPostion.column;
                }
            }

            else{
                System.out.println("Hay un caso raro");
            }

        }

    }

    public IndexOfMatrix moveForward(int i, int j){
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


    public IndexOfMatrix findClosestStackBackwards(int row,int column){

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



    public StaticStack<Integer> createStackForPosition(int row, int col){
        StaticStack<Integer> stack = new StaticStack<>(9);

        for (int k = 1; k <= 9; k++){
            if (!usedInRowOrCol(row, col, k) && !usedInSquare(row,col, k)){
                stack.push(k);
            }
        }
        return stack;
    }


    public boolean usedInSquare(int row, int col, int n){
        int squareStartRow = row - (row % 3);
        int squareStartCol = col - (col % 3);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i + squareStartRow][j + squareStartCol] == n &&
                        i != row && j != col){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean usedInRowOrCol(int row, int col, int n){
        for (int i = 0; i < 9; i++){
            if( (board[row][i] == n & i != col ) || (board[i][col] == n && i != row) ){
                return true;
            }
        }
        return false;
    }


}