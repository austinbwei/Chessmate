package GUI;

import AI.AIPlayer;
import Game.Board;
import Game.Game;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	private Board board;
	private AIPlayer ai;
	private Game game;

	public MainFrame (String title, Game game, Board board, AIPlayer ai) {
		super(title);
		this.game = game;
		this.board = board;
		this.ai = ai;

		setLayout(new BorderLayout());
		Container container = getContentPane();

		BoardPanel boardPanel = new BoardPanel(board, ai, game);
		SidePanel sidePanel = new SidePanel(board, ai.color);
		container.add(boardPanel, BorderLayout.WEST);
		container.add(sidePanel, BorderLayout.EAST);
	}

}
