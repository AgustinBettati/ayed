package main.sudoku;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuController {

    private SudokuFrame sudokuWindow;
    private InvalidBoardFrame errorWindow;
    private SudokuSolver solver;


    public SudokuController() {
        sudokuWindow = new SudokuFrame(new SudokuResolveButtonListener(), new ClearBoardButtonListener());
        errorWindow = new InvalidBoardFrame(new InvalidBoardBackButtonListener());
        solver = new SudokuSolver();
    }

    public class SudokuResolveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            solver.loadNewBoard(sudokuWindow.getValues());

            if(!solver.boardIsValid()){
                sudokuWindow.dispose();
                errorWindow.setVisible(true);
            }
            else {
                while (!solver.boardIsSolved()) {

                    solver.runNextStep();
                    sudokuWindow.setValuesToWindow(solver.getValues());
                    //Thread.sleep(500);
                }
            }
        }
    }

    public class ClearBoardButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            sudokuWindow.emptyBoard();
        }
    }

    public class InvalidBoardBackButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            errorWindow.dispose();
            sudokuWindow.setVisible(true);
        }
    }

}

