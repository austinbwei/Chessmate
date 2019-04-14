package Pieces;

import Game.Board;

public class Rook extends Piece {

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

        //Navigate move coordinates horizontal and vertical of the Rook
        for (int j = -1; j <= 1; j += 2) {

            //Navigate vertical coordinates of the Rook
            try {

                //Find moves until another piece is found or out of array length
                while(chessBoard[row][column + temp * j].equals(" ")) {

                    //Set determined move
                    chessBoard[row][column] = " ";
                    takenPiece = chessBoard[row][column + temp * j];
                    chessBoard[row][column + temp * j] = "R";

                    //Add move option if king is not going to be in check
                    if(King.isKingSafe()) {
                        moves = moves + row + column + row + (column + temp * j) + takenPiece;
                    }

                    //Reset positions
                    chessBoard[row][column] = "R";
                    chessBoard[row][column + temp * j] = takenPiece;
                    temp++;
                }

                //Find move coordinates with an enemy piece
                if (Character.isLowerCase(chessBoard[row][column + temp * j].charAt(0))) {

                    //Set determined move
                    chessBoard[row][column] = " ";
                    takenPiece = chessBoard[row][column + temp * j];
                    chessBoard[row][column + temp * j] = "R";

                    //Add move option if king is not going to be in check
                    if(King.isKingSafe()) {
                        moves = moves + row + column + row + (column + temp * j) + takenPiece;
                    }

                    //Reset positions
                    chessBoard[row][column] = "R";
                    chessBoard[row][column + temp * j] = takenPiece;
                }
            } catch (Exception e) {

            }

            temp = 1;

            //Navigate horizontal coordinates of the Rook
            try {

                //Find moves until another piece is found or out of array length
                while(chessBoard[row + temp * j][column].equals(" ")) {

                    //Set determined move
                    chessBoard[row][column] = " ";
                    takenPiece = chessBoard[row + temp * j][column];
                    chessBoard[row + temp * j][column] = "R";

                    //Add move option if king is not going to be in check
                    if(King.isKingSafe()) {
                        moves = moves + row + column + (row + temp * j) + column + takenPiece;
                    }

                    //Reset positions
                    chessBoard[row][column] = "R";
                    chessBoard[row + temp * j][column] = takenPiece;
                    temp++;
                }

                //Find move coordinates with an enemy piece
                if (Character.isLowerCase(chessBoard[row + temp * j][column].charAt(0))) {

                    //Set determined move
                    chessBoard[row][column] = " ";
                    takenPiece = chessBoard[row + temp * j][column];
                    chessBoard[row + temp * j][column] = "R";

                    //Add move option if king is not going to be in check
                    if(King.isKingSafe()) {
                        moves = moves + row + column + (row + temp * j) + column + takenPiece;
                    }

                    //Reset positions
                    chessBoard[row][column] = "R";
                    chessBoard[row + temp * j][column] = takenPiece;
                }
            } catch (Exception e) {

            }
            temp = 1;
        }
        return moves;
    }
}
