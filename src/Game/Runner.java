package Game;

import javax.swing.*;

/**
 * @author Austin Weiler
 */
public class Runner {

    public static void main(String[] args) {

        /*
        Lowercase = AI
        Uppercase = Player
        R = Rook
        N = Knight
        B = Bishop
        Q = Queen
        K = King
        P = Pawn
        */
        String[][] defaultBoard = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}};

        Board chessBoard = new Board(defaultBoard);
        chessBoard.printBoard();

        JFrame jframe = new JFrame("Chess");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI gui = new GUI();
        jframe.add(gui);
        jframe.setSize(800, 800);
        jframe.setVisible(true);

//        Move.makeMove(AIPlayer.alphaBeta("", 0, -1000000, 1000000, AIPlayer.DEFAULT_DEPTH));
//        chessBoard.printBoard();
    }
}
