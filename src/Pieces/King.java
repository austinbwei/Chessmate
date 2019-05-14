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

    public String toString() {
        if (color == Piece.WHITE) {
            return "K";
        } else {
            return "k";
        }
    }




/*

    //Ensure king is not moving into a check condition
    public static boolean isKingSafe() {

        int loc = 1;

        //Safe from Bishop and Queens
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                try {
                    while (chessBoard[humanKingCoordinate / 8 + loc * i][humanKingCoordinate % 8 + loc * j].equals(" ")) {
                        loc++;
                    }

                    if(chessBoard[humanKingCoordinate / 8 + loc * i][humanKingCoordinate % 8 + loc * j].equals("b")
                    || chessBoard[humanKingCoordinate / 8 + loc * i][humanKingCoordinate % 8 + loc * j].equals("q")) {
                        return false;
                    }
                } catch (Exception e) {

                }
                    loc = 1;
            }
        }


        //Safe from Rooks and Queens
        for (int i = -1; i <= 1; i += 2) {

            //Check Verticals
            try {
                while (chessBoard[humanKingCoordinate / 8][humanKingCoordinate % 8 + loc * i].equals(" ")) {
                    loc++;
                }

                if(chessBoard[humanKingCoordinate / 8][humanKingCoordinate % 8 + loc * i].equals("r")
                        || chessBoard[humanKingCoordinate / 8][humanKingCoordinate % 8 + loc * i].equals("q")) {
                    return false;
                }
            } catch (Exception e) {

            }

            loc = 1;

            //Check Horizontals
            try {
                while (chessBoard[humanKingCoordinate / 8 + loc * i][humanKingCoordinate % 8].equals(" ")) {
                    loc++;
                }

                if(chessBoard[humanKingCoordinate / 8 + loc * i][humanKingCoordinate % 8].equals("r")
                        || chessBoard[humanKingCoordinate / 8 + loc * i][humanKingCoordinate % 8].equals("q")) {
                    return false;
                }
            } catch (Exception e) {

            }
            loc = 1;
        }


        //Safe from Knights
        for (int i = -1; i <= 1; i+= 2) {
            for (int j = -1; j <= 1; j+= 2) {
                try {
                    if (chessBoard[humanKingCoordinate / 8 + i][humanKingCoordinate % 8 + j * 2].equals("n")) {
                        return false;
                    }
                } catch (Exception e) {

                }
                try {
                    if (chessBoard[humanKingCoordinate / 8 + i * 2][humanKingCoordinate % 8 + j].equals("n")) {
                        return false;
                    }
                } catch (Exception e) {

                }
            }
        }


        //Safe from Pawns
        if (humanKingCoordinate >= 16) {
            try {
                if(chessBoard[humanKingCoordinate / 8 - 1][humanKingCoordinate % 8 - 1].equals("p")) {
                    return false;
                }
            } catch (Exception e) {

            }
            try {
                if (chessBoard[humanKingCoordinate / 8 - 1][humanKingCoordinate % 8 + 1].equals("p")) {
                    return false;
                }
            } catch (Exception e) {

            }
        }


        //Safe from other King
        for(int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    try {
                        if (chessBoard[humanKingCoordinate / 8 + i][humanKingCoordinate % 8 + j].equals("a")) {
                            return false;
                        }
                    } catch (Exception e) {

                    }
                }
            }
        }

        return true;


    }
*/
}
