package Pieces;

import Game.Board;
import Game.Move;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(boolean color) {
        super(color);
        value = 5;
    }

    public Rook clone() {
        return new Rook(color);
    }

    public ArrayList<Move> getLegalMoves(Board board, int row, int column) {
        ArrayList<Move> possibleMoves = new ArrayList<Move>();

        //North
        for (int i = 1; i < 8; i++) {
            if (isValidMove(row, column + i)) {
                if (board.getTile(row, column + i).isOccupied()) {
                    if (board.getTile(row, column + i).getPiece().getColor() != color) {
                        possibleMoves.add(new Move(row, column, row, column + i));
                        break;
                    } else {
                        break;
                    }
                } else {
                    possibleMoves.add(new Move(row, column, row, column + i));
                }
            }
        }

        //South
        for (int i = 1; i < 8; i++) {
            if (isValidMove(row, column - i)) {
                if (board.getTile(row, column - i).isOccupied()) {
                    if (board.getTile(row, column - i).getPiece().getColor() != color) {
                        possibleMoves.add(new Move(row, column, row, column - i));
                        break;
                    } else {
                        break;
                    }
                } else {
                    possibleMoves.add(new Move(row, column, row, column - i));
                }
            }
        }

        //West
        for (int i = 1; i < 8; i++) {
            if (isValidMove(row - i, column)) {
                if (board.getTile(row - i, column).isOccupied()) {
                    if (board.getTile(row - i, column).getPiece().getColor() != color) {
                        possibleMoves.add(new Move(row, column, row - i, column));
                        break;
                    } else {
                        break;
                    }
                } else {
                    possibleMoves.add(new Move(row, column, row - i, column));
                }
            }
        }

        //West
        for (int i = 1; i < 8; i++) {
            if (isValidMove(row + i, column)) {
                if (board.getTile(row + i, column).isOccupied()) {
                    if (board.getTile(row + i, column).getPiece().getColor() != color) {
                        possibleMoves.add(new Move(row, column, row + i, column));
                        break;
                    } else {
                        break;
                    }
                } else {
                    possibleMoves.add(new Move(row, column, row + i, column));
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
            return "R";
        } else {
            return "r";
        }
    }
}
