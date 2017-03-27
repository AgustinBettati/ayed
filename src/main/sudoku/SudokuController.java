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
        }
    }


}
