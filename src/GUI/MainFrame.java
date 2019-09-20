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
	private Container container;
	private MainMenuPanel mainMenuPanel;
	private BoardPanel boardPanel;
	private SidePanel sidePanel;
	private ColumnLabelPanel columnLabelPanel;
	private RowLabelPanel rowLabelPanel;
	private AssessmentPanel assessmentPanel;
	private JPanel gamePanel;

	public MainFrame (String title, Game game, Board board, AIPlayer ai) {
		super(title);
		this.game = game;
		this.board = board;
		this.ai = ai;
		container = getContentPane();
		mainMenuPanel = new MainMenuPanel(this);
		boardPanel = new BoardPanel(board, ai, game);
		sidePanel = new SidePanel(board, ai.color);
		columnLabelPanel = new ColumnLabelPanel();
		rowLabelPanel = new RowLabelPanel();
		assessmentPanel = new AssessmentPanel(this, ai);

		gamePanel = new JPanel();
		gamePanel.setLayout(new BorderLayout());
		gamePanel.add(columnLabelPanel, BorderLayout.PAGE_START);
		gamePanel.add(rowLabelPanel, BorderLayout.LINE_START);
		gamePanel.add(boardPanel,BorderLayout.CENTER);

		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

		startMainMenu();
	}

	private void startMainMenu() {
		container.removeAll();
		container.add(mainMenuPanel);
		setVisible(true);
	}

	public void startPreliminaryAssessment() {
		container.removeAll();
		container.add(assessmentPanel);
		setVisible(true);
	}

	public void startNormalGame() {
		container.removeAll();
		container.add(gamePanel, BorderLayout.WEST);
		container.add(sidePanel, BorderLayout.EAST);
		setVisible(true);
	}

}
