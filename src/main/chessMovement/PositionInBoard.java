package main.chessMovement;

/**
 * A class that represents a position in the board.
 *
 * @author Marcos Khabie
 * @author Agustin Bettati
 * @version     1.0
 */
public class PositionInBoard {

    private int row;
    private int column;

    /**
     * This constructor creates a new PositionInBoard with its column and row.
     * @param i
     * The row of the PositionInBoard.
     * @param j
     * The column of the PositionInBoard.
     *
     */
    public PositionInBoard(int i, int j) {
        row = i;
        column = j;
    }

    /**
     *A getter of the row.
     */
    public int row() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    /**
     *A getter of the column
     */
    public int column() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * A method that compares with another PositionInBoard and express if its equal.
     * @param positionInBoard
     * The Position that will be compared with the actual one.
     * @return
     * true if equal false if not
     */
    public boolean equals(PositionInBoard positionInBoard) {
        if (this.column() == positionInBoard.column() && this.row() == positionInBoard.row()) {
            return true;

        }
        return false;
    }

    /**
     * Returns a representation of the position in form of chess.
     * @return
     */
    public String toString(){
        String xAxisValue = "";
        if(column == 0){
            xAxisValue = "A";
        }
        else if(column == 1){
            xAxisValue = "B";
        }
        else if(column == 2){
            xAxisValue = "C";
        }
        else if(column == 3){
            xAxisValue = "D";
        }
        else if(column == 4){
            xAxisValue = "E";
        }
        else if(column == 5){
            xAxisValue = "F";
        }
        else if(column == 6){
            xAxisValue = "G";
        }
        else if(column == 7){
            xAxisValue = "H";
        }

        return " " + (row +1) + ", " + xAxisValue + " ";
    }

    /**
     * A method that tells if a position is in the board or if its out of bounds.
     * @return
     * True if is in board false if not.
     */
    public boolean isInBoard(){
        if (this.column()>7||this.row()>7||this.column()<0||this.row()<0){
            return false;
        }
        return true;
    }
}
