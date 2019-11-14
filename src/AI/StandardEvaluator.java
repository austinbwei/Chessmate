package AI;

import Game.Board;
import Game.Tile;

public class StandardEvaluator implements BoardEvaluator {

	StandardEvaluator() {

	}

	@Override
	public int evaluate(Board board, boolean color) {
		return pieceValue(board, color) +
				check(board, color) +
				checkmate(board, color) +
				moveOptions(board, color) -
				piecesAtRisk(board, color) -
				stalemate(board, color);
	}

	/**
	 * Returns value if it results in opponent being in check
	 * @param board to judge and evaluate
	 * @param color of player
	 * @return Value if opponent will be in check
	 */
	private int check(Board board, boolean color) {
		if (board.isInCheck(!color)) {
			return 50;
		} else {
			return 0;
		}
	}

	/**
	 * Returns value if it results in opponent being in checkmate
	 * @param board to judge and evaluate
	 * @param color of player
	 * @return Value if opponent will be in checkmate
	 */
	private int checkmate(Board board, boolean color) {
		if (board.isInCheckmate(!color)) {
			return 500;
		} else {
			return 0;
		}
	}

	/**
	 * Gets all friendly piece values
	 * @param board to judge and evaluate
	 * @param color of player
	 * @return All friendly piece values
	 */
	private int pieceValue(Board board, boolean color) {
		Tile[][] tiles = board.getTiles();
		int playerPieceScore = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tiles[i][j].isOccupied()) {
					if (tiles[i][j].getPiece().getColor() == color) {
						playerPieceScore += tiles[i][j].getPiece().getValue();
					}
				}
			}
		}
		return playerPieceScore;
	}

	/**
	 * Gets piece values of pieces in a position that they can be taken by another piece
	 * @param board to judge and evaluate
	 * @param color of player
	 * @return All friendly piece values that can be taken by the opponent
	 */
	private int piecesAtRisk(Board board, boolean color) {
		Tile[][] tiles = board.getTiles();
		int playerDangerScore = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tiles[i][j].isOccupied()) {
					if (tiles[i][j].getPiece().getColor() == color) {
						if (board.isPieceAtRisk(color, i, j)) {
							playerDangerScore += tiles[i][j].getPiece().getValue();
						}
					}
				}
			}
		}
		return playerDangerScore;
	}

	/**
	 * Determines if opposite player is in stalemate
	 * AI is looking for a win rather than a draw
	 * @param board to judge and evaluate
	 * @param color of player
	 * @return Value if opponent is in stalemate
	 */
	private int stalemate(Board board, boolean color) {
		if (board.isInStalemate(!color)) {
			return 300;
		} else {
			return 0;
		}
	}

	/**
	 * Number of moves available
	 * @param board to judge and evaluate
	 * @param color of player
	 * @return Number of move options available
	 */
	private int moveOptions(Board board, boolean color) {
		return board.getMoves(color).size() / 3;
	}

}
