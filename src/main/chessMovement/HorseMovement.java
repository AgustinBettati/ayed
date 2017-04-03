package main.chessMovement;

import struct.impl.LinkedStack;

import java.util.ArrayList;

/**
 * Created by marcos on 30/3/17.
 */
public class HorseMovement {


    private ArrayList<LinkedStack<PositionInBoard>> listOfStacks;

    public HorseMovement(int amountOfMovements) {
       listOfStacks=new ArrayList<>(amountOfMovements);
    }



    public LinkedStack<PositionInBoard> createStackForPosition(PositionInBoard position, PositionInBoard previousPosition){
        LinkedStack<PositionInBoard> stack = new LinkedStack<>();

        for (int i= position.row()-2;i<=position.row()+2;i++){

            if (i==position.row()+2 || i==position.row()-2 ) {
                for (int j = position.column() - 2; j <= position.column() + 2; j++) {
                     if (!(j==position.column() || (j==position.column()+2 || j==position.column()-2))) {

                             PositionInBoard possiblePosition = new PositionInBoard(i , j );
                             if(possiblePosition.isInBoard()&&!possiblePosition.equals(previousPosition)){
                                 stack.push(possiblePosition);
                             }

                     }
                }
            }//cierra primer if
            else if(i == position.row()){
                //nada
            }
            else{

                for(int k = -2; k <=2; k+=4){
                    PositionInBoard possiblePostion = new PositionInBoard(i, position.column() + k);
                    if(possiblePostion.isInBoard()&&!possiblePostion.equals(previousPosition)){
                        stack.push(possiblePostion);
                    }
                }
            }
        }

        return stack;
    }

}