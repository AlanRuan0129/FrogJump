package view;

import entity.User;
import model.UserModel;
import utils.LocalStorage;
import utils.MusicUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the new user register page. It has two text fields for user name and password, and two buttons for register and return to main page.
 */
public class NewUserRegister extends JFrame implements ActionListener {
    JButton registerButton = new JButton("Register");
    JButton backButton = new JButton("Return to Main Page");
    JLabel errorLabel = new JLabel(
            "User name is occupied! Select another valid name!");

    JTextField nameField = new JTextField(16);
    JPasswordField passwordField = new JPasswordField(16);


    /**
     * This is the constructor of the class. It initializes the components of the new user register page.
     */
    public NewUserRegister() {
        initComponents();
    }

    /**
     * This method initializes the components of the new user register page.
     */
    private void initComponents() {
        setTitle("New User Register");
        setSize(500, 600);

        registerButton.addActionListener(this);
        backButton.addActionListener(this);

        errorLabel.setVisible(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(30, 30));
        panel.setBackground(Color.WHITE);


        JPanel titlePanel = new JPanel();
        JLabel label = new JLabel("Welcome New Gamer!");
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

        errorLabel.setForeground(Color.RED);
        namePanel.add(errorLabel);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(Color.WHITE);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);


        registerButton.setPreferredSize(new Dimension(160, 40));
        registerButton.setBackground(Color.WHITE);
        registerButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        JPanel registerPanel = new JPanel();
        registerPanel.setBackground(Color.WHITE);
        registerPanel.add(registerButton);


        backButton.setPreferredSize(new Dimension(160, 40));
        backButton.setBackground(Color.WHITE);
        backButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        JPanel backPanel = new JPanel();
        backPanel.setBackground(Color.WHITE);
        backPanel.add(backButton);


        inputPanel.add(namePanel);
        inputPanel.add(passwordPanel);
        inputPanel.add(registerPanel);
        inputPanel.add(backPanel);


        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(titlePanel, BorderLayout.NORTH);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            if (UserModel.register(nameField.getText(), new String(passwordField.getPassword()))) {
                new HomePage().setVisible(true);
                this.dispose();
            } else {
                errorLabel.setVisible(true);
            }
        } else if (e.getSource() == backButton) {
            new MainPage().setVisible(true);
            this.dispose();
        }

    }
}