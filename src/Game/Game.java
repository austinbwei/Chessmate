package Game;

import javax.swing.*;
import GUI.*;

public class Game {

	private JFrame jframe;

	Game() {
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

	/**
	 * Pass generated phase suggestion to mainframe
	 * @param turns a normal game took before finished
	 */
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

}
