package GUI;

import AI.AIPlayer;
import Game.Board;
import Game.Game;
import Game.Tile;
import Pieces.*;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

	private boolean firstGame;
	private int depth;
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
	private StrategyMenuPanel strategyMenuPanel;
	private FoolsMateInstPanel foolsMateInstPanel;
	private ProgramTutorialPanel programTutorialPanel;
	private ChessTutorialPanel chessTutorialPanel;
	private RequestColorPanel requestColorPanel;
	private JPanel gamePanel;

	public MainFrame (String title, Game game) {
		super(title);
		this.game = game;
		container = getContentPane();

		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

		firstGame = true;
		depth = 2;
		mainMenuPanel = new MainMenuPanel(this);
		startMainMenu();
	}

	public void startMainMenu() {
		container.removeAll();
		container.add(mainMenuPanel);
		setVisible(true);
		repaint();
	}

	public void startGame() {
		board = new Board();
		ai = new AIPlayer(board, false, depth);

		if (firstGame) {
			startPreliminaryAssessment();
		} else {
			requestColor();
		}
	}

	private void startPreliminaryAssessment() {
		assessmentPanel = new AssessmentPanel(this, ai);

		container.removeAll();
		container.add(assessmentPanel);
		setVisible(true);
		repaint();
	}

	public void requestColor() {
		requestColorPanel = new RequestColorPanel(this, ai);

		container.removeAll();
		container.add(requestColorPanel);
		setVisible(true);
		repaint();
	}

	public void startNormalGame() {
		System.out.println(board);

		sidePanel = new SidePanel(this, board, ai.getColor());
		boardPanel = new BoardPanel(board, ai, game, sidePanel, true);
		columnLabelPanel = new ColumnLabelPanel();
		rowLabelPanel = new RowLabelPanel();

		gamePanel = new JPanel();
		gamePanel.setLayout(new BorderLayout());
		gamePanel.add(columnLabelPanel, BorderLayout.PAGE_START);
		gamePanel.add(rowLabelPanel, BorderLayout.LINE_START);
		gamePanel.add(boardPanel,BorderLayout.CENTER);

		container.removeAll();
		container.add(gamePanel, BorderLayout.WEST);
		container.add(sidePanel, BorderLayout.EAST);

		setVisible(true);
		repaint();

		firstGame = false;
	}

	public void startPhasedGame(int phase) {
		if (phase == 0) {
			board = new Board();
		} else if (phase == 1) {
			board = getMidBoard();
		} else {
			board = getLateBoard();
		}

		ai = new AIPlayer(board, false, depth);

		System.out.println(board);

		sidePanel = new SidePanel(this, board, ai.aiColor);
		boardPanel = new BoardPanel(board, ai, game, sidePanel, false);
		columnLabelPanel = new ColumnLabelPanel();
		rowLabelPanel = new RowLabelPanel();

		gamePanel = new JPanel();
		gamePanel.setLayout(new BorderLayout());
		gamePanel.add(columnLabelPanel, BorderLayout.PAGE_START);
		gamePanel.add(rowLabelPanel, BorderLayout.LINE_START);
		gamePanel.add(boardPanel,BorderLayout.CENTER);

		container.removeAll();
		container.add(gamePanel, BorderLayout.WEST);
		container.add(sidePanel, BorderLayout.EAST);

		setVisible(true);
		repaint();
	}

	public void startStrategy() {
		strategyMenuPanel = new StrategyMenuPanel(this);

		container.removeAll();
		container.add(strategyMenuPanel);
		setVisible(true);
		repaint();
	}

	public void startFoolsMateInstructions() {
		foolsMateInstPanel = new FoolsMateInstPanel(this);

		container.removeAll();
		container.add(foolsMateInstPanel);
		setVisible(true);
		repaint();
	}

	public void startProgramTutorial() {
		programTutorialPanel = new ProgramTutorialPanel(this);

		container.removeAll();
		container.add(programTutorialPanel);
		setVisible(true);
		repaint();
	}

	public void startChessTutorial() {
		chessTutorialPanel = new ChessTutorialPanel(this);

		container.removeAll();
		container.add(chessTutorialPanel);
		setVisible(true);
		repaint();
	}

	public void addPhaseSuggestion(int phase) {
		mainMenuPanel.addPhaseSuggestion(phase);
	}

	public void setAIDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * Generate a board in mid game
	 * @return board in mid game
	 */
	private Board getMidBoard() {
		Tile[][] tiles = new Tile[8][8];
		int random = (int) (Math.random() * 3);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				tiles[i][j] = new Tile();
			}
		}

		switch(random) {
			case 0:
				tiles[0][0] = new Tile(new Rook(false));
				tiles[0][4] = new Tile(new King(false));
				tiles[0][5] = new Tile(new Bishop(false));
				tiles[0][6] = new Tile(new Rook(false));
				tiles[1][0] = new Tile(new Pawn(false));
				tiles[1][1] = new Tile(new Pawn(false));
				tiles[1][3] = new Tile(new Bishop(false));
				tiles[1][6] = new Tile(new Pawn(false));
				tiles[2][2] = new Tile(new Knight(false));
				tiles[2][3] = new Tile(new Queen(false));
				tiles[2][5] = new Tile(new Pawn(false));
				tiles[3][4] = new Tile(new Pawn(false));

				tiles[3][3] = new Tile(new Knight(true));
				tiles[4][2] = new Tile(new Pawn(true));
				tiles[5][5] = new Tile(new Knight(true));
				tiles[6][0] = new Tile(new Pawn(true));
				tiles[6][1] = new Tile(new Pawn(true));
				tiles[6][3] = new Tile(new Pawn(true));
				tiles[6][5] = new Tile(new Pawn(true));
				tiles[6][6] = new Tile(new Pawn(true));
				tiles[6][7] = new Tile(new Pawn(true));
				tiles[7][0] = new Tile(new Rook(true));
				tiles[7][2] = new Tile(new Bishop(true));
				tiles[7][3] = new Tile(new Queen(true));
				tiles[7][4] = new Tile(new Rook(true));
				tiles[7][6] = new Tile(new King(true));
				break;
			case 1:
				tiles[0][7] = new Tile(new Rook(false));
				tiles[1][0] = new Tile(new Pawn(false));
				tiles[1][4] = new Tile(new Knight(false));
				tiles[1][7] = new Tile(new Pawn(false));
				tiles[2][5] = new Tile(new Pawn(false));
				tiles[3][3] = new Tile(new King(false));
				tiles[3][4] = new Tile(new Pawn(false));
				tiles[3][6] = new Tile(new Pawn(false));
				tiles[4][4] = new Tile(new Pawn(false));

				tiles[1][1] = new Tile(new Knight(true));
				tiles[1][2] = new Tile(new Rook(true));
				tiles[2][1] = new Tile(new Bishop(true));
				tiles[3][1] = new Tile(new Bishop(true));
				tiles[6][0] = new Tile(new Pawn(true));
				tiles[6][1] = new Tile(new Pawn(true));
				tiles[6][3] = new Tile(new King(true));
				tiles[6][5] = new Tile(new Pawn(true));
				tiles[6][6] = new Tile(new Pawn(true));
				tiles[6][7] = new Tile(new Pawn(true));
				break;
			case 2:
				tiles[0][0] = new Tile(new Rook(false));
				tiles[0][2] = new Tile(new Bishop(false));
				tiles[0][3] = new Tile(new Rook(false));
				tiles[1][0] = new Tile(new Pawn(false));
				tiles[1][1] = new Tile(new Pawn(false));
				tiles[1][6] = new Tile(new Pawn(false));
				tiles[1][7] = new Tile(new Pawn(false));
				tiles[2][2] = new Tile(new Knight(false));
				tiles[2][3] = new Tile(new Queen(false));
				tiles[2][5] = new Tile(new Pawn(false));
				tiles[3][4] = new Tile(new Rook(false));

				tiles[3][3] = new Tile(new Knight(true));
				tiles[4][2] = new Tile(new Bishop(true));
				tiles[4][3] = new Tile(new Queen(true));
				tiles[5][5] = new Tile(new Knight(true));
				tiles[6][0] = new Tile(new Pawn(true));
				tiles[6][1] = new Tile(new Pawn(true));
				tiles[6][2] = new Tile(new Pawn(true));
				tiles[6][5] = new Tile(new Pawn(true));
				tiles[6][6] = new Tile(new Pawn(true));
				tiles[6][7] = new Tile(new Pawn(true));
				tiles[7][0] = new Tile(new Rook(true));
				tiles[7][3] = new Tile(new King(true));
				tiles[7][4] = new Tile(new Rook(true));
				break;
		}

		Board board = new Board(tiles);
		return board;
	}

	/**
	 * Generate a board in late game
	 * @return a board in late game
	 */
	private Board getLateBoard() {
		Tile[][] tiles = new Tile[8][8];
		int random = (int) (Math.random() * 3);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				tiles[i][j] = new Tile();
			}
		}

		switch(random) {
			case 0:
				tiles[0][0] = new Tile(new Rook(false));
				tiles[1][0] = new Tile(new Pawn(false));
				tiles[1][1] = new Tile(new Pawn(false));
				tiles[1][3] = new Tile(new Knight(false));
				tiles[1][4] = new Tile(new Knight(false));
				tiles[2][2] = new Tile(new Pawn(false));
				tiles[2][3] = new Tile(new King(false));
				tiles[3][3] = new Tile(new Pawn(false));

				tiles[4][3] = new Tile(new Pawn(true));
				tiles[4][6] = new Tile(new Pawn(true));
				tiles[4][7] = new Tile(new Pawn(true));
				tiles[5][2] = new Tile(new Knight(true));
				tiles[6][4] = new Tile(new Queen(true));
				tiles[7][5] = new Tile(new King(true));
				break;
			case 1:
				tiles[1][1] = new Tile(new Pawn(false));
				tiles[1][6] = new Tile(new Pawn(false));
				tiles[1][7] = new Tile(new Pawn(false));
				tiles[2][1] = new Tile(new Bishop(false));
				tiles[3][3] = new Tile(new King(false));

				tiles[3][1] = new Tile(new King(true));
				tiles[4][6] = new Tile(new Pawn(true));
				tiles[4][7] = new Tile(new Pawn(true));
				tiles[6][0] = new Tile(new Pawn(true));
				tiles[7][2] = new Tile(new Rook(true));
				break;
			case 2:
				tiles[0][0] = new Tile(new Rook(false));
				tiles[0][1] = new Tile(new Knight(false));
				tiles[0][3] = new Tile(new King(false));
				tiles[0][4] = new Tile(new Knight(false));
				tiles[0][5] = new Tile(new Bishop(false));
				tiles[0][6] = new Tile(new Rook(false));
				tiles[1][0] = new Tile(new Pawn(false));
				tiles[1][1] = new Tile(new Pawn(false));
				tiles[1][2] = new Tile(new Pawn(false));
				tiles[2][1] = new Tile(new Queen(false));
				tiles[3][3] = new Tile(new Pawn(false));
				tiles[4][0] = new Tile(new Bishop(false));

				tiles[1][7] = new Tile(new Rook(true));
				tiles[3][1] = new Tile(new Pawn(true));
				tiles[3][4] = new Tile(new Pawn(true));
				tiles[3][6] = new Tile(new Pawn(true));
				tiles[5][2] = new Tile(new Pawn(true));
				tiles[5][3] = new Tile(new Bishop(true));
				tiles[5][7] = new Tile(new Queen(true));
				tiles[6][3] = new Tile(new King(true));
				break;
		}

		Board board = new Board(tiles);
		return board;
	}

}
