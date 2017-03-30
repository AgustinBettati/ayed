package main.sudoku;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class SudokuController {

    private SudokuFrame sudokuWindow;
    private SudokuSolver solver;


    public SudokuController() {
        sudokuWindow = new SudokuFrame(new SudokuResolveButtonListener());
        solver = new SudokuSolver();
    }

    public class SudokuResolveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            solver.loadNewBoard(sudokuWindow.getValues());

            if(!solver.boardIsValid()){
                System.out.println("No es valido");
            }
            else {
                while (!solver.boardIsSolved()) {
                    solver.runNextStep();
//                    try {
//                        TimeUnit.SECONDS.sleep(2);
//                    } catch (InterruptedException e1) {
//                        System.out.println("hay un problema");
//                    }
                    sudokuWindow.setValuesToWindow(solver.getValues());
                }
            }
        }
    }
}

