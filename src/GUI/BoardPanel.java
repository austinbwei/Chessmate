package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import AI.AIPlayer;
import Game.Board;
import Game.Move;
import Game.Game;
import Pieces.*;
import java.util.ArrayList;

public class BoardPanel extends JPanel implements MouseListener {
	private static int originMouseX;
	private static int originMouseY;
	private static int destMouseX;
	private static int destMouseY;

	private Board board;
	private AIPlayer ai;
	private Game game;
	private SidePanel sidePanel;
	private int width;
	private int height;
	private int squareWidth;
	private int squareHeight;
	private Move aiMove;
	private int turn;
	private boolean normalGame;

	public BoardPanel(Board board, AIPlayer ai, Game game, SidePanel sidePanel, boolean normalGame) {
		this.board = board;
		this.ai = ai;
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
		turn = 0;
		this.normalGame = normalGame;
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

		Image chessPiece;

		for (int i = 0; i < 64; i++) {
			switch (board.getTile(i / 8, i % 8).toString()) {
				case "P":
					chessPiece = new ImageIcon("images/pieces/wPawn.png").getImage();
					g.drawImage(chessPiece, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "p":
					chessPiece = new ImageIcon("images/pieces/bPawn.png").getImage();
					g.drawImage(chessPiece, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "R":
					chessPiece = new ImageIcon("images/pieces/wRook.png").getImage();
					g.drawImage(chessPiece, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "r":
					chessPiece = new ImageIcon("images/pieces/bRook.png").getImage();
					g.drawImage(chessPiece, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "N":
					chessPiece = new ImageIcon("images/pieces/wKnight.png").getImage();
					g.drawImage(chessPiece, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "n":
					chessPiece = new ImageIcon("images/pieces/bKnight.png").getImage();
					g.drawImage(chessPiece, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "B":
					chessPiece = new ImageIcon("images/pieces/wBishop.png").getImage();
					g.drawImage(chessPiece, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "b":
					chessPiece = new ImageIcon("images/pieces/bBishop.png").getImage();
					g.drawImage(chessPiece, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "Q":
					chessPiece = new ImageIcon("images/pieces/wQueen.png").getImage();
					g.drawImage(chessPiece, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "q":
					chessPiece = new ImageIcon("images/pieces/bQueen.png").getImage();
					g.drawImage(chessPiece, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "K":
					chessPiece = new ImageIcon("images/pieces/wKing.png").getImage();
					g.drawImage(chessPiece, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
				case "k":
					chessPiece = new ImageIcon("images/pieces/bKing.png").getImage();
					g.drawImage(chessPiece, (i % 8) * squareWidth, (i / 8) * squareHeight, squareWidth, squareHeight, this);
					break;
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getX() < 8 * squareWidth && e.getY() < 8 * squareHeight) {
			originMouseX = e.getX();
			originMouseY = e.getY();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getX() < 8 * squareWidth && e.getY() < 8 * squareHeight) {
			destMouseX = e.getX();
			destMouseY = e.getY();

			if (e.getButton() == MouseEvent.BUTTON1) {
				Move move;

				move = new Move(originMouseY / squareHeight, originMouseX / squareWidth,
						destMouseY / squareHeight, destMouseX / squareWidth);

				ArrayList<Move> possibleMoves = board.getMoves(Piece.WHITE);

					for (int i = 0; i < possibleMoves.size(); i++) {
						if (possibleMoves.get(i).equals(move)) {
							if (game.getAIMoved()) {
								board.makeMove(move);
								repaint();
								turn++;
								sidePanelCommunicator();

								if (board.isInCheckmate(false)) {
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

				if (game.getPlayerMoved() && !board.isInCheckmate(false)) {
					ai.makeMove();
					repaint();
					turn++;
					sidePanelCommunicator();
					game.setPlayerMovedMoved(false);
					game.setAIMoved(true);
					System.out.println(board);
				} else if (board.isInCheckmate(false)) {
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

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
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
