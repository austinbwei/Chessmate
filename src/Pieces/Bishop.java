package Pieces;

import Game.Board;
import Game.Move;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(boolean color) {
        super(color);
        value = 3;
    }

    public Bishop clone() {
        return new Bishop(color);
    }

    public ArrayList<Move> getLegalMoves(Board board, int row, int column) {
        ArrayList<Move> possibleMoves = new ArrayList<Move>();

        //Northeast
        for (int i = 1; i < 8; i++) {
            if (isValidMove(row + i, column + i)) {
                if (board.getTile(row + i, column + i).isOccupied()) {
                    if (board.getTile(row + i, column + i).getPiece().color != color) {
                        possibleMoves.add(new Move(row, column, row + i, column + i));
                        break;
                    } else {
                        break;
                    }
                } else {
                    possibleMoves.add(new Move(row, column, row + i, column + i));
                }
            }
        }

        //Southeast
        for (int i = 1; i < 8; i++) {
            if (isValidMove(row - i, column + i)) {
                if (board.getTile(row - i, column + i).isOccupied()) {
                    if (board.getTile(row - i, column + i).getPiece().color != color) {
                        possibleMoves.add(new Move(row, column, row - i, column + i));
                        break;
                    } else {
                        break;
                    }
                } else {
                    possibleMoves.add(new Move(row, column, row - i, column + i));
                }
            }
        }

        //Northwest
        for (int i = 1; i < 8; i++) {
            if (isValidMove(row + i, column - i)) {
                if (board.getTile(row + i, column - i).isOccupied()) {
                    if (board.getTile(row + i, column - i).getPiece().color != color) {
                        possibleMoves.add(new Move(row, column, row + i, column - i));
                        break;
                    } else {
                        break;
                    }
                } else {
                    possibleMoves.add(new Move(row, column, row + i, column - i));
                }
            }
        }

        //Southwest
        for (int i = 1; i < 8; i++) {
            if (isValidMove(row - i, column - i)) {
                if (board.getTile(row - i, column - i).isOccupied()) {
                    if (board.getTile(row - i, column - i).getPiece().color != color) {
                        possibleMoves.add(new Move(row, column, row - i, column - i));
                        break;
                    } else {
                        break;
                    }
                } else {
                    possibleMoves.add(new Move(row, column, row - i, column - i));
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
            return "B";
        } else {
            return "b";
        }
    }

    public String printPiece() {
        if (color == Piece.WHITE) {
            return "Bishop";
        } else {
            return "bishop";
        }
    }

}
