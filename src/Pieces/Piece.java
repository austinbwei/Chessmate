package Pieces;

import Game.Board;

public abstract class Piece {

    private static String[][] chessBoard;

    public static String legalMoves(int i) {
        chessBoard = Board.getBoard();

        String moves = "";
        String takenPiece;

        int row = i/8;
        int column = i%8;

        return moves;
    }

}
