package Pieces;

import Game.Player;

public class Rook extends Piece {
    Type type;

    public Rook(int x, int y, Player player) {
        super(x, y, player);
        type = Type.ROOK;
    }

    public boolean isValidPath(int x, int y) {
        return false;
    }

    public int[][] drawPath(int startX, int startY, int endX, int endY) {
        return null;
    }

    public Type getType() {
        return Type.ROOK;
    }
}
