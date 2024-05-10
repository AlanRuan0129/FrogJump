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

/**
 * The SettingPanel class provides a panel that contains a Settings icon and a back button.
 * When you click the Settings icon, the Settings dialog box will pop up. The Back button closes
 * the current window and returns to the appropriate interface based on the user's status.
 * For example, if the current user is an instructor, return to the instructor page; Otherwise return to the home page.
 * The background of the panel defaults to white.
 *
 * @author Pengyuan Wei
 * @version 1.0
 * @since 2024/3/29
 */
public class SettingPanel extends JPanel {

    private String backText;//Returns the text of the button

    private JLabel label;//Displays the TAB for the Settings icon

    /**
     * Default constructor that initializes the component without adding a return button.
     */
    public SettingPanel() {
        initComponents();
    }

    /**
     * Constructor with return text, initializes the component and adds a return button with text.
     * @param backText Returns the text displayed on the button.
     */
    public SettingPanel(String backText) {
        this.backText = backText;
        initComponents();
        addBackButton();
    }

    /**
     * Initializes panel components and sets the layout and background.
     */
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

    /**
     * Add a back button to the panel, set the behavior of the button: click to return to the corresponding page according to the type of user.
     */
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

    /**
     * Set the left setting icon click on the event listener, click on the pop-up setting dialog box.
     */
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
