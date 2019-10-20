package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {

	private MainFrame mainFrame;
	private int width;
	private int height;
	private GridBagConstraints gbc;
	private JTextPane title;
	private JButton startGame;
	private JButton learnStrats;
	private JButton phaseSuggestion;

	public MainMenuPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;

		Dimension size = getPreferredSize();
		size.width = 740;
		size.height = 570;
		this.setPreferredSize(size);
		this.width = (int) size.getWidth();
		this.height = (int) size.getHeight();
		title = new JTextPane();
		startGame = new JButton("Start Game");
		learnStrats = new JButton("Learn Strategies");
		phaseSuggestion = new JButton("Phase Suggestion");
		setBackground(Color.WHITE);

		title.setText("Chess");
		Font font = new Font(Font.SANS_SERIF, 2, 30);
		title.setFont(font);
		title.setEditable(false);

		startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//mainFrame.startPreliminaryAssessment();
				mainFrame.startGame();
			}
		});

		learnStrats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.startStrategy();
			}
		});

		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		add(title, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		add(startGame, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		add(learnStrats, gbc);

	}

	public void addPhaseSuggestion(int phase) {
		System.out.println("Called");

		phaseSuggestion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.startPhasedGame(phase);
			}
		});

		gbc.gridx = 0;
		gbc.gridy = 3;
		add(phaseSuggestion, gbc);
		repaint();

	}

}
