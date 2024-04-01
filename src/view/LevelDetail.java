package view;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import entity.User;
import game.GameSystem;
import utils.LocalStorage;
import view.custom.SettingPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Level Detail
 */
public class LevelDetail extends JFrame {
    private final int hardLevel;
    private int level = 1;

    private JButton[] buttons = new JButton[9];

    public LevelDetail(int hardLevel) {
        this.hardLevel = hardLevel;
        User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
        if (user != null) {
            if (hardLevel == 1) {
                level = user.getEasyLevel();
            } else if (hardLevel == 2) {
                level = user.getMediumLevel();
            } else {
                level = user.getHardLevel();
            }
        }
        initComponents();
    }

    private void initComponents() {
        setTitle("Level Detail");
        setSize(500, 600);

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
        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(Color.WHITE);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("Level " + (i + 1));
            buttons[i].setPreferredSize(new Dimension(100, 50));
            buttons[i].setBackground(Color.WHITE);
            if (i > level - 1){
                buttons[i].setBackground(new Color(204,204,204));
                buttons[i].addActionListener(e -> {
                    JOptionPane.showMessageDialog(null, "Level Locked");
                });
            }else {
                int finalI = i;
                buttons[i].addActionListener(e -> {
                    this.dispose();
                    new Thread(() -> {
                        new GameSystem(hardLevel, finalI + 1).startGame();
                    }).start();

                });
            }

            buttons[i].setBorder(BorderFactory.createLineBorder(Color.black, 2));

            JPanel tempPanel = new JPanel();
            tempPanel.setBackground(Color.WHITE);
            tempPanel.add(buttons[i]);
            buttonPanel.add(tempPanel);
        }


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
        new LevelDetail(1).setVisible(true);
    }
}
