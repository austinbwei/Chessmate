package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MoveCircle extends JComponent {

	private Image image = null;
	private int x;
	private int y;
	private int squareWidth;
	private int squareHeight;

	MoveCircle(int x, int y, int squareWidth, int squareHeight) {
		this.x = x;
		this.y = y;
		this.squareWidth = squareWidth;
		this.squareHeight = squareHeight;

		try {
			image = ImageIO.read(ResourceLoader.load("images/misc/bluecircle.png"));
		} catch (IOException e) {
			e.printStackTrace();
		};
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x + 15, y + 15, squareWidth / 2, squareHeight / 2, this);
	}

}
