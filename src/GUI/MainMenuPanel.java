package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {

	private MainFrame mainFrame;
	private int width;
	private int height;
	private JTextPane title;
	private JButton startGame;

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
		setBackground(Color.WHITE);

		title.setText("Chess");
		Font font = new Font(Font.SANS_SERIF, 2, 30);
		title.setFont(font);
		title.setEditable(false);

		startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.startPreliminaryAssessment();
			}
		});

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		add(title, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		add(startGame, gbc);

	}

}
