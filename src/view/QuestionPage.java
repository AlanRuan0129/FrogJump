package view;

import entity.Leaf;
import entity.Question;
import entity.User;
import game.GameSystem;
import utils.LocalStorage;
import utils.MusicUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The {@code QuestionPage} class extends {@link JDialog} and implements {@link ActionListener}
 * to provide a UI for presenting questions to the user, accepting answers, and navigating
 * through questions in a quiz or game context. It displays the current question, a field for
 * the user to input their answer, and buttons to submit the answer or proceed to the next question.
 * Feedback on the user's answer is immediately displayed.
 * <p>
 * The dialog interacts with the {@link GameSystem} for game logic and scoring, and with
 * {@link Leaf} entities representing individual question items.
 * </p>
 * @author Jingpeng Ruan
 * @version 1.0
 * @since 2024/3/31
 */
public class QuestionPage extends JDialog implements ActionListener {
    private Leaf leaf;
    private Question question;
    private GameSystem gameSystem;
    JButton submitButton = new JButton("√ Submit");
    JLabel resultLabel = new JLabel("InCorrect!!!! No Chance!!!");
    JTextArea resultArea;
    JLabel chanceLabel;
    JButton goNextButton = new JButton("→ Go Next");
    JTextField inputField = new JTextField();

    /**
     * Constructs a {@code QuestionPage} dialog that sets up the UI components,
     * initializes game logic connections, and prepares the question for presentation.
     *
     * @param leaf The {@link Leaf} entity containing the current question and additional metadata.
     * @param gameSystem The {@link GameSystem} instance managing game state and logic.
     */
    public QuestionPage(Leaf leaf, GameSystem gameSystem) {
        submitButton.addActionListener(this);
        goNextButton.addActionListener(this);
        this.leaf = leaf;
        this.question = leaf.getQuestion();
        this.gameSystem = gameSystem;
        resultArea = new JTextArea(question.getSolution());
        chanceLabel = new JLabel("Remaining Chance: " + question.getChance());
        setTitle("Question");
        setSize(500, 600);


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(50, 50));
        panel.setBackground(Color.WHITE);

        JPanel questionPanel = new JPanel();
        questionPanel.setBackground(Color.WHITE);
        questionPanel.setPreferredSize(new Dimension(500, 100));

        JTextArea questionArea = new JTextArea(question.getQuestion());
        questionArea.setFont(new Font("Arial", Font.BOLD, 20));
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        questionArea.setEditable(false);
        questionArea.setBackground(Color.WHITE);
        questionArea.setPreferredSize(new Dimension(400, 70));
        questionArea.setBorder(BorderFactory.createLineBorder(new Color(111, 168, 220), 2));


        chanceLabel.setForeground(new Color(255, 153, 0));
        chanceLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        questionPanel.add(questionArea);
        questionPanel.add(chanceLabel);

        JPanel mainPanel = new JPanel();
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setPreferredSize(new Dimension(500, 50));

        JLabel inputLabel = new JLabel("Write your answer: ");
        inputLabel.setFont(new Font("Arial", Font.BOLD, 16));

        inputField.setPreferredSize(new Dimension(120, 30));
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        submitButton.setPreferredSize(new Dimension(100, 30));
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBackground(new Color(224, 102, 102));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));


        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        inputPanel.add(submitButton);


        JPanel resultPanel = new JPanel();
        resultPanel.setPreferredSize(new Dimension(500, 150));
        resultPanel.setBackground(Color.WHITE);


        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        resultLabel.setForeground(Color.RED);
        resultLabel.setVisible(false);

        goNextButton.setPreferredSize(new Dimension(100, 30));
        goNextButton.setFont(new Font("Arial", Font.BOLD, 16));
        goNextButton.setBackground(new Color(224, 102, 102));
        goNextButton.setForeground(Color.WHITE);
        goNextButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        goNextButton.setVisible(false);


        resultArea.setFont(new Font("Arial", Font.BOLD, 16));
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false);
        resultArea.setBackground(Color.WHITE);
        resultArea.setPreferredSize(new Dimension(400, 100));
        resultArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        resultArea.setForeground(new Color(111, 168, 220));
        resultArea.setVisible(false);

        resultPanel.add(resultLabel);
        resultPanel.add(goNextButton);
        resultPanel.add(resultArea);


        JTextArea hintArea = new JTextArea(Question.HIT);
        hintArea.setFont(new Font("Arial", Font.BOLD, 16));
        hintArea.setLineWrap(true);
        hintArea.setWrapStyleWord(true);
        hintArea.setEditable(false);
        hintArea.setBackground(Color.WHITE);
        hintArea.setPreferredSize(new Dimension(400, 120));
        hintArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        hintArea.setAlignmentX(JTextArea.CENTER_ALIGNMENT);

        mainPanel.add(inputPanel);
        mainPanel.add(resultPanel);
        mainPanel.add(hintArea);
        mainPanel.setBackground(Color.WHITE);

        panel.add(questionPanel, BorderLayout.NORTH);
        panel.add(mainPanel, BorderLayout.CENTER);
        add(panel);
        setLocationRelativeTo(null);
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                if (leaf.getStatus() == Leaf.Status.UNTOUCHED) {
                    leaf.setStatus(Leaf.Status.WRONG);
                    submitButton.setEnabled(false);
                }
            }
        });
    }


    /**
     * Handles action events triggered by the dialog's buttons, including submitting an
     * answer and moving to the next question. It also manages sound playback and updates
     * the game state based on the user's answer correctness.
     *
     * @param e The {@link ActionEvent} object containing details about the event.
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
        if (user.isSetSound()){
            MusicUtils.playSound("sound");
        }
        if (e.getSource() == submitButton) {
            if (Double.parseDouble(question.getAnswer())
                    == Double.parseDouble(inputField.getText())
            ) {
                resultLabel.setText("Correct!!!!");
                resultLabel.setVisible(true);
                chanceLabel.setText("Remaining Chance: " + question.getChance());
                goNextButton.setVisible(true);
                submitButton.setEnabled(false);
                leaf.setStatus(Leaf.Status.CORRECT);
                if (question.getChance() == 3){
                    gameSystem.increaseScore(10);
                }
                else if (question.getChance() == 2){
                    gameSystem.increaseScore(5);
                }
                else if (question.getChance() == 1){
                    gameSystem.increaseScore(3);
                }
            } else {
                resultLabel.setText("InCorrect!!!!");
                resultLabel.setVisible(true);
                question.reduceChance();
                chanceLabel.setText("Remaining Chance: " + question.getChance());
            }
            if (question.getChance() == 0) {
                resultLabel.setText("InCorrect!!!! No Chance!!!");
                resultLabel.setVisible(true);
                resultArea.setVisible(true);
                submitButton.setEnabled(false);
                leaf.setStatus(Leaf.Status.WRONG);

            }
        }else if(e.getSource() == goNextButton){
            this.dispose();
        }

    }
}
