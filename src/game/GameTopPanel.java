package game;

import utils.ImageBufferUtils;

import javax.swing.*;
import java.awt.*;

public class GameTopPanel extends JPanel {
    private JLabel time = new JLabel("5:00");
    private JLabel score = new JLabel("0");

    public GameTopPanel() {
        setPreferredSize(new Dimension(800, 100));
        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 30));

        ImageIcon timeIcon = ImageBufferUtils.getImageIcon(ImageBufferUtils.TIME);
        JLabel timeLabel = new JLabel(timeIcon);
        add(timeLabel);
        JLabel timeFont = new JLabel("Time");
        timeFont.setForeground(Color.RED);
        add(timeFont);

        JPanel timePanel = new JPanel();
        timePanel.setBackground(Color.WHITE);
        timePanel.setBorder(BorderFactory.createLineBorder(new Color(102,136,176),2));
        timePanel.setPreferredSize(new Dimension(100, 30));
        timePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        time.setFont(new Font("Arial", Font.BOLD, 20));
        timePanel.add(time);

        add(timePanel);

        JPanel space = new JPanel();
        space.setPreferredSize(new Dimension(260, 30));
        space.setBackground(Color.WHITE);
        add(space);


        ImageIcon scoreIcon = ImageBufferUtils.getImageIcon(ImageBufferUtils.SCORE);
        JLabel scoreLabel = new JLabel(scoreIcon);
        add(scoreLabel);
        JLabel scoreFont = new JLabel("Scores");
        scoreFont.setForeground(Color.RED);
        add(scoreFont);

        JPanel scorePanel = new JPanel();
        scorePanel.setBackground(Color.WHITE);
        scorePanel.setBorder(BorderFactory.createLineBorder(new Color(102,136,176),2));
        scorePanel.setPreferredSize(new Dimension(100, 30));
        scorePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        score.setFont(new Font("Arial", Font.BOLD, 20));
        score.setForeground(Color.GREEN);
        scorePanel.add(score);
        add(scorePanel);
    }

    public void setTime(String time) {
        this.time.setText(time);
    }

    public void setScore(int score) {
        this.score.setText(String.valueOf(score));
    }

}
