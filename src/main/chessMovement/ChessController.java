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
    private HorseMovement horseMovement;

    public ChessController(){

        chessWindow = new ChessFrame(4,new NextPathButtonListener());
        horseMovement = new HorseMovement(4);
    }


    public class NextPathButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

           chessWindow.displayPathOfMovements(horseMovement.getNextPath());
        }
    }
}
