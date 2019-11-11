package Game;

import javax.swing.*;
import GUI.*;

public class Game {

	private boolean AIMoved;
	private boolean playerMoved;
	private JFrame jframe;

	Game(boolean AIMoved, boolean playerMoved) {
		this.AIMoved = AIMoved;
		this.playerMoved = playerMoved;
		this.jframe = new MainFrame("Chess", this);
	}

	/**
	 * Start the game by initializing the board, creating the AI, and making the game window
	 */
	public void start() {
		jframe.setSize(740, 570);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.setVisible(true);
	}

	public void addPhaseSuggestion(int turns) {
		//0 = early, 1 = mid, 2 = late
		int phase;
		System.out.println("Turns: " + turns);

		if (turns <= 25) {
			phase = 0;
		} else if (turns <= 40) {
			phase = 1;
		} else {
			phase = 2;
		}
		((MainFrame) jframe).addPhaseSuggestion(phase);
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
