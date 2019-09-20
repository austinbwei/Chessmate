package Game;

import Pieces.*;

import java.util.ArrayList;

public class Board {

	private Tile[][] tiles;

	/**
	 * Make a custom 2d board
	 * @param tiles to make board
	 */
	public Board(Tile[][] tiles) {
		this.tiles = tiles;
	}

	/**
	 * Make default chessboard
	 */
	public Board() {
		boolean colorWhite = Piece.WHITE;
		boolean colorBlack = Piece.BLACK;
		tiles = new Tile[8][8];

		//White Pieces
		tiles[7][0] = new Tile(new Rook(colorWhite));
		tiles[7][1] = new Tile(new Knight(colorWhite));
		tiles[7][2] = new Tile(new Bishop(colorWhite));
		tiles[7][3] = new Tile(new Queen(colorWhite));
		tiles[7][4] = new Tile(new King(colorWhite));
		tiles[7][5] = new Tile(new Bishop(colorWhite));
		tiles[7][6] = new Tile(new Knight(colorWhite));
		tiles[7][7] = new Tile(new Rook(colorWhite));

		for (int i = 0; i < 8; i++) {
			tiles[6][i] = new Tile(new Pawn(colorWhite));
		}

		//No mans land
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				tiles[i][j] = new Tile();
			}
		}

		//Black pieces
		tiles[0][0] = new Tile(new Rook(colorBlack));
		tiles[0][1] = new Tile(new Knight(colorBlack));
		tiles[0][2] = new Tile(new Bishop(colorBlack));
		tiles[0][3] = new Tile(new Queen(colorBlack));
		tiles[0][4] = new Tile(new King(colorBlack));
		tiles[0][5] = new Tile(new Bishop(colorBlack));
		tiles[0][6] = new Tile(new Knight(colorBlack));
		tiles[0][7] = new Tile(new Rook(colorBlack));

		for (int i = 0; i < 8; i++) {
			tiles[1][i] = new Tile(new Pawn(colorBlack));
		}

	}

	/**
	 * Return tile object at specific row and column
	 * @param row of tile
	 * @param column of tile
	 * @return tile object
	 */
	public Tile getTile(int row, int column) {
		return tiles[row][column];
	}

	/**
	 * Format board in output log
	 * @return formatted string of board
	 */
	public String toString() {
		String board = "";

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board += tiles[i][j] + " ";
			}
			board += "\n";
		}
		return board;
	}

	/**
	 * Check if player is in check
	 * @param color player to check for
	 * @return whether player is in check or is not
	 */
	public boolean isInCheck(boolean color) {
		int kingRow = -1;
		int kingColumn = -1;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tiles[i][j].isOccupied()
						&& tiles[i][j].getPiece().getColor() == color
						&& tiles[i][j].getPiece().toString().equalsIgnoreCase("K")) {
					kingRow = i;
					kingColumn = j;
				}
			}
		}

		ArrayList<Move> opponentMoves = getMoves(!color, false);

		for (int i = 0; i < opponentMoves.size(); i++) {
			if (opponentMoves.get(i).getRowDestination() == kingRow && opponentMoves.get(i).getColumnDestination() == kingColumn) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Determine if a move will take a player out of check
	 * @param color player to try and get out of check
	 * @param possibleMoves move to test
	 * @return whether player is in check or not after a move
	 */
	public boolean isInCheckAfterMove(boolean color, ArrayList<Move> possibleMoves) {
		Tile[][] newTiles = getTilesAfter(possibleMoves);

		int kingRow = -1;
		int kingColumn = -1;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (newTiles[i][j].isOccupied()
						&& newTiles[i][j].getPiece().getColor() == color
						&& newTiles[i][j].getPiece().toString().equalsIgnoreCase("K")) {
					kingRow = i;
					kingColumn = j;
				}
			}
		}

		ArrayList<Move> opponentMoves = getMovesAfter(!color, possibleMoves, false);

		for (int i = 0; i < opponentMoves.size(); i++) {
			if (opponentMoves.get(i).getRowDestination() == kingRow && opponentMoves.get(i).getColumnDestination() == kingColumn) {
				return true;
			}
		}
		return false;
	}

	public boolean isInCheckmate(boolean color) {
		if(getMoves(color).size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get arraylist of moves for a player
	 * @param color player to find moves for
	 * @return overloaded method to check for checks
	 */
	public ArrayList<Move> getMoves(boolean color) {
		return getMoves(color, true);
	}

	/**
	 * Get arraylist of moves for a player
	 * @param color player to find moves for
	 * @param checkForCheck look for moves that would put the player in check
	 * @return list of possible moves a player can make
	 */
	public ArrayList<Move> getMoves(boolean color, boolean checkForCheck) {
		ArrayList<Move> possibleMoves = new ArrayList<Move>();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tiles[i][j].isOccupied() && tiles[i][j].getPiece().getColor() == color) {
					possibleMoves.addAll(tiles[i][j].getPiece().getLegalMoves(this, i, j));
				}
			}
		}

		if (checkForCheck) {
			int kingRow = -1;
			int kingColumn = -1;

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (tiles[i][j].isOccupied()
							&& tiles[i][j].getPiece().getColor() == color
							&& tiles[i][j].getPiece().toString().equalsIgnoreCase("K")) {
						kingRow = i;
						kingColumn = j;
					}
				}
			}

			ArrayList<Move> inCheckMoves = new ArrayList<Move>();

			for (int i = 0; i < possibleMoves.size(); i++) {
				ArrayList<Move> checkNextMove = new ArrayList<Move>(possibleMoves.subList(i, i + 1));
				ArrayList<Move> opponentMoves = getMovesAfter(!color, checkNextMove, false);


				int newKingRow = kingRow;
				int newKingColumn = kingColumn;
				if (checkNextMove.get(0).getRowOrigin() == kingRow && checkNextMove.get(0).getColumnOrigin() == kingColumn) {
					newKingRow = checkNextMove.get(0).getRowDestination();
					newKingColumn = checkNextMove.get(0).getColumnDestination();
				}

				for (int j = 0; j < opponentMoves.size(); j++) {
					if (opponentMoves.get(j).getRowDestination() == newKingRow && opponentMoves.get(j).getColumnDestination() == newKingColumn) {
						inCheckMoves.add(checkNextMove.get(0));
					}
				}
			}
			possibleMoves.removeAll(inCheckMoves);
		}
		return possibleMoves;
	}

	/**
	 * Get list of moves after a move has been made
	 * @param color player to get list of moves for
	 * @param possibleMoves move to find moves after it has been made
	 * @return overloaded method to check for check
	 */
	public ArrayList<Move> getMovesAfter(boolean color, ArrayList<Move> possibleMoves) {
		return getMovesAfter(color, possibleMoves, true);
	}

	/**
	 * Get list of moves after a move has been made
	 * @param color player to get list of moves for
	 * @param possibleMoves move to find moves after it has been made
	 * @param checkForCheck check if a move will put the player in check
	 * @return arraylist of moves possible after a move has been made
	 */
	public ArrayList<Move> getMovesAfter(boolean color, ArrayList<Move> possibleMoves, boolean checkForCheck) {
		Tile[][] newTiles = new Tile[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				newTiles[i][j] = new Tile(this.tiles[i][j]);
			}
		}

		Board newBoard = new Board(newTiles);

		for (int i = 0; i < possibleMoves.size(); i++) {
			newBoard.makeMove(possibleMoves.get(i));
		}

		ArrayList<Move> nextMoves = newBoard.getMoves(color, checkForCheck);

		return nextMoves;
	}

	/**
	 * Get tiles after a move has been made
	 * @param possibleMoves move made
	 * @return 2d array of tiles after a move
	 */
	public Tile[][] getTilesAfter(ArrayList<Move> possibleMoves) {
		Tile[][] newTiles = new Tile[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				newTiles[i][j] = new Tile(this.tiles[i][j]);
			}
		}

		Board newBoard = new Board(newTiles);

		for (int i = 0; i < possibleMoves.size(); i++) {
			newBoard.makeMove(possibleMoves.get(i));
		}

		Tile[][] newTiles2 = new Tile[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				newTiles2[i][j] = new Tile(newBoard.getTile(i, j));
			}
		}

		return newTiles2;
	}

	public Board getBoardAfter(Board board, Move move) {
		Board newBoard = new Board(board.getTiles());

		newBoard.makeMove(move);

		return newBoard;
	}

	public Tile[][] getTiles() {
		Tile[][] tiles = new Tile[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				tiles[i][j] = new Tile(this.tiles[i][j]);
			}
		}

		return tiles;
	}

	/**
	 * Make a move on the board
	 * @param move to be made
	 */
	public void makeMove(Move move) {
		Tile originTile = tiles[move.getRowOrigin()][move.getColumnOrigin()];

		tiles[move.getRowDestination()][move.getColumnDestination()] = tiles[move.getRowOrigin()][move.getColumnOrigin()];
		tiles[move.getRowOrigin()][move.getColumnOrigin()] = new Tile();

		//Pawn promotion
		if (originTile.getPiece().toString().equals("P") && move.getRowDestination() == 0) {
			tiles[move.getRowDestination()][move.getColumnDestination()] = new Tile(new Queen(Piece.WHITE));
		}

		if (originTile.getPiece().toString().equals("p") && move.getRowDestination() == 7) {
			tiles[move.getRowDestination()][move.getColumnDestination()] = new Tile(new Queen(Piece.BLACK));
		}
	}

}
