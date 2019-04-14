package Game;

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
        System.out.println(FindMoves.possibleMoves());
    }
}
