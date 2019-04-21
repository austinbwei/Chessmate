package Tests;

import Game.Board;
import Game.FindMoves;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestKnight {

    @Test
    public void possibleKnightMove2() {
        String[][] testKnightOptions2 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", "N"}};
        Board.setBoard(testKnightOptions2);

        String expected = "7765 7756 ";
        assertEquals("Knight has invalid corner move options", expected, FindMoves.possibleMoves());
    }

    @Test
    public void possibleKnightMove3() {
        String[][] testKnightOptions3 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", "N", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "}};
        Board.setBoard(testKnightOptions3);

        String expected = "3422 3413 3426 3415 3442 3453 3446 3455 ";
        assertEquals("Knight has invalid open move options", expected, FindMoves.possibleMoves());
    }

    @Test
    public void possibleKnightMove4() {
        String[][] testKnightOptions4 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", "p", " ", "p", " ", " "},
                {" ", " ", "p", " ", " ", " ", "b", " "},
                {" ", " ", " ", " ", "N", " ", " ", " "},
                {" ", " ", "r", " ", " ", " ", "k", " "},
                {" ", " ", " ", "n", " ", "q", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "}};
        Board.setBoard(testKnightOptions4);

        String expected = "4432p4423p4436b4425p4452r4463n4456k4465q";
        assertEquals("Knight has invalid piece detection", expected, FindMoves.possibleMoves());
    }
}
