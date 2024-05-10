package view;

import utils.LocalStorage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the login page for the instructor. It has a text field for the instructor code and a login button.
 * Authors: Ziwen Ma
 * Version: 1.0
 * Since: Since: 2023-03-24
 */
public class InstructorLoginPage extends JFrame implements ActionListener {
    JButton loginButton = new JButton("Login");
    JButton backButton = new JButton("Return to Main Page");
    JTextField nameField = new JTextField(16);
    JLabel errorLabel = new JLabel(
            "Invalid Code, Please Try Again");

    public InstructorLoginPage() {
        initComponents();
    }

    /**
     * This method initializes the components of the instructor login page.
     */
    private void initComponents() {
        setTitle("Instructor Login");
        setSize(500, 600);
        errorLabel.setVisible(false);

        loginButton.addActionListener(this);
        backButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(30,30));
        panel.setBackground(Color.WHITE);


        JPanel titlePanel = new JPanel();
        JLabel label = new JLabel("Hi, Instructor!!!");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(new Color(21, 95, 155));
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(label);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 1, 30, 30));
        inputPanel.setBackground(Color.WHITE);

        JPanel blankPanel = new JPanel();
        blankPanel.setBackground(Color.WHITE);
        inputPanel.add(blankPanel);

        JLabel nameLabel = new JLabel("Enter a valid:              ");

        nameField.setPreferredSize(new Dimension(200, 40));

        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));


        JPanel namePanel = new JPanel();
        namePanel.setBackground(Color.WHITE);
        namePanel.add(nameLabel);
        namePanel.add(nameField);


        errorLabel.setForeground(Color.RED);
        namePanel.add(errorLabel);


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
        new InstructorLoginPage().setVisible(true);
    }

    /**
     * This method is called when the login button is clicked. It checks if the code entered is correct and opens the instructor page.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            if (nameField.getText().equals(LocalStorage.INSTRUCTOR_CODE)){
                new InstructorPage().setVisible(true);
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
