package main.chessMovement;

import struct.impl.LinkedStack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by agustin on 26/3/17.
 */
public class ChessController {

    private ChessFrame chessWindow;
    private AllPathsShownDialog allPathsShownWindow;
    private HorseMovement horseMovement;

    public ChessController(){

        chessWindow = new ChessFrame(4,new NextPathButtonListener());
        horseMovement = new HorseMovement(4);
        allPathsShownWindow = new AllPathsShownDialog(new ResetButtonListener());
    }


    public class NextPathButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

           try {
               chessWindow.displayPathOfMovements(horseMovement.getNextPath());
           }
           catch (AllPathsDisplayedException exception){
               allPathsShownWindow.setVisible(true);
           }
        }
    }

    public class ResetButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            allPathsShownWindow.dispose();
            horseMovement = new HorseMovement(4);

        }
    }
}
