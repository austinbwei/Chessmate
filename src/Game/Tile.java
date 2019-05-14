package Game;

import Pieces.Piece;

public class Tile {

    private boolean occupied;
    private Piece piece;

    /**
     * Empty tile
     */
    public Tile() {
        this.occupied = false;
    }

    /**
     * Tile clone of another tile
     * @param tile to clone
     */
    public Tile(Tile tile) {
        this.occupied = tile.isOccupied();

        if (tile.isOccupied()) {
            this.piece = tile.getPiece().clone();
        } else {
            this.piece = null;
        }
    }

    /**
     * Tile to make with a piece occupant
     * @param piece occupying the tile
     */
    public Tile(Piece piece) {
        this.occupied = true;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isOccupied() {
        return occupied;
    }

    /**
     * Print piece initial or symbol depending on if empty or not
     * @return piece initial or empty symbol
     */
    public String toString() {
        if (occupied) {
            return piece.toString();
        } else {
            return "-";
        }
    }

}
