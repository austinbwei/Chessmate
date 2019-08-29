package Pieces;

import Game.Board;
import Game.Move;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(boolean color) {
        super(color);
        value = 1;
    }

    public Pawn clone() {
        return new Pawn(color);
    }

    @Override
    public ArrayList<Move> getLegalMoves(Board board, int row, int column) {
        ArrayList<Move> possibleMoves = new ArrayList<Move>();

        if (color == Piece.WHITE) {

            //Capture pieces
            for (int i = -1; i <= 1; i += 2) {
                if (isValidMove(row - 1, column + i)) {
                    if (board.getTile(row - 1, column + i).isOccupied() && board.getTile(row - 1, column + i).getPiece().getColor() != color) {
                        possibleMoves.add(new Move(row, column, row - 1, column + i));
                    }
                }
            }

            //Move one space
            if (isValidMove(row - 1, column)) {
                if (!board.getTile(row - 1, column).isOccupied()) {
                    possibleMoves.add(new Move(row, column, row - 1, column));
                }
            }

            //Move two spaces
            if (row == 6) {
                if (isValidMove(row - 2, column)) {
                    if (!board.getTile(row - 2, column).isOccupied()) {
                        possibleMoves.add(new Move(row, column, row - 2, column));
                    }
                }
            }

        } else {

            //Capture pieces
            for (int i = -1; i <= 1; i += 2) {
                if (isValidMove(row + 1, column + i)) {
                    if (board.getTile(row + 1, column + i).isOccupied() && board.getTile(row + 1, column + i).getPiece().getColor() != color) {
                        possibleMoves.add(new Move(row, column, row + 1, column + i));
                    }
                }
            }

            //Move one space
            if (isValidMove(row + 1, column)) {
                if (!board.getTile(row + 1, column).isOccupied()) {
                    possibleMoves.add(new Move(row, column, row + 1, column));
                }
            }

            //Move two spaces
            if (row == 1) {
                if (isValidMove(row + 2, column)) {
                    if (!board.getTile(row + 2, column).isOccupied()) {
                        possibleMoves.add(new Move(row, column, row + 2, column));
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
            return "P";
        } else {
            return "p";
        }
    }

}
