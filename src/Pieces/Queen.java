package Pieces;

import Game.Board;

public class Queen extends Piece {

    private static String[][] chessBoard;

    /**
     * Navigate coordinates around the piece and determine possible moves
     * @param i Coordinate of piece to determine moves for
     * @return Possible moves
     */
    public static String legalMoves(int i) {
        chessBoard = Board.getBoard();

        String moves = "";
        String takenPiece;

        int row = i/8;
        int column = i%8;

        int temp = 1;

        //Navigate move coordinates horizontal, vertical, and diagonal of the Queen
        for(int j = -1; j <= 1; j++) {
            for (int k = -1; k <= 1; k++) {
                if(j != 0 || k != 0) {
                    try {

                        //Find moves until another piece is found or out of array length
                        while (chessBoard[row + temp * j][column + temp * k].equals(" ")) {

                            //Set determined move
                            chessBoard[row][column] = " ";
                            takenPiece = chessBoard[row + temp * j][column + temp * k];
                            chessBoard[row + temp * j][column + temp * k] = "Q";

                            //Add move option if king is not going to be in check
                            if (King.isKingSafe()) {
                                moves = moves + row + column + (row + temp * j) + (column + temp * k) + takenPiece;
                            }

                            //Reset positions
                            chessBoard[row][column] = "Q";
                            chessBoard[row + temp * j][column + temp * k] = takenPiece;
                            temp++;
                        }

                        //Find move coordinates with an enemy piece
                        if (Character.isLowerCase(chessBoard[row + temp * j][column + temp * k].charAt(0))) {

                            //Set determined move
                            chessBoard[row][column] = " ";
                            takenPiece = chessBoard[row + temp * j][column + temp * k];
                            chessBoard[row + temp * j][column + temp * k] = "Q";

                            //Add move option if king is not going to be in check
                            if (King.isKingSafe()) {
                                moves = moves + row + column + (row + temp + j) + (column + temp * k) + takenPiece;
                            }

                            //Reset positions
                            chessBoard[row][column] = "Q";
                            chessBoard[row + temp * j][column + temp * k] = takenPiece;
                        }
                    } catch (Exception e) {

                    }
                    temp = 1;
                }
            }
        }
        return moves;
    }
}
