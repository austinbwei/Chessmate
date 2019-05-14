package Game;

import javax.swing.*;

public class Game {

	/**
	 * Start the game by initializing the board, creating the AI, and making the game window
	 */
	public static void start() {
		Board board = new Board();
		System.out.println(board);

		AIPlayer ai = new AIPlayer(board, false, -1000000, 1000000, 4);

		JFrame jframe = new JFrame("Chess");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI gui = new GUI(board, ai);
		jframe.add(gui);
		jframe.setSize(800, 800);
		jframe.setVisible(true);
	}

}
