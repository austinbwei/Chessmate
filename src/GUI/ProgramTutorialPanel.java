package GUI;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramTutorialPanel extends JPanel {

	private int width;
	private int height;
	private JTextPane programInfo;
	private JButton mainMenu;

	public ProgramTutorialPanel(MainFrame mainFrame) {
		Dimension size = getPreferredSize();
		size.width = 740;
		size.height = 570;
		this.setPreferredSize(size);
		this.width = (int) size.getWidth();
		this.height = (int) size.getHeight();
		setBackground(Color.WHITE);
		programInfo = new JTextPane();
		mainMenu = new JButton("Main Menu");

		StyledDocument doc = programInfo.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		programInfo.setText("Chess Trainer is designed to help beginner chess players improve their gameplay through the assistance of artificial intelligence and other systems. " +
				"\nIf this is your first time playing chess or you need a refresher, select the chess tutorial option. " +
				"\nStarting a game will bring up a 5 question long preliminary assessment to gauge your skill level and adjust AI difficulty. " +
				"\nAfter this, you can play a normal game of chess and request move suggestions from the AI at any time in the game. " +
				"\nTo make a move, simply click on the piece you want to move, drag your cursor wherever the piece can move, and then release your mouse button. " +
				"\nWhen you click a piece you'll see all the move options available for that piece and how good the AI thinks it is. " +
				"\nPay attention to game updates given in the side panel to know when kings are in check/checkmate." +
				"\nWhen the game ends a new option called 'Phase Suggestion' will appear which will create a board scenario of a phase of the game the AI has gauged you may work on. " +
				"\nThe 'Learn Strategies' option provides a guided experience to learn popular strategies (Limited to Fool's Mate for now).");
		Font font = new Font(Font.DIALOG, 0, 16);
		programInfo.setFont(font);
		programInfo.setEditable(false);

		mainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.startMainMenu();
			}
		});

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(programInfo, gbc);

		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(mainMenu, gbc);
	}

}
