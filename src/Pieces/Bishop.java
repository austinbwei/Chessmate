package Pieces;

import Game.Player;

public class Bishop extends Piece {
    Type type;

    public Bishop(int x, int y, Player player) {
        super(x, y, player);
        type = Type.BISHOP;
    }

    public boolean isValidPath(int x, int y) {
        return false;
    }

    public int[][] drawPath(int startX, int startY, int endX, int endY) {
        return null;
    }

    public Type getType() {
        return Type.BISHOP;
    }
}
