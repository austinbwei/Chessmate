package AI;

import Game.Board;
import Game.Tile;

public class StandardEvaluator implements BoardEvaluator {
	boolean AIColor;

	StandardEvaluator(boolean AIColor) {
		this.AIColor = AIColor;
	}

	@Override
	public int evaluate(Board board, int depth) {
		return scorePlayer(board, AIColor, depth) - scorePlayer(board, !AIColor, depth);
	}

	private int scorePlayer(Board board, boolean color, int depth) {
		return pieceValue(board, color) + moveOptions(board, color) + check(board, color) + checkmate(board, color);
	}

	private int check(Board board, boolean color) {
		if (board.isInCheck(!color)) {
			return 15;
		} else {
			return 0;
		}
	}

	private int checkmate(Board board, boolean color) {
		if (board.isInCheckmate(!color)) {
			return 1000;
		} else {
			return 0;
		}
	}

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

	private int moveOptions(Board board, boolean color) {
		return board.getMoves(color).size() / 2;
	}

}
