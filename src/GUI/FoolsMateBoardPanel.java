package GUI;

import java.awt.*;
import java.awt.event.*;
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
