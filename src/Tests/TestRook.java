package Tests;

import Game.Board;
import Game.FindMoves;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestRook {

    @Test
    public void possibleRookMove2() {
        String[][] testRookOptions2 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", "R"}};
        Board.setBoard(testRookOptions2);

        String expected = "7776 7775 7774 7773 7772 7771 7770 7767 7757 7747 7737 7727 7717 7707 ";
        assertEquals("Rook has invalid corner move options", expected, FindMoves.possibleMoves());
    }

    @Test
    public void possibleRookMove3() {
        String[][] testRookOptions3 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", "R", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "}};
        Board.setBoard(testRookOptions3);

        String expected = "3433 3432 3431 3430 3424 3414 3404 3435 3436 3437 3444 3454 3464 3474 ";
        assertEquals("Rook has invalid open move options", expected, FindMoves.possibleMoves());
    }

    @Test
    public void possibleRookMove4() {
        String[][] testRookOptions4 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", "p", "k", "p", " ", " "},
                {" ", " ", " ", "p", "R", "r", " ", " "},
                {" ", " ", " ", "b", "n", "b", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "}};
        Board.setBoard(testRookOptions4);

        String expected = "4443p4434k4445r4454n";
        assertEquals("Rook has invalid piece detection", expected, FindMoves.possibleMoves());
    }

}
