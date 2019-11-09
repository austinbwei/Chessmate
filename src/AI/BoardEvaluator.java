package AI;

import Game.Board;

public interface BoardEvaluator {

	int evaluate(Board board, int depth);

	void setAIColor(boolean AIColor);

}
