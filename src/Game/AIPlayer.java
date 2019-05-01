package Game;

import Pieces.King;

public class AIPlayer {

    static final int DEFAULT_DEPTH = 4;
    private static String[][] chessBoard = Board.getBoard();


    public static String alphaBeta(String move, int player, int alpha, int beta, int depth) {
        String possibleMoves = FindMoves.possibleMoves();

        if (depth == 0 || possibleMoves.length() == 0) {
            return move + (rating() * (player * 2 - 1));
        }

        player = 1 - player;

        for (int i = 0; i < possibleMoves.length(); i += 5) {
            Move.makeMove(possibleMoves.substring(i, i + 5));

            flipBoard();
            String returnedMoves = alphaBeta(possibleMoves.substring(i, i + 5), player, alpha, beta, depth - 1);
            int value = Integer.valueOf(returnedMoves.substring(5));

            flipBoard();
            Move.undoMove(possibleMoves.substring(i, i + 5));

            if (player == 0) {
                if (value <= beta) {

                    beta = value;

                    if (depth == DEFAULT_DEPTH) {
                        move = returnedMoves.substring(0, 5);
                    }
                }
            } else {
                if (value > alpha) {

                    alpha = value;

                    if (depth == DEFAULT_DEPTH) {
                        move = returnedMoves.substring(0, 5);
                    }
                }
            }

            if (alpha >= beta) {
                if (player == 0) {
                    return move + beta;
                } else {
                    return move + alpha;
                }
            }
        }

        if (player == 0) {
            return move + beta;
        } else {
            return move + alpha;
        }
    }

    public static int rating() {
        return 0;
    }

    public static void flipBoard() {
        chessBoard = Board.getBoard();
        String temp;

        for (int i = 0; i < 32; i++) {
            int row = i / 8;
            int column = i % 8;

            if (Character.isUpperCase(chessBoard[row][column].charAt(0))) {
                temp = chessBoard[row][column].toLowerCase();
            } else {
                temp = chessBoard[row][column].toUpperCase();
            }

            if (Character.isUpperCase(chessBoard[7 - row][7 - column].charAt(0))) {
                chessBoard[row][column] = chessBoard[7 - row][7 - column].toLowerCase();
            } else {
                chessBoard[row][column] = chessBoard[7 - row][7 - column].toUpperCase();
            }

            chessBoard[7 - row][7 - column] = temp;

        }

        int kingTemp = King.humanKingCoordinate;
        King.humanKingCoordinate = 63 - King.computerKingCoordinate;
        King.computerKingCoordinate = 63 - kingTemp;

    }

}
