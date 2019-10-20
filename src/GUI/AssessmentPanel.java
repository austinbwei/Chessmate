package GUI;

import AI.AIPlayer;

import javax.swing.*;
import java.awt.*;

public class AssessmentPanel extends JPanel {

	private int width;
	private int height;
	private AnswerPanel answerPanel;
	private MainFrame mainFrame;
	private AIPlayer aiPlayer;
	private int score;
	private int qIndex = 0;
	private Question[] questionBank;
	private JLabel boardImage = new JLabel(new ImageIcon());

	private final ImageIcon q1Image = new ImageIcon("images/questionImages/question1.png");
	private final String[] q1Origins = {"d2", "d2"};
	private final String[] q1Destinations = {"d1", "a2"};

	private final ImageIcon q2Image = new ImageIcon("images/questionImages/question2.png");
	private final String[] q2Origins = {"c7"};
	private final String[] q2Destinations = {"c5"};

	private final ImageIcon q3Image = new ImageIcon("images/questionImages/question3.png");
	private final String[] q3Origins = {"h6"};
	private final String[] q3Destinations = {"f7"};

	private final ImageIcon q4Image = new ImageIcon("images/questionImages/question4.png");
	private final String[] q4Origins = {"g7"};
	private final String[] q4Destinations = {"f8"};

	private final ImageIcon q5Image = new ImageIcon("images/questionImages/question5.png");
	private final String[] q5Origins = {"g8"};
	private final String[] q5Destinations = {"g1"};

	public AssessmentPanel(MainFrame mainFrame, AIPlayer aiPlayer) {
		Dimension size = getPreferredSize();
		size.width = 740;
		size.height = 570;
		this.setPreferredSize(size);
		this.width = (int) size.getWidth();
		this.height = (int) size.getHeight();
		this.mainFrame = mainFrame;
		this.aiPlayer = aiPlayer;
		setBackground(Color.WHITE);

		questionBank = new Question[5];
		questionBank[0] = new Question(q1Image, q1Origins, q1Destinations);
		questionBank[1] = new Question(q2Image, q2Origins, q2Destinations);
		questionBank[2] = new Question(q3Image, q3Origins, q3Destinations);
		questionBank[3] = new Question(q4Image, q4Origins, q4Destinations);
		questionBank[4] = new Question(q5Image, q5Origins, q5Destinations);

		answerPanel = new AnswerPanel(this);
		setLayout(new BorderLayout());

		add(boardImage, BorderLayout.WEST);
		add(answerPanel, BorderLayout.EAST);

		startTest();
	}

	private void startTest() {
		score = 0;
		boardImage.setIcon(questionBank[qIndex].getBoardImage());
	}

	/**
	 * Get next question image if there are more questions
	 */
	private void nextQuestion() {
		qIndex++;
		if (qIndex >= questionBank.length) {
			testComplete();
		} else {
			boardImage.setIcon(questionBank[qIndex].getBoardImage());
		}
	}

	/**
	 * Set AI depth and start the game
	 */
	private void testComplete() {
		if (score >= 4) {
			aiPlayer.setDepth(3);
			mainFrame.setAIDepth(3);
		} else if (score >= 2) {
			aiPlayer.setDepth(2);
			mainFrame.setAIDepth(2);
		} else {
			aiPlayer.setDepth(1);
			mainFrame.setAIDepth(1);
		}
		mainFrame.startNormalGame();
	}

	/**
	 * Check if user input matches question answer
	 * Increase score if there's a match
	 * @param origin input by user
	 * @param destination input by user
	 */
	public void checkAnswer(String origin, String destination) {
		String[] correctOrigin = questionBank[qIndex].getOrigin();
		String[] correctDestination = questionBank[qIndex].getDestination();

		for (int i = 0; i < correctOrigin.length; i++) {
			if (correctOrigin[i].equalsIgnoreCase(origin) && correctDestination[i].equalsIgnoreCase(destination)) {
				score++;
			}
		}
		nextQuestion();
	}

}
