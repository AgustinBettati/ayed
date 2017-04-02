package main.chessMovement;

/**
 * Created by marcos on 2/4/17.
 */
public class PositionInBoard {

    private int row;
    private int column;

    public PositionInBoard(int i, int j) {
        row = i;
        column = j;
    }

    public int row() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int column() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }


    public boolean equals(PositionInBoard positionInBoard) {
        if (this.column() == positionInBoard.column() && this.row() == positionInBoard.row()) {
            return true;

        }
        return false;
    }
    public boolean isInBoard(){
        if (this.column()>8||this.row()>8||this.column()<0||this.row()<0){
            return false;
        }
        return true;
    }
}
