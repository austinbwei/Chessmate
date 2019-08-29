package GUI;

import AI.AIPlayer;
import Game.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideBarGUI extends JPanel implements ActionListener {

	Board board;
	String chessBoard;
	AIPlayer ai;
	int width;
	int height;

	public SideBarGUI(Board board, AIPlayer ai, int width, int height) {
		this.board = board;
		this.ai = ai;
		this.width = width;
		this.height = height;

		chessBoard = this.board.toString();
		Dimension dimension = new Dimension(width, height);
		this.setPreferredSize(dimension);
		this.setBackground(Color.WHITE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
