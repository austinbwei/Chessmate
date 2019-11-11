package Pieces;

import Game.Board;
import Game.Move;
import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(boolean color) {
        super(color);
        value = 90;
    }

    public Queen clone() {
        return new Queen(color);
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

        //East
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
            return "Q";
        } else {
            return "q";
        }
    }

    public String printPiece() {
        if (color == Piece.WHITE) {
            return "Queen";
        } else {
            return "queen";
        }
    }
}
