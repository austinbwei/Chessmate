package Game;

import Pieces.*;

public class FindMoves {

    //private static String[][] chessBoard = Board.getBoard();

    public static String possibleMoves() {
        String[][] chessBoard = Board.getBoard();

        String list = "";
        for(int i = 0; i < 64; i++) {
            switch(chessBoard[i/8][i%8]) {
                case "P":
                    break;
                case "R":
                    break;
                case "N":
                    break;
                case "B":
                    break;
                case "Q":
                    break;
                case "K":
                    list += King.legalMoves(i);
                    break;
            }
        }
        return list;
    }

}
