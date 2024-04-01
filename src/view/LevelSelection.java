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

public class LevelSelection extends JFrame implements ActionListener {

    JButton easyButton = new JButton("Easy");
    JButton mediumButton = new JButton("Medium");
    JButton hardButton = new JButton("Hard");

    public LevelSelection() {
        initComponents();
    }

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

    public static void main(String[] args) {
        new LevelSelection().setVisible(true);
    }

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
