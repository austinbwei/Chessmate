package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ChessTutorialPanel extends JPanel implements TutorialTeacherPanel {

	private int width;
	private int height;
	private int index;
	private TutorialHelperPanel helperPanel;
	private JLabel boardImage = new JLabel(new ImageIcon());
	private TutorialBlock[] blocks;

	public ChessTutorialPanel(MainFrame mainFrame) {
		Dimension size = getPreferredSize();
		size.width = 740;
		size.height = 570;
		this.setPreferredSize(size);
		this.width = (int) size.getWidth();
		this.height = (int) size.getHeight();
		setBackground(Color.WHITE);

		helperPanel = new TutorialHelperPanel(this, mainFrame);

		ImageIcon blockImage1 = null;
		ImageIcon blockImage2 = null;
		ImageIcon blockImage3 = null;
		ImageIcon blockImage4 = null;
		ImageIcon blockImage5 = null;
		ImageIcon blockImage6 = null;
		ImageIcon blockImage7 = null;
		ImageIcon blockImage8 = null;
		ImageIcon blockImage9 = null;
		ImageIcon blockImage10 = null;

		try {
			blockImage1 = new ImageIcon(ImageIO.read(ResourceLoader.load("images/tutorial/tutorialStart.PNG")));
			blockImage2 = new ImageIcon(ImageIO.read(ResourceLoader.load("images/tutorial/pawnTutorial.PNG")));
			blockImage3 = new ImageIcon(ImageIO.read(ResourceLoader.load("images/tutorial/rookTutorial.PNG")));
			blockImage4 = new ImageIcon(ImageIO.read(ResourceLoader.load("images/tutorial/knightTutorial.PNG")));
			blockImage5 = new ImageIcon(ImageIO.read(ResourceLoader.load("images/tutorial/bishopTutorial.PNG")));
			blockImage6 = new ImageIcon(ImageIO.read(ResourceLoader.load("images/tutorial/queenTutorial.PNG")));
			blockImage7 = new ImageIcon(ImageIO.read(ResourceLoader.load("images/tutorial/kingTutorial.PNG")));
			blockImage8 = new ImageIcon(ImageIO.read(ResourceLoader.load("images/tutorial/tutorialStart.PNG")));
			blockImage9 = new ImageIcon(ImageIO.read(ResourceLoader.load("images/tutorial/checkmateTutorial.PNG")));
			blockImage10 = new ImageIcon(ImageIO.read(ResourceLoader.load("images/tutorial/checkTutorial.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String blockText1 = "Chess is a two-player strategy board game where each player has several different pieces with unique movement capabilities.";
		String blockText2 = "Each player has 8 Pawns. If it is the Pawn's first time moving, it can move one or two spaces forward, otherwise only one. " +
				"The Pawn can only take pieces diagonal to it. If the pawn reaches the other side of the board, it can be promoted to a Rook, Bishop, Knight, or Queen. " +
				"Most people choose the Queen.";
		String blockText3 = "Each player has 2 Rooks. These can move horizontal and vertical however many spaces and in any direction.";
		String blockText4 = "Each player has 2 Knights. These have unique movement patters where they move in 'L' shapes, in any direction, and can hop over other pieces.";
		String blockText5 = "Each player has 2 Bishops. These can move diagonal however many spaces and in any direction.";
		String blockText6 = "Each player has 1 Queen. This is a mix between the Rook and the Bishop so it can move however many spaces in any direction whether it's horizontal, vertical, or diagonal.";
		String blockText7 = "Lastly, each player has 1 King. This piece is what a game ending depends on. It can move only one space in any direction whether it's horizontal, vertical, or diagonal.";
		String blockText8 = "To start, whoever is play as white gets to move first and the game alternates between player turns until one player's King is in checkmate.";
		String blockText9 = "Checkmate occurs when a player cannot make any moves that would save their King from being taken by an opponent's piece. When this occurs, the player in checkmate loses. " +
				"As you can see, the black King is in checkmate because no move can be made that will put the King in a safe position.";
		String blockText10 = "A player's King cannot be in a position where it can be taken by their opponent's piece. " +
				"If an opponent's piece is in a place where it can take the player's King, the player must make a move that takes the King out of this state, this state is called 'check'. " +
				"Lastly, a player cannot make a move that will put their King in check. " +
				"Notice how the white King has limited move options because it cannot move into check.";

		blocks = new TutorialBlock[10];
		blocks[0] = new TutorialBlock(blockImage1, blockText1);
		blocks[1] = new TutorialBlock(blockImage2, blockText2);
		blocks[2] = new TutorialBlock(blockImage3, blockText3);
		blocks[3] = new TutorialBlock(blockImage4, blockText4);
		blocks[4] = new TutorialBlock(blockImage5, blockText5);
		blocks[5] = new TutorialBlock(blockImage6, blockText6);
		blocks[6] = new TutorialBlock(blockImage7, blockText7);
		blocks[7] = new TutorialBlock(blockImage8, blockText8);
		blocks[8] = new TutorialBlock(blockImage9, blockText9);
		blocks[9] = new TutorialBlock(blockImage10, blockText10);

		setLayout(new BorderLayout());

		add(boardImage, BorderLayout.WEST);
		add(helperPanel, BorderLayout.EAST);

		startTutorial();
	}

	private void startTutorial() {
		index = 0;
		boardImage.setIcon(blocks[index].getImage());
		helperPanel.setTextBox(blocks[index].getText());
	}

	@Override
	public void prevStep() {
		index--;
		if (index >= 0) {
			boardImage.setIcon(blocks[index].getImage());
			helperPanel.setTextBox(blocks[index].getText());
		} else {
			index++;
			return;
		}
	}

	@Override
	public void nextStep() {
		index++;
		if (index <= blocks.length - 1) {
			boardImage.setIcon(blocks[index].getImage());
			helperPanel.setTextBox(blocks[index].getText());
		} else {
			index--;
			return;
		}
	}

	@Override
	public void startStrategyGame() {

	}

	@Override
	public boolean hasBoardTutorial() {
		return false;
	}
}
