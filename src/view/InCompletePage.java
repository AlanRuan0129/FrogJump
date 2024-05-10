package view;

import entity.User;
import utils.ImageBufferUtils;
import utils.LocalStorage;
import utils.MusicUtils;
import view.custom.CenterLabelInPanel;
import view.custom.SettingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The {@code InCompletePage} class represents a GUI frame displayed upon failing to complete a level
 * in the game. It informs the player of their failure, displays their score, and offers options to
 * retry the level or return to the home page.
 *
 * This frame includes interactive buttons for navigation and optionally plays a sound effect based
 * on the user's settings for sound.
 *
 * @author Yujun Ma
 * @version 1.0
 * @since 2024/3/30
 */
public class InCompletePage extends JFrame implements ActionListener {
    JButton selectButton = new JButton("Level Selection");
    JButton homeButton = new JButton("Home Page");

    /**
     * Constructs a {@code InCompletePage} frame which initializes the UI components based on
     * the player's score, indicating a level failure.
     *
     * @param score The score obtained by the player in the failed level attempt.
     */
    public InCompletePage(int score) {
        initComponents(score);
    }

    /**
     * Initializes the components of the frame, setting up the layout, adding action listeners to
     * buttons, and displaying the player's score along with messages indicating failure and encouraging retry.
     *
     * @param score The player's score to display.
     */
    private void initComponents(int score) {
        selectButton.addActionListener(this);
        homeButton.addActionListener(this);

        setTitle("Incomplete Page");
        setSize(500, 600);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.WHITE);

        JPanel p1 = new CenterLabelInPanel("Time End", 16);

        JPanel p2 = new JPanel();
        ImageIcon icon = ImageBufferUtils.getImageIcon(ImageBufferUtils.CRY);
        JLabel iconLabel = new JLabel(icon);
        p2.add(iconLabel);
        p2.setPreferredSize(new Dimension(500, 130));
        p2.setBackground(Color.WHITE);

        JPanel p3 = new CenterLabelInPanel("Level Fail! ! !",16);
        JPanel p4 = new CenterLabelInPanel("You need to try again in level Page", 16);
        JPanel p5 = new CenterLabelInPanel("Score: "+score, 16);

        selectButton.setPreferredSize(new Dimension(200, 60));
        selectButton.setBackground(Color.WHITE);
        selectButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        JPanel p6 = new JPanel();
        selectButton.setFont(new Font("Arial", Font.BOLD, 16));
        p6.setPreferredSize(new Dimension(500, 90));
        p6.setBackground(Color.WHITE);
        p6.add(selectButton);

        homeButton.setPreferredSize(new Dimension(200, 60));
        homeButton.setBackground(Color.WHITE);
        homeButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        homeButton.setFont(new Font("Arial", Font.BOLD, 16));
        JPanel p7 = new JPanel();
        p7.setPreferredSize(new Dimension(500, 90));
        p7.setBackground(Color.WHITE);
        p7.add(homeButton);



        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        panel.add(p4);
        panel.add(p5);
        panel.add(p6);
        panel.add(p7);

        add(panel, BorderLayout.CENTER);
        add(new SettingPanel(), BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Handles action events triggered by the interactive elements in the frame, such as button clicks.
     * Depending on the source of the event, it navigates to either the level selection screen or
     * the home page and optionally plays a sound effect if the user has enabled sound effects.
     *
     * @param e The {@link ActionEvent} triggered by interacting with the frame's components.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
        if (user.isSetSound()){
            MusicUtils.playSound("sound");
        }
        if (e.getSource() == selectButton) {
            new LevelSelection().setVisible(true);
            this.dispose();
        } else if (e.getSource() == homeButton) {
            new HomePage().setVisible(true);
            this.dispose();
        }
    }
}
