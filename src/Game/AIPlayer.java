package Game;

import java.util.ArrayList;

public class AIPlayer {
    private final int DEPTH;
    private Board board;
    private float alpha;
    private float beta;

	public boolean color;

	/**
	 * AI player to make
	 * @param board board to interact with
	 * @param color player color for pieces controlled
	 * @param alpha float value
	 * @param beta float value
	 * @param depth how deep into a minimax tree the ai goes
	 */
    public AIPlayer(Board board, boolean color, float alpha, float beta, int depth) {
		this.board = board;
		this.color = color;
		this.alpha = alpha;
		this.beta = beta;
    	this.DEPTH = depth;
	}

	/**
	 * Determine move to make
	 * @param alpha float value
	 * @param beta float value
	 * @return move that should be made
	 */
    public Move alphaBeta(float alpha, float beta) {
        ArrayList<Move> possibleMoves = board.getMoves(color);

        int bestMove = 0;

        for (int i = 0; i < possibleMoves.size(); i++) {
        	bestMove = i;
		}
        return possibleMoves.get(bestMove);
    }

	/**
	 * Make a move
	 */
	public void makeMove() {
    	board.makeMove(alphaBeta(-1000000, 1000000));
	}

	/**
	 * Rate how good a move is
	 * @return how good a move is
	 */
    public static int rating() {
        return 0;
    }
}
