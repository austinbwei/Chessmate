package Game;

import javax.swing.*;
import AI.AIPlayer;
import GUI.*;

public class Game {

	private boolean AIMoved;
	private boolean playerMoved;

	Game(boolean AIMoved, boolean playerMoved) {
		this.AIMoved = AIMoved;
		this.playerMoved = playerMoved;
	}

	/**
	 * Start the game by initializing the board, creating the AI, and making the game window
	 */
	public void start() {
		Board board = new Board();
		System.out.println(board);

		AIPlayer ai = new AIPlayer(board, false, 2);

		JFrame jframe = new MainFrame("Chess", this, board, ai);
		jframe.setSize(740, 570);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.setVisible(true);
	}

	public boolean getAIMoved() {
		return AIMoved;
	}

	public boolean getPlayerMoved() {
		return playerMoved;
	}

	public void setAIMoved(boolean hasMoved) {
		this.AIMoved = hasMoved;
	}

	public void setPlayerMovedMoved(boolean hasMoved) {
		this.playerMoved = hasMoved;
	}

}
