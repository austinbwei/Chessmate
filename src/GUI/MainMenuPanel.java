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
	private JButton programTutorial;
	private JButton chessTutorial;
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
		programTutorial = new JButton("Program Information");
		chessTutorial = new JButton("Chess Tutorial");
		phaseSuggestion = new JButton("Phase Suggestion");
		setBackground(Color.WHITE);

		title.setText("Chess Trainer");
		Font font = new Font(Font.SERIF, 1, 36);
		title.setFont(font);
		title.setEditable(false);

		startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.startGame();
			}
		});

		learnStrats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.startStrategy();
			}
		});

		programTutorial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.startProgramTutorial();
			}
		});

		chessTutorial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.startChessTutorial();
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

		gbc.gridx = 0;
		gbc.gridy = 3;
		add(chessTutorial, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		add(programTutorial, gbc);
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
		gbc.gridy = 5;
		add(phaseSuggestion, gbc);
		repaint();

	}

}
