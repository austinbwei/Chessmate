package GUI;

import AI.AIPlayer;
import Game.Board;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidePanel extends JPanel {

	private AIPlayer aiHelper;
	private int width;
	private int height;
	private final JButton helpButton = new JButton("Request Move");
	private JTextArea helpField = new JTextArea();
	private JTextArea updateField = new JTextArea();
	private final JButton menuButton = new JButton("Main Menu");

	public SidePanel(MainFrame mainFrame, Board board, boolean aiColor) {
		aiHelper = new AIPlayer(board, !aiColor, 3);

		Dimension size = getPreferredSize();
		size.width = 186;
		size.height = 700;
		this.setPreferredSize(size);
		this.width = (int) size.getWidth();
		this.height = (int) size.getHeight();

		setBorder(BorderFactory.createTitledBorder("Menu"));
		setBackground(Color.WHITE);

		helpField.setEditable(false);
		updateField.setEditable(false);

		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				helpField.setText("Processing...\n");

				new SwingWorker() {
					@Override
					protected Object doInBackground() throws Exception {
						String recommendedMove = aiHelper.suggestMove().toString(board);
						helpField.setText(recommendedMove);
						return null;
					}
				}.execute();
			}
		});

		menuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.startMainMenu();
			}
		});

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(helpButton, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		add(helpField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		add(updateField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		add(menuButton, gbc);
	}

	public void addCheckIndicator(boolean color) {
		if (color) {
			updateField.setText("White in check!");
		} else {
			updateField.setText("Black in check!");
		}
	}

	public void addCheckmateIndicator(boolean color) {
		if (color) {
			updateField.setText("White is checkmated! \nPress the main menu button.");
		} else {
			updateField.setText("Black is checkmated! \nPress the main menu button.");
		}
	}

	public void resetField() {
		updateField.setText(" ");
	}

}
