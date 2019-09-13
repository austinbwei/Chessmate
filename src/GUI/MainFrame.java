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
		setBackground(Color.WHITE);
		Container container = getContentPane();

		ColumnLabelPanel columnLabelPanel = new ColumnLabelPanel();
		RowLabelPanel rowLabelPanel = new RowLabelPanel();
		BoardPanel boardPanel = new BoardPanel(board, ai, game);
		SidePanel sidePanel = new SidePanel(board, ai.color);

		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(new BorderLayout());
		gamePanel.add(columnLabelPanel, BorderLayout.PAGE_START);
		gamePanel.add(rowLabelPanel, BorderLayout.LINE_START);
		gamePanel.add(boardPanel,BorderLayout.CENTER);

		container.add(gamePanel, BorderLayout.WEST);
		container.add(sidePanel, BorderLayout.EAST);
	}

}
