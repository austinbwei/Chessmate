package GUI;

import javax.swing.*;

public class TutorialBlock {

	private ImageIcon image;
	private String text;

	public TutorialBlock(ImageIcon image, String text) {
		this.image = image;
		this.text = text;
	}

	public ImageIcon getImage() {
		return image;
	}

	public String getText() {
		return text;
	}
}
