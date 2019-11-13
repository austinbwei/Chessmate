package GUI;

import AI.AIPlayer;
import Game.Board;
import Game.Move;
import javax.swing.*;
import java.awt.*;

public class MoveCircle extends JComponent {

	private int x;
	private int y;
	private int squareWidth;
	private int squareHeight;
	private int value;

	MoveCircle(AIPlayer ai, Board board, Move move, int x, int y, int squareWidth, int squareHeight) {
		this.x = x + 15;
		this.y = y + 15;
		this.squareWidth = squareWidth / 2;
		this.squareHeight = squareHeight / 2;
		this.setBounds(new Rectangle(x, y, squareWidth, squareHeight));
		setPreferredSize(new Dimension(squareWidth, squareHeight));

		value = ai.rateMove(board, move);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.CYAN);
		g.fillOval(x, y, squareWidth, squareHeight);

		FontMetrics fm = g.getFontMetrics();
		double textWidth = fm.getStringBounds(String.valueOf(value), g).getWidth();
		g.setColor(Color.BLACK);
		g.drawString(String.valueOf(value), (int) (x - textWidth + 26),
				(int) (y + fm.getMaxAscent() + 7));
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
