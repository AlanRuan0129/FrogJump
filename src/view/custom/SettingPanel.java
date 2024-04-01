package view.custom;

import entity.User;
import utils.ImageBufferUtils;
import utils.LocalStorage;
import utils.MusicUtils;
import view.HomePage;
import view.InstructorLoginPage;
import view.InstructorPage;
import view.SettingPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingPanel extends JPanel {

    private String backText;

    private JLabel label;

    public SettingPanel() {
        initComponents();
    }

    public SettingPanel(String backText) {
        this.backText = backText;
        initComponents();
        addBackButton();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setPreferredSize(new Dimension(80, 80));
        ImageIcon icon = ImageBufferUtils.getImageIcon(ImageBufferUtils.SETTINGS);

        label = new JLabel(icon);
        panel.add(label);
        panel.add(new JLabel("Setting"));
        panel.setBackground(Color.WHITE);

        setLeftActionListener();

        add(panel, BorderLayout.WEST);

    }

    private void addBackButton() {
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout(12, 12));
        JButton homeButton = new JButton(backText);
        homeButton.setPreferredSize(new Dimension(120, 40));
        homeButton.setBackground(Color.WHITE);
        homeButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        homePanel.add(homeButton, BorderLayout.CENTER);
        homePanel.add(new JLabel(), BorderLayout.SOUTH);
        homePanel.add(new JLabel(), BorderLayout.NORTH);
        homePanel.add(new JLabel(), BorderLayout.EAST);
        homePanel.setBackground(Color.WHITE);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
                if (user != null && user.isSetSound()) {
                    MusicUtils.playSound("sound");
                }
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SettingPanel.this);
                frame.dispose();
                if (LocalStorage.get(LocalStorage.CURRENT_USER, User.class) == null) {
                    new InstructorPage().setVisible(true);
                } else {
                    new HomePage().setVisible(true);
                }
            }
        });

        add(homePanel, BorderLayout.EAST);
    }

    public void setLeftActionListener() {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JDialog dialog = new SettingPage();
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            }
        });
    }


}
