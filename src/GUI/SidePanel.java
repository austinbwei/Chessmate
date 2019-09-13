package GUI;

import AI.AIPlayer;
import Game.Board;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SidePanel extends JPanel {

	private Board board;
	private String chessBoard;
	private Boolean aiColor;
	private AIPlayer ai;
	private int width;
	private int height;
	private final JButton helpButton = new JButton("Request Move");
	private final JTextArea helpField = new JTextArea();

	public SidePanel(Board board, boolean aiColor) {
		this.board = board;
		this.aiColor = aiColor;

		ai = new AIPlayer(board, !aiColor, 3);

		Dimension size = getPreferredSize();
		size.width = 186;
		size.height = 700;
		this.setPreferredSize(size);
		this.width = (int) size.getWidth();
		this.height = (int) size.getHeight();

		setBorder(BorderFactory.createTitledBorder("Help"));
		setBackground(Color.WHITE);

		helpField.setEditable(false);

		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				helpField.setText("Processing...\n");

				new SwingWorker() {
					@Override
					protected Object doInBackground() throws Exception {
						String recommendedMove = ai.suggestMove().toString(board);
						helpField.append(recommendedMove);
						return null;
					}
				}.execute();
			}
		});

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.anchor = GridBagConstraints.PAGE_END;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(helpButton, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		add(helpField, gbc);
	}

}
