package Tests;

import Game.Board;
import Game.FindMoves;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestKing {

    @Test
    public void possibleKingMove1() {
        String[][] testKingOptions1 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", "P", "P", "P", " ", " "},
                {" ", " ", " ", "Q", "K", "B", " ", " "}};
        Board.setBoard(testKingOptions1);

        String expected = "";
        assertEquals("King has invalid initial move options", expected, FindMoves.possibleMoves());
    }

    @Test
    public void possibleKingMove2() {
        String[][] testKingOptions2 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", "K"}};
        Board.setBoard(testKingOptions2);

        String expected = "7766 7767 7776 ";
        assertEquals("King has invalid corner move options", expected, FindMoves.possibleMoves());
    }

    @Test
    public void possibleKingMove3() {
        String[][] testKingOptions3 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", "K", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "}};
        Board.setBoard(testKingOptions3);

        String expected = "3423 3424 3425 3433 3435 3443 3444 3445 ";
        assertEquals("King has invalid open move options", expected, FindMoves.possibleMoves());
    }

    @Test
    public void possibleKingMove4() {
        String[][] testKingOptions4 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", "P", "p", " ", " "},
                {" ", " ", " ", " ", "K", "r", " ", " "},
                {" ", " ", " ", "b", "n", "Q", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "}};
        Board.setBoard(testKingOptions4);

        String expected = "4433 4435p4443 4445r4453b4454n";
        assertEquals("King has invalid piece detection", expected, FindMoves.possibleMoves());
    }
}