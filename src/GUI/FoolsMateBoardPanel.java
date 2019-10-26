package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Game.Board;
import Game.Move;

public class FoolsMateBoardPanel extends JPanel implements MouseListener {
	private static int originMouseX;
	private static int originMouseY;
	private static int destMouseX;
	private static int destMouseY;

	private FoolsMateInstPanel instructor;
	private Board board;
	private int width;
	private int height;
	private boolean myTurn;
	private boolean turn2;
	private int squareWidth;
	private int squareHeight;

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

	public FoolsMateBoardPanel(FoolsMateInstPanel instructor) {
		Dimension size = getPreferredSize();
		size.width = 500;
		size.height = 500;
		this.setPreferredSize(size);
		this.width = (int) size.getWidth();
		this.height = (int) size.getHeight();
		this.squareWidth = width / 8;
		this.squareHeight = height / 8;

		this.instructor = instructor;
		board = new Board();

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

		turn2 = false;
		whiteMove1();
		myTurn = true;

		this.addMouseListener(this);
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
				Move move = new Move(originMouseY / squareHeight, originMouseX / squareWidth,
						destMouseY / squareHeight, destMouseX / squareWidth);

				Move bMove1 = new Move(1, 4, 2, 4);
				Move bMove2 = new Move(0, 3, 4, 7);
				Move wMove2 = new Move(6, 6, 4, 6);

				if (!turn2) {
					if (bMove1.equals(move)) {
						if (myTurn) {
							board.makeMove(bMove1);
							revalidate();
							repaint();
							myTurn = false;
							board.makeMove(wMove2);
							revalidate();
							repaint();
							myTurn = true;
							turn2 = true;
							instructor.printInstructions2();
						}
					}
				} else {
					if (bMove2.equals(move)) {
						if (myTurn) {
							board.makeMove(bMove2);
							revalidate();
							repaint();
							myTurn = false;
							instructor.printfinalInstructions();
						}
					}
				}
			}
		}
	}

	private void whiteMove1() {
		Move move = new Move(6, 5, 4, 5);
		board.makeMove(move);
		instructor.printInstructions1();
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

}
