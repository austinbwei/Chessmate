package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerPanel extends JPanel {

	private int width;
	private int height;
	private final JTextPane instructions = new JTextPane();
	private final JTextPane originTag = new JTextPane();
	private final JTextPane destinationTag = new JTextPane();
	private JTextField originField = new JTextField();
	private JTextField destinationField = new JTextField();
	private final JButton submit = new JButton("Submit");

	public AnswerPanel(AssessmentPanel assessmentPanel) {
		Dimension size = getPreferredSize();
		size.width = 185;
		size.height = 650;
		this.setPreferredSize(size);
		this.width = (int) size.getWidth();
		this.height = (int) size.getHeight();
		setBackground(Color.WHITE);

		instructions.setText("Playing as white, enter what you think the best move to make is into the fields below. " +
				 "Enter in the format of 'a1' and 'h1'");
		instructions.setEditable(false);
		originTag.setText("Origin:");
		originTag.setEditable(false);
		destinationTag.setText("Destination:");
		destinationTag.setEditable(false);

		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				assessmentPanel.checkAnswer(originField.getText(), destinationField.getText());
				originField.setText("");
				destinationField.setText("");
			}
		});

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		//Instructions
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(instructions, gbc);

		//Origin
		gbc.weightx = 0;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(originTag, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(originField, gbc);

		//Destination
		gbc.weightx = 0;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(destinationTag, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(destinationField, gbc);

		//Submit
		gbc.weightx = 0;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(submit, gbc);

	}



}
