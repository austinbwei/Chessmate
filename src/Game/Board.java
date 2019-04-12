package Game;

import java.util.Arrays;

public class Board {
    private static String[][] chessBoard;

    public Board(String[][] chessBoard) {
        this.chessBoard = chessBoard;
    }

    /**
     * Returns the chessboard 2D array string
     * @return chessboard 2D array string
     */
    public static String[][] getBoard() {
        return chessBoard;
    }

    /**
     * Sets a new a chessboard layout
     * @param newChessBoard new chessboard to set
     */
    public static void setBoard(String[][] newChessBoard) {
        Board.chessBoard = newChessBoard;
    }

    /**
     * Prints the chessboard to console
     */
    public void printBoard() {
        System.out.println();
        for(int i = 0; i < 8; i++){
            System.out.println(Arrays.toString(chessBoard[i]));
        }
    }

}
