package Pieces;

import Game.Board;

public class Knight extends Piece {

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

        int row = i / 8;
        int column = i % 8;

        for (int j = -1; j <= 1; j += 2) {
            for (int k = -1; k <= 1; k += 2) {

                //Check standing upright L's
                try {

                    //Check if move coordinate is occupied by enemy piece or is empty
                    if (Character.isLowerCase(chessBoard[row + j][column + k * 2].charAt(0)) || chessBoard[row + j][column + k * 2].equals(" ")) {

                        //Set determined move
                        chessBoard[row][column] = " ";
                        takenPiece = chessBoard[row + j][column + k * 2];
                        chessBoard[row + j][column + k * 2] = "N";

                        //Add move option if king is not going to be in check
                        if (King.isKingSafe()) {
                            moves = moves + row + column + (row + j) + (column + k * 2) + takenPiece;
                        }

                        //Reset positions
                        chessBoard[row][column] = "N";
                        chessBoard[row + j][column + k * 2] = takenPiece;
                    }
                } catch (Exception e) {

                }

                //Check sideways L's
                try {

                    //Check if move coordinate is occupied by enemy piece or is empty
                    if (Character.isLowerCase(chessBoard[row + j * 2][column + k].charAt(0)) || chessBoard[row + j * 2][column + k].equals(" ")) {

                        //Set determined move
                        chessBoard[row][column] = " ";
                        takenPiece = chessBoard[row + j * 2][column + k];
                        chessBoard[row + j * 2][column + k] = "N";

                        //Add move option if king is not going to be in check
                        if (King.isKingSafe()) {
                            moves = moves + row + column + (row + j * 2) + (column + k) + takenPiece;
                        }

                        //Reset positions
                        chessBoard[row][column] = "N";
                        chessBoard[row + j * 2][column + k] = takenPiece;
                    }
                } catch (Exception e) {

                }
            }
        }
        return moves;
    }
}
