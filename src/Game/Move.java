package Game;

import Pieces.King;

public class Move {

    private static String[][] chessBoard;

    public static void makeMove(String move) {
        chessBoard = Board.getBoard();

        if (move.charAt(4) != 'P') {
            chessBoard[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))] = chessBoard[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))];
            chessBoard[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))] = " ";

            if (chessBoard[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))].equals("K")) {
                King.humanKingCoordinate = 8 * Character.getNumericValue(move.charAt(2)) + Character.getNumericValue(move.charAt(3));
            }

        } else {
            chessBoard[1][Character.getNumericValue(move.charAt(0))] = " ";
            chessBoard[0][Character.getNumericValue(move.charAt(1))] = String.valueOf(move.charAt(3));
        }
    }

    public static void undoMove(String move) {
        chessBoard = Board.getBoard();


        if (move.charAt(4) != 'P') {
            chessBoard[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))] = chessBoard[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))];
            chessBoard[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))] = String.valueOf(move.charAt(4));

            if (chessBoard[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))].equals("K")) {
                King.humanKingCoordinate = 8 * Character.getNumericValue(move.charAt(0)) + Character.getNumericValue(move.charAt(1));
            }

        } else {
            chessBoard[1][Character.getNumericValue(move.charAt(0))] = "P";
            chessBoard[0][Character.getNumericValue(move.charAt(1))] = String.valueOf(move.charAt(2));
        }
    }

}
