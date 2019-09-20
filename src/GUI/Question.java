package GUI;

import javax.swing.*;

public class Question {

	private ImageIcon boardImage;
	private String[] origin;
	private String[] destination;

	public Question(ImageIcon boardImage, String[] origin, String[] destination) {
		this.boardImage = boardImage;
		this.origin = origin;
		this.destination = destination;
	}

	public ImageIcon getBoardImage() {
		return boardImage;
	}

	public String[] getOrigin() {
		return origin;
	}

	public String[] getDestination() {
		return destination;
	}

}
