package Tests;

import Game.Board;
import Game.FindMoves;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestBishop {

    @Test
    public void possibleBishopMove2() {
        String[][] testBishopOptions2 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", "B"}};
        Board.setBoard(testBishopOptions2);

        String expected = "7766 7755 7744 7733 7722 7711 7700 ";
        assertEquals("Bishop has invalid corner move options", expected, FindMoves.possibleMoves());
    }

    @Test
    public void possibleBishopMove3() {
        String[][] testBishopOptions3 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", "B", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "}};
        Board.setBoard(testBishopOptions3);

        String expected = "3423 3412 3401 3425 3416 3407 3443 3452 3461 3470 3445 3456 3467 ";
        assertEquals("Bishop has invalid open move options", expected, FindMoves.possibleMoves());
    }

    @Test
    public void possibleBishopMove4() {
        String[][] testBishopOptions4 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", "p", "k", "p", " ", " "},
                {" ", " ", " ", "p", "B", "r", " ", " "},
                {" ", " ", " ", "b", "n", "b", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "}};
        Board.setBoard(testBishopOptions4);

        String expected = "4443p4445p4463b4465b";
        assertEquals("Bishop has invalid piece detection", expected, FindMoves.possibleMoves());
    }
}
