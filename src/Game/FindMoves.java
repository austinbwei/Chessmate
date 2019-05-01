package Game;

import Pieces.*;

public class FindMoves {

    /**
     * Navigates through the chessboard array to find all possible moves
     * @return list of moves that can be made
     */
    public static String possibleMoves() {
        String[][] chessBoard = Board.getBoard();
        String list = "";
        for(int i = 0; i < 64; i++) {
            switch(chessBoard[i/8][i%8]) {
                case "P":
                    list += Pawn.legalMoves(i);
                    break;
                case "R":
                    list += Rook.legalMoves(i);
                    break;
                case "N":
                    list += Knight.legalMoves(i);
                    break;
                case "B":
                    list += Bishop.legalMoves(i);
                    break;
                case "Q":
                    list += Queen.legalMoves(i);
                    break;
                case "K":
                    list += King.legalMoves(i);
                    break;
            }
        }
        return list;
    }

}
