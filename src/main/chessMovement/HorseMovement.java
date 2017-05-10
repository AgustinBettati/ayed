package main.chessMovement;

import struct.impl.stacks.DynamicStack;

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
    private ArrayList<DynamicStack<PositionInBoard>> listOfStacks;
    private ArrayList<ArrayList<PositionInBoard>> listToDisplay;

    /**
     * creates the horse movements solver.
     * @param amountOfMovements
     */
    public HorseMovement(int amountOfMovements) {
       listOfStacks=new ArrayList<>(amountOfMovements);
       this.amountOfMovements=amountOfMovements;
       listToDisplay = new ArrayList<>();
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
                 if(listOfStacks.get(0).isEmpty()){
                     throw new AllPathsDisplayedException();
                 }
               listOfStacks.add(createStackForPosition(listOfStacks.get(i-1).peek(),new PositionInBoard(0,0)));
           }
           else{
               listOfStacks.add(createStackForPosition(listOfStacks.get(i-1).peek(),listOfStacks.get(i-2).peek()));
           }
         }
        saveValuesOfStacksToLaterDisplay();

       ArrayList<PositionInBoard> path=new ArrayList<>(amountOfMovements);

        for (int i=0;i<listOfStacks.size() -1;i++){
            path.add(listOfStacks.get(i).peek());
        }
        DynamicStack<PositionInBoard> lastStack = listOfStacks.get(amountOfMovements -1);
        int sizeOfLastStack = lastStack.size();

        for (int i=0;i<sizeOfLastStack;i++){
            path.add(lastStack.peek());
            lastStack.pop();

        }

        int i = amountOfMovements - 1;

        while (i > 0&&listOfStacks.get(i).isEmpty()){

            listOfStacks.remove(i);
            listOfStacks.get(i-1).pop();
            i--;
        }

        return path;
    }

    /**
     * Returns the list of stacks in form of a multi array.
     * @return
     */
    public ArrayList<ArrayList<PositionInBoard>> getStacks(){
            return listToDisplay;
    }

    private void saveValuesOfStacksToLaterDisplay(){
        listToDisplay.clear();
        for(DynamicStack<PositionInBoard> stack : listOfStacks){
            int size = stack.size();
            ArrayList<PositionInBoard> list = new ArrayList<>();
            DynamicStack<PositionInBoard> aux = new DynamicStack<>();
            for (int j = size -1; j >= 0; j--){
                aux.push(stack.peek());
                list.add(stack.peek());
                stack.pop();
            }
            listToDisplay.add(list);
            for(int j = 0; j < size; j++){
                stack.push(aux.peek());
                aux.pop();
            }
        }
    }

    private DynamicStack<PositionInBoard> createStackForPosition(PositionInBoard position, PositionInBoard previousPosition){
        DynamicStack<PositionInBoard> stack = new DynamicStack<>();

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