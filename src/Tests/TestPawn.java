package Tests;

import Game.Board;
import Game.FindMoves;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPawn {

    @Test
    public void possiblePawnMove2() {
        String[][] testPawnOptions2 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", "P"},
                {" ", " ", " ", " ", " ", " ", " ", " "}};
        Board.setBoard(testPawnOptions2);

        String expected = "6757 6747 6757 6747 ";
        assertEquals("Pawn has invalid initial move options", expected, FindMoves.possibleMoves());
    }

    @Test
    public void possiblePawnMove3() {
        String[][] testPawnOptions3 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", "P", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "}};
        Board.setBoard(testPawnOptions3);

        String expected = "3424 3424 ";
        assertEquals("Pawn has invalid open move options", expected, FindMoves.possibleMoves());
    }

    @Test
    public void possiblePawnMove4() {
        String[][] testPawnOptions4 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", "r", " ", "n", " ", " "},
                {" ", " ", " ", " ", "P", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "}};
        Board.setBoard(testPawnOptions4);

        String expected = "4434 4433r4434 4435n";
        assertEquals("Pawn has invalid piece detection", expected, FindMoves.possibleMoves());
    }

    @Test
    public void possiblePawnMove5() {
        String[][] testPawnOptions5 = {
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", "P", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "}};
        Board.setBoard(testPawnOptions5);

        String expected = "33 RP33 BP33 NP33 QP33 RP33 BP33 NP33 QP";
        assertEquals("Pawn has invalid standard promotion", expected, FindMoves.possibleMoves());
    }

    @Test
    public void possiblePawnMove6() {
        String[][] testPawnOptions6 = {
                {" ", " ", "r", " ", "n", " ", " ", " "},
                {" ", " ", " ", "P", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "}};
        Board.setBoard(testPawnOptions6);

        String expected = "33 RP33 BP33 NP33 QP32rrRP32rrBP32rrNP32rrQP33 RP33 BP33 NP33 QP34nnRP34nnBP34nnNP34nnQP";
        assertEquals("Pawn has invalid capture promotion", expected, FindMoves.possibleMoves());
    }

}
