package Game;

import javax.swing.*;
import AI.AIPlayer;
import GUI.*;
import java.awt.*;

public class Game {

	boolean AIMoved;
	boolean playerMoved;

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

		AIPlayer ai = new AIPlayer(board, false,3);

		JFrame jframe = new JFrame("Chess");
		jframe.setSize(650, 600);
		jframe.setResizable(false);

		BoardGUI boardGUI = new BoardGUI(board, ai, this, 500, 500);
		SideBarGUI sidebarGUI = new SideBarGUI(board, ai, 150, 500);
		BottomBarGUI bottombarGUI = new BottomBarGUI(board, ai, 650, 100);

		jframe.getContentPane().setLayout(new BorderLayout());
		jframe.getContentPane().add(boardGUI, BorderLayout.WEST);
		jframe.getContentPane().add(sidebarGUI, BorderLayout.EAST);
		jframe.getContentPane().add(bottombarGUI, BorderLayout.SOUTH);

		jframe.setVisible(true);
		jframe.pack();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
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
