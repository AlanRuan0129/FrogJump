package view;

import entity.User;
import utils.LocalStorage;
import utils.MusicUtils;
import view.custom.SettingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {
    JButton selectButton = new JButton("Select Level");
    JButton historyButton = new JButton("History View");
    JButton logoutButton = new JButton("Logout");
    public HomePage() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Home Page");
        setSize(500, 600);

        selectButton.addActionListener(this);
        historyButton.addActionListener(this);
        logoutButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(50,50));
        panel.setBackground(Color.WHITE);


        JPanel titlePanel = new JPanel();
        JLabel label = new JLabel("Happy Math Game!!!");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(new Color(21, 95, 155));
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(label);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 30, 30));
        buttonPanel.setBackground(Color.WHITE);

        selectButton.setPreferredSize(new Dimension(200, 50));
        historyButton.setPreferredSize(new Dimension(200, 50));
        logoutButton.setPreferredSize(new Dimension(200, 50));
        selectButton.setBackground(new Color(110, 167, 219));
        historyButton.setBackground(new Color(110, 167, 219));
        logoutButton.setBackground(Color.WHITE);
        selectButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        historyButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        logoutButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        JPanel selectPanel = new JPanel();
        selectPanel.setBackground(Color.WHITE);
        selectPanel.add(selectButton);

        JPanel historyPanel = new JPanel();
        historyPanel.setBackground(Color.WHITE);
        historyPanel.add(historyButton);

        JPanel logoutPanel = new JPanel();
        logoutPanel.setBackground(Color.WHITE);
        logoutPanel.add(logoutButton);


        buttonPanel.add(selectPanel);
        buttonPanel.add(historyPanel);
        buttonPanel.add(logoutPanel);

        JPanel settingPanel = new SettingPanel();

        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(titlePanel, BorderLayout.NORTH);
        panel.add(settingPanel, BorderLayout.SOUTH);

        add(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public static void main(String[] args) {
        HomePage homePage = new HomePage();
        homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homePage.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
        if (user.isSetSound()){
            MusicUtils.playSound("sound");
        }
        if (e.getSource() == selectButton) {
            new LevelSelection().setVisible(true);
            this.dispose();
        } else if (e.getSource() == historyButton) {
            new HistoryPage().setVisible(true);
            this.dispose();
        } else if (e.getSource() == logoutButton) {
            LocalStorage.save(LocalStorage.CURRENT_USER, null);
            new MainPage().setVisible(true);
            this.dispose();
        }

    }
}
