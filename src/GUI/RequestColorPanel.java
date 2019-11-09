package GUI;

import AI.AIPlayer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestColorPanel extends JPanel {

	private int width;
	private int height;
	private GridBagConstraints gbc;
	private JTextPane requestText;
	private JButton black;
	private JButton white;

	public RequestColorPanel(MainFrame mainFrame, AIPlayer ai) {
		Dimension size = getPreferredSize();
		size.width = 740;
		size.height = 570;
		this.setPreferredSize(size);
		this.width = (int) size.getWidth();
		this.height = (int) size.getHeight();
		requestText = new JTextPane();
		black = new JButton("Black");
		white = new JButton("White");
		setBackground(Color.WHITE);

		requestText.setText("Play as Black or White?");
		Font font = new Font(Font.SERIF, 1, 36);
		requestText.setFont(font);
		requestText.setEditable(false);

		black.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ai.setColor(true);
				mainFrame.startNormalGame();
			}
		});

		white.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ai.setColor(false);
				mainFrame.startNormalGame();
			}
		});

		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		add(requestText, gbc);

		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		add(black, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		add(white, gbc);
	}

}
