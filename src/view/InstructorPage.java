package view;

import view.custom.CenterLabelInPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The InstructorPage class creates a GUI frame where instructors can interact
 * with the application. It offers buttons to view all player progress or to log out.
 * This class extends JFrame and implements the ActionListener interface to handle
 * button click events.
 * Authors: Ziwen Ma
 * Version: 1.0
 * Since: 2023-03-24
 */
public class InstructorPage extends JFrame implements ActionListener {
    JButton viewAllButton = new JButton("View All Player Progress");
    JButton logoutButton = new JButton("Logout");

    /**
     * Constructor for the InstructorPage. It initializes the GUI components.
     */
    public InstructorPage() {
        initComponents();
    }

    /**
     * Initializes the GUI components of the instructor page. It sets up the layout,
     * the buttons, and their respective action listeners. It also defines the properties of the buttons and panels.
     */
    private void initComponents() {
        setTitle("Instructor Page");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        viewAllButton.addActionListener(this);
        logoutButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.WHITE);

        JPanel p1 = new CenterLabelInPanel(" ", 16);

        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(500, 100));
        p2.setBackground(Color.WHITE);

        JPanel p4 = new CenterLabelInPanel("Hello Teacher", 20);
        JPanel p5 = new CenterLabelInPanel("Welcome to Instructor Page", 20);


        viewAllButton.setPreferredSize(new Dimension(230, 60));
        viewAllButton.setBackground(Color.WHITE);
        viewAllButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        JPanel p6 = new JPanel();
        viewAllButton.setFont(new Font("Arial", Font.BOLD, 16));
        p6.setPreferredSize(new Dimension(500, 90));
        p6.setBackground(Color.WHITE);
        p6.add(viewAllButton);
        viewAllButton.setBackground(new Color(110, 167, 219));


        logoutButton.setPreferredSize(new Dimension(230, 60));
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        JPanel p7 = new JPanel();
        p7.setPreferredSize(new Dimension(500, 90));
        p7.setBackground(Color.WHITE);
        p7.add(logoutButton);

        panel.add(p1);

        panel.add(p4);
        panel.add(p5);
        panel.add(p2);
        panel.add(p6);
        panel.add(p7);

        add(panel, BorderLayout.CENTER);
    }

    /**
     * The main method to run the InstructorPage frame.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        new InstructorPage().setVisible(true);
    }

    /**
     * Handles action events triggered by the GUI components. Open a new page or logout
     *
     * @param e the ActionEvent triggered by interacting by GUI components.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == viewAllButton) {
            new InstructorProgressPage().setVisible(true);
            this.dispose();
        } else if (e.getSource() == logoutButton) {
            new MainPage().setVisible(true);
            this.dispose();
        }

    }
}
