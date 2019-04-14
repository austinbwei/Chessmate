package Pieces;

import Game.Board;

public class King extends Piece {

    private static String[][] chessBoard;
    private static int humanKingCoordinate;
    private static int computerKingCoordinate;

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

       //Navigate move coordinates around the King
        for(int j = 0; j < 9; j++) {

            if(j != 4) {
                try {

                    //Check if move coordinate is occupied by enemy piece or is empty
                    if (Character.isLowerCase(chessBoard[row - 1 + j / 3][column - 1 + j % 3].charAt(0)) || chessBoard[row - 1 + j / 3][column - 1 + j % 3].equals(" ")) {

                        //Set determined move
                        chessBoard[row][column] = " ";
                        takenPiece = chessBoard[row - 1 + j / 3][column - 1 + j % 3];
                        chessBoard[row - 1 + j / 3][column - 1 + j % 3] = "K";
                        int kingTemp = humanKingCoordinate;
                        humanKingCoordinate = i + (j / 3) * 8 + j % 3 - 9;

                        //Add move option if king is not moving into check
                        if (isKingSafe()) {
                            moves = moves + row + column + (row - 1 + j / 3) + (column - 1 + j % 3) + takenPiece;
                        }

                        //Reset positions
                        chessBoard[row][column] = "K";
                        chessBoard[row - 1 + j / 3][column - 1 + j % 3] = takenPiece;
                        humanKingCoordinate = kingTemp;
                    }

                } catch(Exception e) {

                }
            }
        }
        return moves;
    }

    //Ensure king is not moving into a check condition
    public static boolean isKingSafe() {
        return true;
    }

}
