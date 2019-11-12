package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import AI.AIPlayer;
import Game.Board;
import Game.Move;
import Game.Game;
import java.util.ArrayList;

public class BoardPanel extends JPanel implements MouseListener {
	private static int originMouseX;
	private static int originMouseY;
	private static int destMouseX;
	private static int destMouseY;

	private Board board;
	private AIPlayer ai;
	private boolean aiColor;
	private Game game;
	private SidePanel sidePanel;
	private int width;
	private int height;
	private int squareWidth;
	private int squareHeight;
	private int turn;
	private boolean normalGame;
	private ArrayList<MoveCircle> availableMoves;
	private boolean aiThinking = false;

	private Image wPawn = null;
	private Image bPawn = null;
	private Image wRook = null;
	private Image bRook = null;
	private Image wKnight = null;
	private Image bKnight = null;
	private Image wBishop = null;
	private Image bBishop = null;
	private Image wQueen = null;
	private Image bQueen = null;
	private Image wKing = null;
	private Image bKing = null;

	public BoardPanel(Board board, AIPlayer ai, Game game, SidePanel sidePanel, boolean normalGame) {
		this.board = board;
		this.ai = ai;
		this.aiColor = ai.getColor();
		this.game = game;
		this.sidePanel = sidePanel;

		Dimension size = getPreferredSize();
		size.width = 500;
		size.height = 500;
		this.setPreferredSize(size);
		this.width = (int) size.getWidth();
		this.height = (int) size.getHeight();
		this.squareWidth = width / 8;
		this.squareHeight = height / 8;
		this.addMouseListener(this);
		availableMoves = new ArrayList<>();

		try {
			wPawn = ImageIO.read(ResourceLoader.load("images/pieces/wPawn.png"));
			bPawn = ImageIO.read(ResourceLoader.load("images/pieces/bPawn.png"));
			wRook = ImageIO.read(ResourceLoader.load("images/pieces/wRook.png"));
			bRook = ImageIO.read(ResourceLoader.load("images/pieces/bRook.png"));
			wKnight = ImageIO.read(ResourceLoader.load("images/pieces/wKnight.png"));
			bKnight = ImageIO.read(ResourceLoader.load("images/pieces/bKnight.png"));
			wBishop = ImageIO.read(ResourceLoader.load("images/pieces/wBishop.png"));
			bBishop = ImageIO.read(ResourceLoader.load("images/pieces/bBishop.png"));
			wQueen = ImageIO.read(ResourceLoader.load("images/pieces/wQueen.png"));
			bQueen = ImageIO.read(ResourceLoader.load("images/pieces/bQueen.png"));
			wKing = ImageIO.read(ResourceLoader.load("images/pieces/wKing.png"));
			bKing = ImageIO.read(ResourceLoader.load("images/pieces/bKing.png"));
		} catch (IOException e) {
			e.printStackTrace();
		};

		turn = 0;
		this.normalGame = normalGame;

		if (aiColor) {
			aiThinking = true;
			game.setAIMoved(false);
			game.setPlayerMovedMoved(true);
			new SwingWorker() {
				@Override
				protected Object doInBackground() throws Exception {
					ai.makeMove();
					repaint();
					turn++;
					game.setPlayerMovedMoved(false);
					game.setAIMoved(true);
					aiThinking = false;
					System.out.println(board);
					return null;
				}
			}.execute();
			repaint();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 1) {
					g.setColor(new Color(85, 85, 85));
					g.fillRect(squareWidth * i, squareHeight * j, squareWidth, squareHeight);
				} else {
					g.setColor(new Color(170, 170, 170));
					g.fillRect(squareWidth * i, squareHeight * j, squareWidth, squareHeight);
				}
			}
		}

		// Draw piece images
		for (int i = 0; i < 64; i++) {
			switch (board.getTile(i / 8, i % 8).toString()) {
				case "P":
					g.drawImage(wPawn, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "p":
					g.drawImage(bPawn, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "R":
					g.drawImage(wRook, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "r":
					g.drawImage(bRook, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "N":
					g.drawImage(wKnight, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "n":
					g.drawImage(bKnight, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "B":
					g.drawImage(wBishop, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "b":
					g.drawImage(bBishop, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "Q":
					g.drawImage(wQueen, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "q":
					g.drawImage(bQueen, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "K":
					g.drawImage(wKing, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "k":
					g.drawImage(bKing, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
			}
		}

		// Draw piece's possible move circles
		if (availableMoves.size() != 0) {
			for (int i = 0; i < availableMoves.size(); i++) {
				availableMoves.get(i).paintComponent(g);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (!aiThinking && !board.isInCheckmate(aiColor) && !board.isInCheckmate(!aiColor)) {
			if (e.getX() < 8 * squareWidth && e.getY() < 8 * squareHeight) {
				originMouseX = e.getX();
				originMouseY = e.getY();

				// Check if user clicked one of their pieces
				if (board.getTile(originMouseY / squareHeight, originMouseX / squareWidth).getPiece() != null) {
					if (board.getTile(originMouseY / squareHeight, originMouseX / squareWidth).getPiece().getColor() != aiColor) {
						ArrayList<Move> possibleMoves = board.getMoves(!aiColor);

						// If that piece has any possible moves, show move circles
						for (int i = 0; i < possibleMoves.size(); i++) {
							if (originMouseY / squareHeight == possibleMoves.get(i).getRowOrigin() && originMouseX / squareWidth == possibleMoves.get(i).getColumnOrigin()) {
								int x = possibleMoves.get(i).getColumnDestination() * squareHeight;
								int y = possibleMoves.get(i).getRowDestination() * squareWidth;

								MoveCircle circle = new MoveCircle(x, y, squareWidth, squareHeight);
								availableMoves.add(circle);
							}
						}
						possibleMoves.clear();
						repaint();
					}
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (!aiThinking) {
			availableMoves.clear();
			repaint();

			if (e.getX() < 8 * squareWidth && e.getY() < 8 * squareHeight) {
				destMouseX = e.getX();
				destMouseY = e.getY();

				if (e.getButton() == MouseEvent.BUTTON1) {
					Move move = new Move(originMouseY / squareHeight, originMouseX / squareWidth,
							destMouseY / squareHeight, destMouseX / squareWidth);

					ArrayList<Move> possibleMoves = board.getMoves(!aiColor);

					for (int i = 0; i < possibleMoves.size(); i++) {
						if (possibleMoves.get(i).equals(move)) {
							if (game.getAIMoved() && !aiThinking) {
								board.makeMove(move);
								repaint();
								turn++;
								sidePanelCommunicator();

								if (board.isInCheckmate(false) || board.isInCheckmate(true)) {
									game.setAIMoved(true);
									game.setPlayerMovedMoved(true);
									if (normalGame) {
										game.addPhaseSuggestion(turn);
									}
									System.out.println(board);
								} else {
									game.setAIMoved(false);
									game.setPlayerMovedMoved(true);
									System.out.println(board);
								}
							}
						}
					}

					if (game.getPlayerMoved() && !board.isInCheckmate(false) && !board.isInCheckmate(true)) {
						new SwingWorker() {
							@Override
							protected Object doInBackground() throws Exception {
								aiThinking = true;
								ai.makeMove();
								repaint();
								turn++;
								sidePanelCommunicator();
								game.setPlayerMovedMoved(false);
								game.setAIMoved(true);
								aiThinking = false;
								System.out.println(board);
								return null;
							}
						}.execute();
						repaint();
					} else if (board.isInCheckmate(false) && board.isInCheckmate(true)) {
						sidePanelCommunicator();
						if (normalGame) {
							game.addPhaseSuggestion(turn);
						}
						game.setPlayerMovedMoved(true);
						game.setAIMoved(false);
						System.out.println(board);
					}
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {





	}


	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	private void sidePanelCommunicator() {
		if (board.isInCheckmate(true)) {
			System.out.println("Checkmate!");
			sidePanel.addCheckmateIndicator(true);
		} else if (board.isInCheckmate(false)) {
			System.out.println("Checkmate!");
			sidePanel.addCheckmateIndicator(false);
		} else if (board.isInCheck(true)) {
			System.out.println("Check!");
			sidePanel.addCheckIndicator(true);
		} else if (board.isInCheck(false)) {
			System.out.println("Check!");
			sidePanel.addCheckIndicator(false);
		} else {
			sidePanel.resetField();
		}
	}

}
