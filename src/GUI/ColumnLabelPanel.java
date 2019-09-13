package GUI;

import javax.swing.*;
import java.awt.*;

public class ColumnLabelPanel extends JPanel {

	private int width;
	private int height;

	public ColumnLabelPanel() {
		Dimension size = getPreferredSize();
		size.width = 20;
		size.height = 35;
		this.setPreferredSize(size);
		this.width = (int) size.getWidth();
		this.height = (int) size.getHeight();
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		JTextPane i = new JTextPane();
		JTextPane a = new JTextPane();
		JTextPane b = new JTextPane();
		JTextPane c = new JTextPane();
		JTextPane d = new JTextPane();
		JTextPane e = new JTextPane();
		JTextPane f = new JTextPane();
		JTextPane g = new JTextPane();
		JTextPane h = new JTextPane();

		a.setText("a");
		b.setText("b");
		c.setText("c");
		d.setText("d");
		e.setText("e");
		f.setText("f");
		g.setText("g");
		h.setText("h");

		i.setEditable(false);
		a.setEditable(false);
		b.setEditable(false);
		c.setEditable(false);
		d.setEditable(false);
		e.setEditable(false);
		f.setEditable(false);
		g.setEditable(false);
		h.setEditable(false);

		gbc.weightx = 0.6;
		gbc.weighty = 0.6;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(i, gbc);

		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(a, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		add(b, gbc);

		gbc.gridx = 3;
		gbc.gridy = 0;
		add(c, gbc);

		gbc.gridx = 4;
		gbc.gridy = 0;
		add(d, gbc);

		gbc.gridx = 5;
		gbc.gridy = 0;
		add(e, gbc);

		gbc.gridx = 6;
		gbc.gridy = 0;
		add(f, gbc);

		gbc.gridx = 7;
		gbc.gridy = 0;
		add(g, gbc);

		gbc.gridx = 8;
		gbc.gridy = 0;
		add(h, gbc);
	}

}
