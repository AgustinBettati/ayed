package main.sudoku;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class SudokuController {

    private SudokuFrame sudokuWindow;
    private InvalidBoardDialog errorWindow;
    private SudokuSolver solver;


    public SudokuController() {
        sudokuWindow = new SudokuFrame(new SudokuResolveButtonListener(), new ClearBoardButtonListener());
        errorWindow = new InvalidBoardDialog(new InvalidBoardBackButtonListener());
        solver = new SudokuSolver();
    }

    public class SudokuResolveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            solver.loadNewBoard(sudokuWindow.getValues());

            if(!solver.boardIsValid()){
                errorWindow.setVisible(true);
            }
            else {
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        if (!solver.boardIsSolved()) {
                            solver.runNextStep();
                            sudokuWindow.setValuesToWindow(solver.getValues());
                        } else {
                            // stop the timer
                            cancel();
                        }
                    }
                };
                timer.schedule(task,0, 10);
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

