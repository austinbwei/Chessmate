package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StrategyMenuPanel extends JPanel {

	private int width;
	private int height;
	private JTextPane title;
	private JButton foolsMate;
	private MainFrame mainFrame;

	public StrategyMenuPanel(MainFrame mainFrame) {
		Dimension size = getPreferredSize();
		size.width = 740;
		size.height = 570;
		this.setPreferredSize(size);
		this.width = (int) size.getWidth();
		this.height = (int) size.getHeight();
		title = new JTextPane();
		foolsMate = new JButton("Fool's Mate");
		setBackground(Color.WHITE);

		title.setText("Strategies");
		Font font = new Font(Font.SANS_SERIF, 2, 30);
		title.setFont(font);
		title.setEditable(false);

		this.mainFrame = mainFrame;

		foolsMate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.startFoolsMateInstructions();
			}
		});

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		add(title, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		add(foolsMate, gbc);
	}

}
