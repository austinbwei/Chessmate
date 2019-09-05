package Pieces;

import Game.Board;
import Game.Move;
import java.util.ArrayList;

public abstract class Piece {

    public static final boolean WHITE = true;
    public static final boolean BLACK = false;

    protected boolean color;
    protected int value;

    /**
     * Construct piece of a players color
     * @param color of player to possess piece
     */
    public Piece(boolean color) {
        this.color = color;
        value = 0;
    }

    public boolean getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    public abstract Piece clone();

    public abstract ArrayList<Move> getLegalMoves(Board board, int row, int column);

    /**
     * Ensure a move does not go out of bounds of the board
     * @param row of move destination
     * @param column of move destination
     * @return whether the move is allowed or now
     */
    public static boolean isValidMove(int row, int column) {
        if (row < 0 || row > 7 || column < 0 || column > 7) {
            return false;
        } else {
            return true;
        }
    }

    public abstract String toString();

    public abstract String printPiece();
}
