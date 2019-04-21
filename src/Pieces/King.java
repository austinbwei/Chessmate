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

        while(!chessBoard[humanKingCoordinate / 8][humanKingCoordinate % 8].equals("A")) {
            humanKingCoordinate++;
        }

        while(!chessBoard[computerKingCoordinate / 8][computerKingCoordinate % 8].equals("A")) {
            computerKingCoordinate++;
        }


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
}
