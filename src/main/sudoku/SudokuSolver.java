package main.sudoku;


import struct.impl.LinkedStack;
import struct.impl.StaticStack;

public class SudokuSolver {

    private int[][] board;
    private LinkedStack<Integer>[][] stacks;

    public void loadValues(int[][] values){
        board = values;
    }

    public void solveBoard(){
        for(int i = 0; i< 9; i++){
            for(int j = 0; j< 9; j++){


                if(board[i][j] == 0){
                    stacks[i][j] = createStackForPosition(i,j);
                    board[i][j] = stacks[i][j].peek();
                }
                else if(stacks[i][j] == null){
                    // no hacer nada
                }
                else if()



            }
        }
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
