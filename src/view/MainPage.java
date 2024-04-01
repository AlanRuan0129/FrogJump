package view;

import entity.User;
import utils.LocalStorage;
import utils.MusicUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the main page of the game. It has three buttons for new player, old player and instructor login.
 */
public class MainPage extends JFrame implements ActionListener {
    JButton newButton = new JButton("New Player");
    JButton oldButton = new JButton("Old Player");
    JButton instructionButton = new JButton("Instructor Login");
    public MainPage() {
        initComponents();
    }

    /**
     * This method initializes the components of the main page.
     */
    private void initComponents() {
        setTitle("Main Page");
        setSize(500, 600);


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(50,50));
        panel.setBackground(Color.WHITE);


        JPanel titlePanel = new JPanel();
        JLabel label = new JLabel("Welcome to Frog Jump Math Game");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(new Color(21, 95, 155));
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(label);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 30, 30));
        buttonPanel.setBackground(Color.WHITE);

        newButton.addActionListener(this);
        oldButton.addActionListener(this);
        instructionButton.addActionListener(this);


        newButton.setPreferredSize(new Dimension(200, 50));
        oldButton.setPreferredSize(new Dimension(200, 50));
        instructionButton.setPreferredSize(new Dimension(200, 50));
        newButton.setBackground(Color.WHITE);
        oldButton.setBackground(Color.WHITE);
        instructionButton.setBackground(Color.WHITE);
        newButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        oldButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        instructionButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        JPanel newPanel = new JPanel();
        newPanel.setBackground(Color.WHITE);
        newPanel.add(newButton);

        JPanel oldPanel = new JPanel();
        oldPanel.setBackground(Color.WHITE);
        oldPanel.add(oldButton);

        JPanel instructionPanel = new JPanel();
        instructionPanel.setBackground(Color.WHITE);
        instructionPanel.add(instructionButton);


        buttonPanel.add(newPanel);
        buttonPanel.add(oldPanel);
        buttonPanel.add(instructionPanel);


        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(titlePanel, BorderLayout.NORTH);

        add(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }

    /**
     * This method is called when the user clicks on the buttons.
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newButton) {
            new NewUserRegister().setVisible(true);
            this.dispose();
        } else if (e.getSource() == oldButton) {
            new OldUserLogin().setVisible(true);
            this.dispose();
        } else if (e.getSource() == instructionButton) {
            new InstructorLoginPage().setVisible(true);
            this.dispose();
        }
    }
}
