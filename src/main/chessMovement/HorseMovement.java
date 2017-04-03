package main.chessMovement;

import struct.impl.LinkedStack;

import java.util.ArrayList;

/**
 * Created by marcos on 30/3/17.
 */
public class HorseMovement {

    private int amountOfMovements;
    private ArrayList<LinkedStack<PositionInBoard>> listOfStacks;

    public HorseMovement(int amountOfMovements) {
       listOfStacks=new ArrayList<>(amountOfMovements);
       this.amountOfMovements=amountOfMovements;
    }

    public ArrayList<PositionInBoard> getNextPath(){
         for (int i= listOfStacks.size();i<amountOfMovements;i++){
             if (i==0){
                 listOfStacks.add(createStackForPosition(new PositionInBoard(0,0),new PositionInBoard(0,0)));
             }
           else if (i==1){
               listOfStacks.add(createStackForPosition(listOfStacks.get(i-1).peek(),new PositionInBoard(0,0)));
           }
           else{
               listOfStacks.add(createStackForPosition(listOfStacks.get(i-1).peek(),listOfStacks.get(i-2).peek()));
           }
         }

       ArrayList<PositionInBoard> path=new ArrayList<>(amountOfMovements);
        for (int i=0;i<listOfStacks.size();i++){

            path.add(listOfStacks.get(i).peek());

        }
        listOfStacks.get(amountOfMovements-1).pop();

        int i = amountOfMovements - 1;

        while (listOfStacks.get(i).isEmpty()){
            if(i == 0){
                throw new RuntimeException("No more available paths.");
            }
            listOfStacks.remove(i);
            listOfStacks.get(i-1).pop();
            i--;
        }
        return path;
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