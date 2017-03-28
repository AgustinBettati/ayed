package main.sudoku;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuController {

    private SudokuFrame sudokuWindow;
    private SudokuSolver solver;


    public SudokuController(){
        sudokuWindow = new SudokuFrame(new SudokuResolveButtonListener());
        solver = new SudokuSolver();
    }

    public class SudokuResolveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           /*
           Aca se le pide los valores al view y se los pasa al solver.
           Cuando el solver lo resuelve lo pasa por aca al view.
            */
            /*int[][] matrix = {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}};
            sudokuWindow.valuesSetter(matrix);*/
            solver.loadValues(sudokuWindow.valuesGetter());
            solver.solveBoard();
            sudokuWindow.valuesSetter(solver.getValues());
        }
    }


    public static void print (int [][] grid){

            for(int r=0; r<grid.length; r++) {
                for(int c=0; c<grid[r].length; c++)
                    System.out.print(grid[r][c] );
                System.out.println();
            }
        }
    }

