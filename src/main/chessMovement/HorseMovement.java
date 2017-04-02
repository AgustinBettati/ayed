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



    private LinkedStack<PositionInBoard> createStackForPosition(PositionInBoard position, PositionInBoard previousPosition){
        LinkedStack<PositionInBoard> stack = new LinkedStack<>();

        for (int i= position.row()-2;i<=position.row()+2;i++){

            if (Math.abs(i)==position.row()+2 ) {
                for (int j = position.column() + 2; j >= position.column() - 2; j--) {
                     if (!(j==position.column()||Math.abs(j)== position.column()+2)) {
                         for(int k = -2; k <=2; k+=4){
                             PositionInBoard possiblePostion = new PositionInBoard(i, j + k);
                             if(possiblePostion.isInBoard()&&!possiblePostion.equals(previousPosition)){
                                 stack.push(possiblePostion);
                             }
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