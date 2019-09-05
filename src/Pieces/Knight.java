package Pieces;

import Game.Board;
import Game.Move;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(boolean color) {
        super(color);
        value = 3;
    }

    public Knight clone() {
        return new Knight(color);
    }

    public ArrayList<Move> getLegalMoves(Board board, int row, int column) {
        ArrayList<Move> possibleMoves = new ArrayList<Move>();

        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <=1; j += 2) {

                //Check standing upright L's
                if (isValidMove(row + i, column + j * 2)) {
                    if (!board.getTile(row + i, column + j * 2).isOccupied()) {
                        possibleMoves.add(new Move(row, column, row + i, column + j * 2));
                    }

                    if (board.getTile(row + i, column + j * 2).isOccupied() && board.getTile(row + i, column + j * 2).getPiece().getColor() != color) {
                        possibleMoves.add(new Move(row, column, row + i, column + j * 2));
                    }
                }

                //Check sideways L's
                if (isValidMove(row + i * 2, column + j)) {
                    if (!board.getTile(row + i * 2, column + j).isOccupied()) {
                        possibleMoves.add(new Move(row, column, row + i * 2, column + j));
                    }

                    if (board.getTile(row + i * 2, column + j).isOccupied() && board.getTile(row + i * 2, column + j).getPiece().getColor() != color) {
                        possibleMoves.add(new Move(row, column, row + i * 2, column + j));
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
            return "N";
        } else {
            return "n";
        }
    }

    public String printPiece() {
        if (color == Piece.WHITE) {
            return "Knight";
        } else {
            return "knight";
        }
    }

}
