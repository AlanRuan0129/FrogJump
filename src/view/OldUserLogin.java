package view;

import entity.User;
import model.UserModel;
import utils.LocalStorage;
import utils.MusicUtils;
import view.custom.SettingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OldUserLogin extends JFrame implements ActionListener {
    JButton loginButton = new JButton("Login");
    JButton backButton = new JButton("Main Page");
    JPasswordField passwordField = new JPasswordField(16);
    JTextField nameField = new JTextField(16);
    JLabel errorLabel = new JLabel(
            "User name/Password invalid, please try again");

    public OldUserLogin() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Old User Login");
        setSize(500, 600);

        errorLabel.setVisible(false);
        loginButton.addActionListener(this);
        backButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(30,30));
        panel.setBackground(Color.WHITE);


        JPanel titlePanel = new JPanel();
        JLabel label = new JLabel("Welcome Back!!!");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(new Color(21, 95, 155));
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(label);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 1, 30, 30));
        inputPanel.setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel("Enter a Name:              ");

        nameField.setPreferredSize(new Dimension(200, 40));
        JLabel passwordLabel = new JLabel("Enter your Password: ");

        passwordField.setPreferredSize(new Dimension(200, 40));


        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JPanel namePanel = new JPanel();
        namePanel.setBackground(Color.WHITE);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(Color.WHITE);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        errorLabel.setForeground(Color.RED);
        passwordPanel.add(errorLabel);


        loginButton.setPreferredSize(new Dimension(160, 40));
        loginButton.setBackground(Color.WHITE);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.WHITE);
        loginPanel.add(loginButton);


        backButton.setPreferredSize(new Dimension(160, 40));
        backButton.setBackground(Color.WHITE);
        backButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        JPanel backPanel = new JPanel();
        backPanel.setBackground(Color.WHITE);
        backPanel.add(backButton);

        inputPanel.add(namePanel);
        inputPanel.add(passwordPanel);
        inputPanel.add(loginPanel);
        inputPanel.add(backPanel);

        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(titlePanel, BorderLayout.NORTH);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        OldUserLogin newUserRegister = new OldUserLogin();
        newUserRegister.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            if (UserModel.login(nameField.getText(), new String(passwordField.getPassword()))) {
                new HomePage().setVisible(true);
                this.dispose();
            }else {
                errorLabel.setVisible(true);
            }

        } else if (e.getSource() == backButton) {
            new MainPage().setVisible(true);
            this.dispose();
        }

    }
}
