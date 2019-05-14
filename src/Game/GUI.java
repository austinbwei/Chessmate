package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Pieces.*;
import java.util.ArrayList;

public class GUI extends JPanel implements MouseListener, MouseMotionListener  {

	Board board;
	String chessBoard;
    AIPlayer ai;

	public GUI (Board board, AIPlayer ai) {
		this.board = board;
        this.ai = ai;

		chessBoard = this.board.toString();
	}

    static int originMouseX;
    static int originMouseY;
    static int destMouseX;
    static int destMouseY;

    int squareWidth = this.getWidth()/8;
    int squareHeight = this.getHeight()/8;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.lightGray);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        int squareWidth = this.getWidth()/8;
        int squareHeight = this.getHeight()/8;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 1) {
                    g.setColor(new Color(100, 85, 70));
                    g.fillRect(squareWidth * i, squareHeight * j, squareWidth, squareHeight);
                }
            }
        }

        Image chessPieces;
        chessPieces = new ImageIcon("images/ChessPieces.png").getImage();

        for (int i = 0; i < 64; i++) {
            int j = -1;
            int k = -1;

            switch(board.getTile(i / 8,i % 8).toString()) {
                case "P":
                    j = 5;
                    k = 0;
                    break;
                case "p":
                    j = 5;
                    k = 1;
                    break;
                case "R":
                    j = 2;
                    k = 0;
                    break;
                case "r":
                    j = 2;
                    k = 1;
                    break;
                case "N":
                    j = 4;
                    k = 0;
                    break;
                case "n":
                    j = 4;
                    k = 1;
                    break;
                case "B":
                    j = 3;
                    k = 0;
                    break;
                case "b":
                    j = 3;
                    k = 1;
                    break;
                case "Q":
                    j = 1;
                    k = 0;
                    break;
                case "q":
                    j = 1;
                    k = 1;
                    break;
                case "K":
                    j = 0;
                    k = 0;
                    break;
                case "k":
                    j = 0;
                    k = 1;
                    break;
            }

            if (j != -1 && k != -1) {
                g.drawImage(chessPieces, (i % 8) * squareHeight, (i / 8) * squareWidth,
                        (i % 8 + 1) * squareWidth, (i / 8 + 1) * squareHeight,
                        j * 64, k * 64, (j + 1) * 64, (k + 1) * 64, this);
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int squareWidth = this.getWidth()/8;
        int squareHeight = this.getHeight()/8;

        if (e.getX() < 8 * squareWidth && e.getY() < 8 * squareHeight) {
            originMouseX = e.getX();
            originMouseY = e.getY();
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int squareWidth = this.getWidth()/8;
        int squareHeight = this.getHeight()/8;

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
                        board.makeMove(move);
                        repaint();
                        System.out.println(board);

                        ai.makeMove();
                        repaint();
                        System.out.println(board);
                    }
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
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

    @Override
    public void mouseDragged(MouseEvent e) {
    }

}
