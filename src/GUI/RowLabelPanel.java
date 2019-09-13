package GUI;

import javax.swing.*;
import java.awt.*;

public class RowLabelPanel extends JPanel {

	private int width;
	private int height;

	public RowLabelPanel() {
		Dimension size = getPreferredSize();
		size.width = 40;
		size.height = 535;
		this.setPreferredSize(size);
		this.width = (int) size.getWidth();
		this.height = (int) size.getHeight();
		setBackground(Color.WHITE);

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		JTextPane a = new JTextPane();
		JTextPane b = new JTextPane();
		JTextPane c = new JTextPane();
		JTextPane d = new JTextPane();
		JTextPane e = new JTextPane();
		JTextPane f = new JTextPane();
		JTextPane g = new JTextPane();
		JTextPane h = new JTextPane();

		a.setText("1");
		b.setText("2");
		c.setText("3");
		d.setText("4");
		e.setText("5");
		f.setText("6");
		g.setText("7");
		h.setText("8");

		a.setEditable(false);
		b.setEditable(false);
		c.setEditable(false);
		d.setEditable(false);
		e.setEditable(false);
		f.setEditable(false);
		g.setEditable(false);
		h.setEditable(false);

		gbc.weighty = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(a, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		add(b, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		add(c, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		add(d, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		add(e, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		add(f, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		add(g, gbc);

		gbc.gridx = 0;
		gbc.gridy = 7;
		add(h, gbc);
	}

}
