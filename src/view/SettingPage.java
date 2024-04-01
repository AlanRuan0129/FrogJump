package view;

import entity.DataObject;
import entity.User;
import utils.FileUtils;
import utils.ImageBufferUtils;
import utils.LocalStorage;
import utils.MusicUtils;

import javax.swing.*;
import java.awt.*;

public class SettingPage extends JDialog {
    public SettingPage() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Setting Page");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        ImageIcon offIcon = ImageBufferUtils.getImageIcon(ImageBufferUtils.ON);
        ImageIcon onIcon = ImageBufferUtils.getImageIcon(ImageBufferUtils.OFF);

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(500, 100));
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.WHITE);
        JLabel label = new JLabel("Setting");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(label);
        JPanel blankPanel = new JPanel();
        blankPanel.setBackground(Color.WHITE);
        blankPanel.setPreferredSize(new Dimension(500, 50));
        topPanel.add(blankPanel, BorderLayout.NORTH);
        topPanel.add(titlePanel, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(500, 200));
        centerPanel.setBackground(Color.WHITE);

        JPanel musicPanel = new JPanel();
        musicPanel.setBackground(Color.WHITE);
        ImageIcon musicIcon = ImageBufferUtils.getImageIcon(ImageBufferUtils.MUSIC);
        JLabel musicLabel = new JLabel(musicIcon);
        musicPanel.add(musicLabel);
        JLabel musicText = new JLabel("Music        ");
        musicText.setFont(new Font("Arial", Font.BOLD, 16));
        musicPanel.add(musicText);
        JToggleButton musicButton = new JToggleButton();
        musicButton.addActionListener(e -> {
            if (musicButton.isSelected()) {
                User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
                user.setSetMusic(false);
                DataObject dataObject = LocalStorage.get(LocalStorage.DATA, DataObject.class);
                FileUtils.writeData(dataObject);
                MusicUtils.stopMusic();

            } else {
                User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
                user.setSetMusic(true);
                DataObject dataObject = LocalStorage.get(LocalStorage.DATA, DataObject.class);
                FileUtils.writeData(dataObject);
                MusicUtils.playMusicLoop();
            }
        });

        musicButton.setIcon(onIcon);
        musicButton.setSelectedIcon(offIcon);
        musicButton.setBackground(Color.WHITE);
        musicButton.setBorder(null);
        musicPanel.add(musicButton);
        musicPanel.setPreferredSize(new Dimension(500, 80));
        centerPanel.add(musicPanel);

        JPanel soundPanel = new JPanel();
        soundPanel.setBackground(Color.WHITE);
        ImageIcon soundIcon = ImageBufferUtils.getImageIcon(ImageBufferUtils.SOUND);
        JLabel soundLabel = new JLabel(soundIcon);
        soundPanel.add(soundLabel);
        JLabel soundText = new JLabel("Sound        ");
        soundText.setFont(new Font("Arial", Font.BOLD, 16));
        soundPanel.add(soundText);
        JToggleButton soundButton = new JToggleButton();

        soundButton.addActionListener(e -> {
            if (soundButton.isSelected()) {
                User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
                user.setSetSound(false);
                DataObject dataObject = LocalStorage.get(LocalStorage.DATA, DataObject.class);
                FileUtils.writeData(dataObject);
            } else {
                User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
                user.setSetSound(true);
                DataObject dataObject = LocalStorage.get(LocalStorage.DATA, DataObject.class);
                FileUtils.writeData(dataObject);
            }
        });

        soundButton.setIcon(onIcon);
        soundButton.setSelectedIcon(offIcon);
        soundButton.setBackground(Color.WHITE);
        soundButton.setBorder(null);
        soundPanel.add(soundButton);
        soundPanel.setPreferredSize(new Dimension(500, 80));
        centerPanel.add(soundPanel);

        JPanel notificationPanel = new JPanel();
        notificationPanel.setBackground(Color.WHITE);
        ImageIcon notificationIcon = ImageBufferUtils.getImageIcon(ImageBufferUtils.NOTIFICATION);
        JLabel notificationLabel = new JLabel(notificationIcon);
        notificationPanel.add(notificationLabel);
        JLabel notificationText = new JLabel("Notification");
        notificationText.setFont(new Font("Arial", Font.BOLD, 16));
        notificationPanel.add(notificationText);
        JToggleButton notificationButton = new JToggleButton();

        notificationButton.setIcon(onIcon);
        notificationButton.setSelectedIcon(offIcon);
        notificationButton.setBackground(Color.WHITE);
        notificationButton.setBorder(null);
        notificationPanel.add(notificationButton);
        notificationPanel.setPreferredSize(new Dimension(500, 80));
        centerPanel.add(notificationPanel);

        notificationButton.addActionListener(e -> {
            if (notificationButton.isSelected()) {
                User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
                user.setSetNotification(false);
                DataObject dataObject = LocalStorage.get(LocalStorage.DATA, DataObject.class);
                FileUtils.writeData(dataObject);
            } else {
                User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
                user.setSetNotification(true);
                DataObject dataObject = LocalStorage.get(LocalStorage.DATA, DataObject.class);
                FileUtils.writeData(dataObject);
            }
        });



        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new SettingPage().setVisible(true);
    }
}
