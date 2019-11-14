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
		ImageIcon blockImage11 = null;

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
			blockImage11 = new ImageIcon(ImageIO.read(ResourceLoader.load("images/tutorial/stalemateTutorial.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String blockText1 = "Chess is a two-player strategy board game where each player has several different pieces with unique movement capabilities.";
		String blockText2 = "Each player has 8 pawns. If it is the Pawn's first time moving, it can move one or two spaces forward, otherwise only one. " +
				"The pawn can only take pieces diagonal to it. " +
				"It is also the only piece that cannot move backwards. " +
				"If the pawn reaches the other side of the board, it can be promoted to a rook, bishop, knight, or queen. " +
				"(Most people choose the Queen)";
		String blockText3 = "Each player has 2 rooks. These can move horizontal and vertical however many spaces as long as other pieces don't block its path.";
		String blockText4 = "Each player has 2 knights. These have unique movement patters where they move in 'L' shapes and can hop over other pieces.";
		String blockText5 = "Each player has 2 bishops. These can move diagonal however many spaces as long as other pieces don't block its path.";
		String blockText6 = "Each player has 1 queen. This is a mix between the rook and the bishop so it can move however many spaces horizontally, vertically, or diagonally.";
		String blockText7 = "Lastly, each player has 1 king. This piece is what a game ending depends on. It can move only one space in any direction.";
		String blockText8 = "To start, whoever is playing as white gets to move first and the game alternates between player turns until one player's King is in 'checkmate' or there is a 'stalemate'.";
		String blockText9 = "Checkmate occurs when a player cannot make any moves that would save their king from being taken by an opponent's piece. When this occurs, the player in checkmate loses. " +
				"As you can see, the black king is in checkmate because no move can be made that will put the king in a safe position.";
		String blockText10 = "A player's king cannot be in a position where it can be taken by their opponent's piece. " +
				"If an opponent's piece is in a place where it can take the player's king, the player must make a move that takes the king out of this state called 'check'. " +
				"Lastly, a player cannot make a move that will put their king in check. " +
				"Notice how the white king has limited move options because it cannot move into check.";
		String blockText11 = "Be wary of stalemates, if a player's king is not in check but they cannot make any moves without moving into check, the game ends in a stalemate. " +
				"Notice how the white king is not in the movement path of the black pieces but it cannot make any moves because it would be in check. " +
				"This is a stalemate so neither player wins. ";

		blocks = new TutorialBlock[11];
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
		blocks[10] = new TutorialBlock(blockImage11, blockText11);

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
