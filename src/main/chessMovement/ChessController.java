package main.chessMovement;

import struct.impl.LinkedStack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * This class handles all interactions between the logic of the horse movements and the view of the chess board.
 *
 * @author Marcos Khabie
 * @author Agustin Bettati
 * @version     1.0
 */

public class ChessController {

    private ChessFrame chessWindow;
    private AllPathsShownDialog allPathsShownWindow;
    private HorseMovement horseMovement;

    /**
     * This constructor creates a ChessFrame, a HorseMovement and a AllPathsShownDialog. with its respectives parameters
     */
    public ChessController(){

        chessWindow = new ChessFrame(4,new NextPathButtonListener());
        horseMovement = new HorseMovement(4);
        allPathsShownWindow = new AllPathsShownDialog(new ResetButtonListener());
    }

    /**
     *  A class that contains the action executed when the user presses the Next path button.
     */
    public class NextPathButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<LinkedStack<PositionInBoard>> stacks = horseMovement.getStacks();

            for (LinkedStack<PositionInBoard> stack : stacks){
                String result = "";
                int size = stack.size();
                for (int i = 0; i< size; i++){
                    result += "(" + stack.peek().row()+ ", " + stack.peek().column()+ ") ";
                    stack.pop();
                }
                System.out.println(result);
            }
            System.out.println();
           try {
               chessWindow.displayPathOfMovements(horseMovement.getNextPath());
           }
           catch (AllPathsDisplayedException exception){
               allPathsShownWindow.setVisible(true);
           }

        }
    }

    /**
     * A class that contains the action executed when the user presses the Reset button.
     */
    public class ResetButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            allPathsShownWindow.dispose();
            horseMovement = new HorseMovement(4);

        }
    }
}
