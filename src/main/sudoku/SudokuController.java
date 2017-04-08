package main.sudoku;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class is used to manage the view and solver of the sudoku.
 */
public class SudokuController {

    private SudokuFrame sudokuWindow;
    private InvalidBoardDialog errorWindow;
    private SudokuSolver solver;


    /**
     * Creates the controller and instantiates all of its local variables.
     */
    public SudokuController() {
        sudokuWindow = new SudokuFrame(new SudokuResolveButtonListener(), new ClearBoardButtonListener());
        errorWindow = new InvalidBoardDialog(new InvalidBoardBackButtonListener());
        solver = new SudokuSolver();
    }

    /**
     * A class that contains the action executed when the user presses the solve button.
     *
     */
    public class SudokuResolveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                solver.loadNewBoard(sudokuWindow.getValues());

//                Timer timer = new Timer();
//                TimerTask task = new TimerTask() {
//                    @Override
//                    public void run() {
//                        if (!solver.boardIsSolved()) {
//                            solver.runNextStep();
//                            sudokuWindow.setValuesToWindow(solver.getValues());
//                        } else {
//                            // stop the timer
//                            cancel();
//                        }
//                    }
//                };
//                timer.schedule(task,0, 10);
                while(!solver.boardIsSolved()){
                    solver.runNextStep();
                }
                sudokuWindow.setValuesToWindow(solver.getValues());


            }catch (InvalidBoardException exception){
                errorWindow.setVisible(true);
            }
        }
    }



    /**
     * A class that contains the action executed when the clear button is pressed.
     */
    public class ClearBoardButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            sudokuWindow.emptyBoard();
        }
    }

    /**
     * A class that contains the action executed when the back button of the
     * invalid board dialog is pressed.
     */
    public class InvalidBoardBackButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            errorWindow.dispose();
        }
    }

}

