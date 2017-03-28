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
            solver.loadValues(sudokuWindow.getValuesFromWindow());
            solver.solveBoard();
            sudokuWindow.setValuesToWindow(solver.getValues());
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

