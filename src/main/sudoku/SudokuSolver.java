package main.sudoku;
import struct.impl.LinkedStack;
import struct.impl.StaticStack;

public class SudokuSolver {

    private int[][] board;
    private LinkedStack<Integer>[][] stacks;

    public SudokuSolver(){
        stacks = new LinkedStack[9][9];
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

            if(board[i][j] == 0 && stacks[i][j] == null){

                stacks[i][j] = createStackForPosition(i,j);

                if(stacks[i][j].isEmpty()){
                    IndexOfMatrix newPostion = findClosestStackBackwards(i, j);
                    i = newPostion.row;
                    j = newPostion.column;
                    stacks[i][j].pop();
                    if(stacks[i][j].peek() == null){
                        board[i][j] = 0;
                    }
                    else{
                        board[i][j] = stacks[i][j].peek();
                    }
                }
                else{
                    board[i][j] = stacks[i][j].peek();
                    IndexOfMatrix newPostion = moveForward(i,j);
                    i = newPostion.row;
                    j = newPostion.column;
                }
            }

            else if(board[i][j] != 0 && stacks[i][j] == null){
                IndexOfMatrix newPostion = moveForward(i,j);
                i = newPostion.row;
                j = newPostion.column;
            }

            else if(!usedInRowOrCol(i,j,board[i][j]) &&
                    !usedInSquare(i - (i % 3), j - (j % 3), board[i][j])){

                IndexOfMatrix newPostion = moveForward(i,j);
                i = newPostion.row;
                j = newPostion.column;

            }

            else{
                stacks[i][j].pop();
                if(!stacks[i][j].isEmpty()){
                    board[i][j] = stacks[i][j].peek();
                    IndexOfMatrix newPostion = moveForward(i,j);
                    i = newPostion.row;
                    j = newPostion.column;
                }
                else{
                    board[i][j] = 0;
                    IndexOfMatrix newPostion = findClosestStackBackwards(i, j);
                    i = newPostion.row;
                    j = newPostion.column;
                    stacks[i][j].pop();
                    if(stacks[i][j].peek() == null){
                        board[i][j] = 0;
                    }
                    else{
                        board[i][j] = stacks[i][j].peek();
                    }
                }
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



    public LinkedStack<Integer> createStackForPosition(int row, int col){
        LinkedStack<Integer> stack = new LinkedStack<>();
        int initialRow = row - (row % 3);
        int initialCol = col - (col % 3);

        for (int k = 1; k <= 9; k++){
            if (!usedInRowOrCol(row, col, k) && !usedInSquare(initialRow,initialCol, k)){
                stack.push(k);
            }
        }
        return stack;
    }


    public boolean usedInSquare(int squareStartRow, int squareStartCol, int n){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i + squareStartRow][j + squareStartCol] == n){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean usedInRowOrCol(int row, int col, int n){
        for (int i = 0; i < 9; i++){
            if(board[row][i] == n || board[i][col] == n){
                return true;
            }
        }
        return false;
    }


}