package Game;

public class Move {

    private int rowOrigin;
    private int columnOrigin;
    private int rowDestination;
    private int columnDestination;
    private int value;

    /**
     * Create a move
     * @param rowOrigin row for piece to move
     * @param columnOrigin column for piece to move
     * @param rowDestination row to move piece to
     * @param columnDestination column to move piece to
     */
    public Move(int rowOrigin, int columnOrigin, int rowDestination, int columnDestination) {
        this.rowOrigin = rowOrigin;
        this.columnOrigin = columnOrigin;
        this.rowDestination = rowDestination;
        this.columnDestination = columnDestination;
    }

    public Move() {

    }

    public int getRowOrigin() {
        return rowOrigin;
    }

    public int getColumnOrigin() {
        return columnOrigin;
    }

    public int getRowDestination() {
        return rowDestination;
    }

    public int getColumnDestination() {
        return columnDestination;
    }

    public void setRowOrigin(int rowOrigin) {
        this.rowOrigin = rowOrigin;
    }

    public void setColumnOrigin(int columnOrigin) {
        this.columnOrigin = columnOrigin;
    }

    public void setRowDestination(int rowDestination) {
        this.rowDestination = rowDestination;
    }

    public void setColumnDestination(int columnDestination) {
        this.columnDestination = columnDestination;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Determine if a move made by the player is in the arraylist of possible moves
     * @param move1 to determine if its equal
     * @return whether the moves are equal
     */
    public boolean equals(Object move1) {
        Move move2 = (Move) move1;

        if (move2.getRowOrigin() == rowOrigin && move2.getColumnOrigin() == columnOrigin
                && move2.getRowDestination() == rowDestination && move2.getColumnDestination() == columnDestination) {
            return true;
        } else {
            return false;
        }
    }

    public String toString(Board board) {
        return "Move " + board.getTile(rowOrigin, columnOrigin).getPiece().printPiece() + " at "
                + (intToString(columnOrigin + 1)) + (rowOrigin + 1) + " to "
                + (intToString(columnDestination + 1)) + (rowDestination + 1);
    }

    private String intToString(int x) {
        switch(x) {
            case 1:
                return "a";
            case 2:
                return "b";
            case 3:
                return "c";
            case 4:
                return "d";
            case 5:
                return "e";
            case 6:
                return "f";
            case 7:
                return "g";
            case 8:
                return "h";
        }
        return "x";
    }
}
