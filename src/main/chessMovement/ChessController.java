package main.chessMovement;

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
        horseMovement = new HorseMovement();
    }

    public class NextPathButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PositionInBoard p1 = new PositionInBoard(1,2);
            PositionInBoard p2 = new PositionInBoard(3,3);
            PositionInBoard p3 = new PositionInBoard(4,1);
            PositionInBoard p4 = new PositionInBoard(6,0);
            PositionInBoard p5 = new PositionInBoard(6,2);
            PositionInBoard p6 = new PositionInBoard(2,0);
            PositionInBoard p7 = new PositionInBoard(2,2);
            ArrayList<PositionInBoard> listOfMovements = new ArrayList<>();
            listOfMovements.add(p1);
            listOfMovements.add(p2);
            listOfMovements.add(p3);
            listOfMovements.add(p4);
            listOfMovements.add(p5);
            listOfMovements.add(p6);
            listOfMovements.add(p7);
            chessWindow.displayPathOfMovements(listOfMovements);
        }
    }
}
