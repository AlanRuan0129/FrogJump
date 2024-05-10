package view;

import entity.Question;
import entity.User;
import utils.LocalStorage;
import utils.MusicUtils;
import view.custom.SettingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The LevelSelection class implements an interface that allows the user to select the difficulty level of the game.
 * The interface contains three buttons representing "Easy", "Medium" and "hard" levels.
 * The user's choice will determine the difficulty level when launching the game.
 * <p>
 * This interface also processes the button click event, and opens the level details interface of the corresponding
 * difficulty according to the user's choice.
 * </p>
 *
 * @author Pengyuan Wei
 * @version 1.0
 * @since 2024/3/29
 */
public class LevelSelection extends JFrame implements ActionListener {

    JButton easyButton = new JButton("Easy");//Easy difficulty button
    JButton mediumButton = new JButton("Medium");//Medium difficulty button
    JButton hardButton = new JButton("Hard");//Hard difficulty button

    /**
     * Construct the LevelSelection window and initialize the component.
     */
    public LevelSelection() {
        initComponents();
    }

    /**
     * Initializes interface components and configures the layout and behavior of buttons and panels.
     */
    private void initComponents() {
        setTitle("Level Selection");
        setSize(500, 600);

        easyButton.addActionListener(this);
        mediumButton.addActionListener(this);
        hardButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(50,50));
        panel.setBackground(Color.WHITE);


        JPanel titlePanel = new JPanel();
        JLabel label = new JLabel("Choose Your Level");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(new Color(21, 95, 155));
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(label);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 30, 30));
        buttonPanel.setBackground(Color.WHITE);

        easyButton.setPreferredSize(new Dimension(200, 50));
        mediumButton.setPreferredSize(new Dimension(200, 50));
        hardButton.setPreferredSize(new Dimension(200, 50));
        easyButton.setBackground(Color.WHITE);
        mediumButton.setBackground(Color.WHITE);
        hardButton.setBackground(Color.WHITE);
        easyButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        mediumButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        hardButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        JPanel easyPanel = new JPanel();
        easyPanel.setBackground(Color.WHITE);
        easyPanel.add(easyButton);

        JPanel mediumPanel = new JPanel();
        mediumPanel.setBackground(Color.WHITE);
        mediumPanel.add(mediumButton);

        JPanel hardPanel = new JPanel();
        hardPanel.setBackground(Color.WHITE);
        hardPanel.add(hardButton);


        buttonPanel.add(easyPanel);
        buttonPanel.add(mediumPanel);
        buttonPanel.add(hardPanel);

        JPanel settingPanel = new SettingPanel("Home Page");

        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(titlePanel, BorderLayout.NORTH);
        panel.add(settingPanel, BorderLayout.SOUTH);

        add(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    /**
     * Main method, used to launch the interface.
     * @param args Command line parameter
     */
    public static void main(String[] args) {
        new LevelSelection().setVisible(true);
    }

    /**
     * Handle button click events. Click the button to open the LevelDetail interface for the corresponding difficulty level.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
        if (user.isSetSound()){
            MusicUtils.playSound("sound");
        }

        if (e.getSource() == easyButton) {
            new LevelDetail(1).setVisible(true);
            this.dispose();
        } else if (e.getSource() == mediumButton) {
            new LevelDetail(2).setVisible(true);
            this.dispose();
        } else if (e.getSource() == hardButton) {
            new LevelDetail(3).setVisible(true);
            this.dispose();
        }
    }
}
