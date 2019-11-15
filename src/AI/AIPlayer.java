package AI;

import Game.Board;
import Game.Move;
import java.util.ArrayList;

public class AIPlayer {

	private Board board;
	private int depth;
	private BoardEvaluator boardEvaluator;
	public boolean aiColor;
	private Board newBoard;

	/**
	 * AI player to make
	 * @param board board to interact with
	 * @param aiColor player color for pieces controlled
	 * @param depth how deep into a minimax tree the ai goes
	 */
    public AIPlayer(Board board, boolean aiColor, int depth) {
		this.board = board;
		this.aiColor = aiColor;
    	this.depth = depth;
    	this.boardEvaluator = new StandardEvaluator();
	}

	private Move alphaBeta(Board board, boolean player, float alpha, float beta, int depth) {
		if (depth == 0 || board.isInCheckmate(aiColor) || board.isInCheckmate(!aiColor)) {
			Move returnMove = new Move();
			returnMove.setValue(boardEvaluator.evaluate(board, player));
			return returnMove;
		} else {
			ArrayList<Move> moves = board.getMoves(player);
			Move bestMove = moves.get(0);
			for (Move move : moves) {
				newBoard = new Board(board.getTiles());
				newBoard.makeMove(move);
				Move tempMove = alphaBeta(newBoard, !player, -beta, -alpha, depth - 1);
				move.setValue(-tempMove.getValue());
				if (move.getValue() > alpha){
					bestMove = move;
					alpha = move.getValue();
					if (alpha > beta)
						return bestMove;
				}
			}
			return bestMove;
		}
	}

	public void setDepth(int depth) {
    	this.depth = depth;
	}

	public void setColor(boolean aiColor) {
    	this.aiColor = aiColor;
	}

	public boolean getColor() {
    	return aiColor;
	}

	/**
	 * Make the best move evaluated on the board given
	 */
	public void makeMove() {
		board.makeMove(alphaBeta(board, aiColor, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, depth));
	}

	/**
	 * Get the best move without making the move
	 * @return most valuable move
	 */
	public Move suggestMove() {
		return alphaBeta(board, aiColor, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 3);
	}

	/**
	 * Rate opponent's move against this AI
	 * @param board to judge
	 * @param m move being tested
	 * @return value of move
	 */
	public int rateMove(Board board, Move m) {
    	Board newBoard = new Board(board.getTiles());
		newBoard.makeMove(m);
		return boardEvaluator.evaluate(newBoard, !aiColor);
	}

}
