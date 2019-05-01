package Pieces;

import Game.Board;

public class Pawn extends Piece {

    private static String[][] chessBoard;

    public static String legalMoves(int i) {
        chessBoard = Board.getBoard();

        String moves = "";
        String takenPiece;

        int row = i / 8;
        int column = i % 8;

        for (int j = -1; j <= 1; j += 2) {

            //Normal Capture
            try {

                //Check if move coordinate is occupied by enemy piece or is empty
                if (Character.isLowerCase(chessBoard[row - 1][column + j].charAt(0)) && i >= 16) {

                    //Set determined move
                    chessBoard[row][column] = " ";
                    takenPiece = chessBoard[row - 1][column + j];
                    chessBoard[row - 1][column + j] = "P";

                    //Add move option if king is not going to be in check
                    if (King.isKingSafe()) {
                        moves = moves + row + column + (row - 1) + (column + j) + takenPiece;
                    }

                    //Reset positions
                    chessBoard[row][column] = "P";
                    chessBoard[row - 1][column + j] = takenPiece;
                }
            } catch (Exception e) {

            }

            //Capture and Promote
            try {

                //Check if move coordinate is occupied by enemy piece or is empty
                if (Character.isLowerCase(chessBoard[row - 1][column + j].charAt(0)) && i < 16) {

                    //Array of pieces a pawn can promote to.
                    String[] promotionOptions = {"R", "B", "N", "Q"};

                    //Create list of moves after promotion
                    for (int k = 0; k < 4; k++) {

                        //Set determined move
                        chessBoard[row][column] = " ";
                        takenPiece = chessBoard[row - 1][column + j];
                        chessBoard[row - 1][column + j] = promotionOptions[k];

                        //Add move option if king is not going to be in check
                        if (King.isKingSafe()) {
                            moves = moves + column + (column + j) + takenPiece + promotionOptions[k] + "P";
                        }

                        //Reset positions
                        chessBoard[row][column] = "P";
                        chessBoard[row - 1][column + j] = takenPiece;
                    }
                }
            } catch (Exception e) {

            }
        }

            //Move one space
            try {

                //Check if move coordinate is empty
                if(chessBoard[row - 1][column].equals(" ") && i >= 16) {

                    //Set determined move
                    chessBoard[row][column] = " ";
                    takenPiece = chessBoard[row - 1][column];
                    chessBoard[row - 1][column] = "P";

                    //Add move option if king is not going to be in check
                    if(King.isKingSafe()) {
                        moves = moves + row + column + (row - 1) + column + takenPiece;
                    }

                    //Reset positions
                    chessBoard[row][column] = "P";
                    chessBoard[row - 1][column] = takenPiece;
                }
            } catch (Exception e) {

            }

            //Move two spaces
            try {

                //Check if move coordinate is empty
                if(chessBoard[row - 1][column].equals(" ") && chessBoard[row - 2][column].equals(" ") && i >= 48) {

                    //Set determined move
                    chessBoard[row][column] = " ";
                    takenPiece = chessBoard[row - 2][column];
                    chessBoard[row - 2][column] = "P";

                    //Add move option if king is not going to be in check
                    if(King.isKingSafe()) {
                        moves = moves + row + column + (row - 2) + column + takenPiece;
                    }

                    //Reset positions
                    chessBoard[row][column] = "P";
                    chessBoard[row - 2][column] = takenPiece;
                }
            } catch (Exception e) {

            }

            //Normal Promote
            try {

                //Check if move coordinate is occupied by enemy piece or is empty
                if(chessBoard[row - 1][column].equals(" ") && i < 16) {

                    //Array of pieces a pawn can promote to.
                    String[] promotionOptions = {"R", "B", "N", "Q"};

                    //Create list of moves after promotion
                    for (int k = 0; k < 4; k++) {

                        //Set determined move
                        chessBoard[row][column] = " ";
                        takenPiece = chessBoard[row - 1][column];
                        chessBoard[row - 1][column] = promotionOptions[k];

                        //Add move option if king is not going to be in check
                        if(King.isKingSafe()) {
                            moves = moves + column + column + takenPiece + promotionOptions[k] + "P";
                        }

                        //Reset positions
                        chessBoard[row][column] = "P";
                        chessBoard[row - 1][column] = takenPiece;
                    }
                }
            } catch (Exception e) {

            }

        return moves;

    }

}
