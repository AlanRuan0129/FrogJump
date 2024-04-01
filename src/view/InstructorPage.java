package view;

import entity.User;
import utils.LocalStorage;
import utils.MusicUtils;
import view.custom.CenterLabelInPanel;
import view.custom.SettingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructorPage extends JFrame implements ActionListener {
    JButton viewAllButton = new JButton("View All Player Progress");
    JButton logoutButton = new JButton("Logout");

    public InstructorPage() {
        initComponents();
    }

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
        add(new SettingPanel(), BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new InstructorPage().setVisible(true);
    }

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
