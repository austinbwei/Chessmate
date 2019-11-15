package GUI;

import AI.AIPlayer;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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

	private ImageIcon q1Image = null;
	private final String[] q1Origins = {"d2", "d2"};
	private final String[] q1Destinations = {"d1", "a2"};

	private ImageIcon q2Image = null;
	private final String[] q2Origins = {"e8"};
	private final String[] q2Destinations = {"e2"};

	private ImageIcon q3Image = null;
	private final String[] q3Origins = {"h6"};
	private final String[] q3Destinations = {"f7"};

	private ImageIcon q4Image = null;
	private final String[] q4Origins = {"g7"};
	private final String[] q4Destinations = {"f8"};

	private ImageIcon q5Image = null;
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

		try {
			q1Image = new ImageIcon(ImageIO.read(ResourceLoader.load("images/questionImages/question1.PNG")));
			q2Image = new ImageIcon(ImageIO.read(ResourceLoader.load("images/questionImages/questionEvergreen.PNG")));
			q3Image = new ImageIcon(ImageIO.read(ResourceLoader.load("images/questionImages/question3.PNG")));
			q4Image = new ImageIcon(ImageIO.read(ResourceLoader.load("images/questionImages/question4.PNG")));
			q5Image = new ImageIcon(ImageIO.read(ResourceLoader.load("images/questionImages/question5.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}

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
		if (score >= 3) {
			aiPlayer.setDepth(3);
			mainFrame.setAIDepth(3);
		} else if (score >= 1) {
			aiPlayer.setDepth(2);
			mainFrame.setAIDepth(2);
		} else {
			aiPlayer.setDepth(1);
			mainFrame.setAIDepth(1);
		}
		mainFrame.requestColor();
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
