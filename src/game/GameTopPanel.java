package game;

import utils.ImageBufferUtils;

import javax.swing.*;
import java.awt.*;

/**
 * The {@code GameTopPanel} class extends {@link JPanel} and is designed to display the game's
 * top panel, including the time left and the current score. This panel is part of a game UI,
 * providing a visual representation of important game statistics to the player.
 * <p>
 * The panel includes:
 * <ul>
 *   <li>A time label displaying the remaining time with an icon.</li>
 *   <li>A score label showing the current score with an icon.</li>
 * </ul>
 * Both the time and score sections have their own dedicated areas within the panel, which
 * are visually distinguished by borders and background colors. The layout is arranged to
 * ensure clarity and immediate readability.
 * </p>
 * @author Jingpeng Ruan
 * @version 1.0
 * @since 2024/3/31
 */
public class GameTopPanel extends JPanel {
    /**
     * Label to display the remaining time in the game.
     */
    private JLabel time = new JLabel("5:00");
    /**
     * Label to display the current score in the game.
     */
    private JLabel score = new JLabel("0");
    /**
     * Constructs a new {@code GameTopPanel} initializing the UI components and setting up
     * the layout and initial display properties. This includes setting the preferred size
     * of the panel, its background color, and organizing the display of the time and score
     * labels along with their respective icons.
     */
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

    /**
     * Updates the displayed time on the panel.
     *
     * @param time A string representing the new time to be displayed. This is typically
     *             in the format "MM:SS", where MM is minutes and SS is seconds.
     */
    public void setTime(String time) {
        this.time.setText(time);
    }

    /**
     * Updates the displayed score on the panel.
     *
     * @param score An integer representing the new score to be displayed.
     */
    public void setScore(int score) {
        this.score.setText(String.valueOf(score));
    }

}
