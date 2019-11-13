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
				piecesAtRisk(board, color);
	}

	private int check(Board board, boolean color) {
		if (board.isInCheck(!color)) {
			return 50;
		} else {
			return 0;
		}
	}

	private int checkmate(Board board, boolean color) {
		if (board.isInCheckmate(!color)) {
			return 500;
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

	private int moveOptions(Board board, boolean color) {
		return board.getMoves(color).size() / 3;
	}

}
