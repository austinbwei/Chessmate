package Pieces;

import Game.*;

public abstract class Piece {
    public int x, y;
    public Player player;

    public Piece(int x, int y, Player player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    public abstract boolean isValidPath(int x, int y);

    public abstract int [][] drawPath(int startX, int startY, int endX, int endY);

    public abstract Type getType();
}
