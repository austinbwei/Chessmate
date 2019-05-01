package Tests;

import Game.Board;
import Game.FindMoves;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestQueen {

    @Test
    public void possibleQueenMove2() {
        String[][] testQueenOptions2 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", "Q"}};
        Board.setBoard(testQueenOptions2);

        String expected = "7766 7755 7744 7733 7722 7711 7700 7767 7757 7747 7737 7727 7717 7707 7776 7775 7774 7773 7772 7771 7770 ";
        assertEquals("Queen has invalid corner move options", expected, FindMoves.possibleMoves());
    }

    @Test
    public void possibleQueenMove3() {
        String[][] testQueenOptions3 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", "Q", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "}};
        Board.setBoard(testQueenOptions3);

        String expected = "3423 3412 3401 3424 3414 3404 3425 3416 3407 3433 3432 3431 3430 3435 3436 3437 3443 3452 3461 3470 3444 3454 3464 3474 3445 3456 3467 ";
        assertEquals("Queen has invalid open move options", expected, FindMoves.possibleMoves());
    }

    @Test
    public void possibleQueenMove4() {
        String[][] testQueenOptions4 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", "p", "k", "p", " ", " "},
                {" ", " ", " ", "p", "Q", "r", " ", " "},
                {" ", " ", " ", "b", "n", "b", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "}};
        Board.setBoard(testQueenOptions4);

        String expected = "4433p4434k4435p4443p4445r4453b4454n4455b";
        assertEquals("queen has invalid piece detection", expected, FindMoves.possibleMoves());
    }
}
