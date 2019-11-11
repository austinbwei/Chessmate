package Pieces;

import Game.Board;
import Game.Move;
import java.util.ArrayList;

public class King extends Piece {

    public King(boolean color) {
        super(color);
        value = 0;
    }

    public King clone() {
        return new King(color);
    }

    public ArrayList<Move> getLegalMoves(Board board, int row, int column) {
        ArrayList<Move> possibleMoves = new ArrayList<Move>();

        for (int i = 0; i < 9; i++) {

            if (i != 4) {

                if (isValidMove(row - 1 + i / 3, column - 1 + i % 3)) {
                    if (!board.getTile(row - 1 + i / 3, column - 1 + i % 3).isOccupied()) {
                        possibleMoves.add(new Move(row, column, row - 1 + i / 3, column - 1 + i % 3));
                    }

                    if (board.getTile(row - 1 + i / 3, column - 1 + i % 3).isOccupied() && board.getTile(row - 1 + i / 3, column - 1 + i % 3).getPiece().getColor() != color) {
                        possibleMoves.add(new Move(row, column, row - 1 + i / 3, column - 1 + i % 3));
                    }
                }
            }
        }
        return possibleMoves;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        if (color == Piece.WHITE) {
            return "K";
        } else {
            return "k";
        }
    }

    public String printPiece() {
        if (color == Piece.WHITE) {
            return "King";
        } else {
            return "king";
        }
    }

}
