package main.chessMovement;

import struct.impl.LinkedStack;

import java.util.ArrayList;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class contains all the logic need to display all the paths for a horse that
 * moves a certain amount of steps.
 */
public class HorseMovement {

    private int amountOfMovements;
    private ArrayList<LinkedStack<PositionInBoard>> listOfStacks;

    /**
     * creates the horse movements solver.
     * @param amountOfMovements
     */
    public HorseMovement(int amountOfMovements) {
       listOfStacks=new ArrayList<>(amountOfMovements);
       this.amountOfMovements=amountOfMovements;
    }

    /**
     * Returns the next possible path that the horse can make.
     * @return a list with all of the positions in the board.
     */
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

        for (int i=0;i<listOfStacks.size() -1;i++){
            path.add(listOfStacks.get(i).peek());
        }
        LinkedStack<PositionInBoard> lastStack = listOfStacks.get(amountOfMovements -1);
        int sizeOfLastStack = lastStack.size();

        for (int i=0;i<sizeOfLastStack;i++){
            path.add(lastStack.peek());
            lastStack.pop();

        }

        int i = amountOfMovements - 1;

        while (listOfStacks.get(i).isEmpty()){
            if(i == 0){
                throw new AllPathsDisplayedException();
            }
            listOfStacks.remove(i);
            listOfStacks.get(i-1).pop();
            i--;
        }
        return path;
    }
public ArrayList<LinkedStack<PositionInBoard>> getStacks(){
        ArrayList<LinkedStack<PositionInBoard>> stacks= new ArrayList<>();

        for (int i=0; i<listOfStacks.size();i++){
            LinkedStack<PositionInBoard> aux = new LinkedStack<>();
            LinkedStack<PositionInBoard> stack = new LinkedStack<>();
            int length = listOfStacks.get(i).size();
            for (int j = 0; j < length; j++){
                aux.push(listOfStacks.get(i).peek());
                stack.push(listOfStacks.get(i).peek());
                listOfStacks.get(i).pop();
            }
            stacks.add(stack);

            for(int j = 0; j < length; j++){
                listOfStacks.get(i).push(aux.peek());
                aux.pop();
            }
        }
//        if (listOfStacks.size()==0){
//
//        }
//
//        else if(listOfStacks.size() - 3 < 0){
//            stacks.add(createStackForPosition(stacks.get(amountOfMovements -2).peek(), new PositionInBoard(0,0)));
//        }
//        else {
//            stacks.add(createStackForPosition(stacks.get(amountOfMovements - 2).peek(), stacks.get(amountOfMovements - 3).peek()));
//        }
        if (listOfStacks.size()==0){

        }
        else if (listOfStacks.size()-2<0){
            stacks.add(createStackForPosition(listOfStacks.get(listOfStacks.size() - 1).peek(), new PositionInBoard(0,0)));
        }
        else {
        stacks.add(createStackForPosition(listOfStacks.get(listOfStacks.size() - 1).peek(), (listOfStacks.get(listOfStacks.size()-2).peek())));
    }
        return stacks;

}

    private LinkedStack<PositionInBoard> createStackForPosition(PositionInBoard position, PositionInBoard previousPosition){
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
            }
            else if(!(i == position.row())){
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