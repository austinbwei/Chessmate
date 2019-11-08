package AI;

import Game.Board;
import Game.Move;
import java.util.ArrayList;

public class AIPlayer {
	private Board board;
	private int depth;
	private BoardEvaluator boardEvaluator;
	public boolean color;

	/**
	 * AI player to make
	 * @param board board to interact with
	 * @param color player color for pieces controlled
	 * @param depth how deep into a minimax tree the ai goes
	 */
    public AIPlayer(Board board, boolean color, int depth) {
		this.board = board;
		this.color = color;
    	this.depth = depth;
    	this.boardEvaluator = new StandardEvaluator(color);
	}

	private Move decide(Board board, float alpha, float beta, int depth) {
    	Board newBoard;
    	long startTime = System.currentTimeMillis();

    	Move bestMove = null;

    	int greatestValue = Integer.MIN_VALUE;
		int currentValue;

		ArrayList<Move> possibleMoves = board.getMoves(color);

		for (int i = 0; i < possibleMoves.size(); i++) {
			newBoard = board.getBoardAfter(board, possibleMoves.get(i));

			currentValue = max(newBoard, alpha, beta,depth - 1);

			if (currentValue >= greatestValue) {
				greatestValue = currentValue;
				bestMove = possibleMoves.get(i);
			}
		}

		long executionTime = System.currentTimeMillis() - startTime;
		System.out.println(executionTime);

		return bestMove;
	}

    private int min(Board board, float alpha, float beta, int depth) {
		Board newBoard;
		ArrayList<Move> opponentPossibleMoves = board.getMoves(!color);

		if (depth == 0) {
			return boardEvaluator.evaluate(board, depth);
		}

		for (int i = 0; i < opponentPossibleMoves.size(); i++) {
			newBoard = board.getBoardAfter(board, opponentPossibleMoves.get(i));

			int currentValue = max(newBoard, alpha, beta,depth - 1);

			if (currentValue < beta) {
				beta = currentValue;
			}

			if (beta <= alpha) {
				break;
			}

		}

    	return (int) beta;
	}

	private int max(Board board, float alpha, float beta, int depth) {
		Board newBoard;
		ArrayList<Move> possibleMoves = board.getMoves(color);

    	if (depth == 0) {
    		return boardEvaluator.evaluate(board, depth);
		}

		for (int i = 0; i < possibleMoves.size(); i++) {
			newBoard = board.getBoardAfter(board, possibleMoves.get(i));

			int currentValue = min(newBoard, alpha, beta, depth - 1);

			if (currentValue > alpha) {
				alpha = currentValue;
			}

			if (beta <= alpha) {
				break;
			}
		}

    	return (int) alpha;
	}

	public void setDepth(int depth) {
    	this.depth = depth;
	}

	public int getDepth() {
    	return depth;
	}

	/**
	 * Make a move
	 */
	public void makeMove() {
		board.makeMove(decide(board, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, depth));
	}

	public Move suggestMove() {
		return decide(board, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, depth);
	}

}
