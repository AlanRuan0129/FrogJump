package view;

import entity.DataObject;
import entity.Record;
import entity.User;
import model.RecordModel;
import utils.LocalStorage;
import view.custom.SettingPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.List;

public class InstructorProgressPage extends JFrame {
    TableModel tableModel = new DefaultTableModel();
    public InstructorProgressPage() {
        initComponents();
    }

    private void initComponents() {
        setData();
        setTitle("Instructor Progress Page");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.WHITE);

        JPanel titlePanel = new JPanel();
        JLabel label = new JLabel("Progress View");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.setBackground(Color.WHITE);
        JPanel container = new JPanel();
        container.setBackground(Color.WHITE);
        container.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        container.add(label);
        titlePanel.add(container);

        topPanel.add(titlePanel, BorderLayout.NORTH);
        topPanel.setPreferredSize(new Dimension(500, 80));

        JTable table = new JTable(tableModel);

        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setEnabled(false);

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel settingPanel = new SettingPanel("Home Page");

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(settingPanel, BorderLayout.SOUTH);


        add(panel);

    }

    private void setData(){
        DataObject dataObject = LocalStorage.get(LocalStorage.DATA, DataObject.class);
        List<User> users = dataObject.getUsers();
        String[] columnNames = {"UserName", "Easy/Medium/Hard", "Highest Level", "Score"};
        Object[][] data = new Object[users.size()][4];
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            data[i][0] = user.getUsername();
            if (user.getEasyLevel() >= user.getMediumLevel() && user.getEasyLevel() >= user.getHardLevel()) {
                data[i][1] = "Easy";
                data[i][2] = user.getEasyLevel();
            } else if (user.getMediumLevel() >= user.getEasyLevel() && user.getMediumLevel() >= user.getHardLevel()) {
                data[i][1] = "Medium";
                data[i][2] = user.getMediumLevel();
            } else {
                data[i][1] = "Hard";
                data[i][2] = user.getHardLevel();
            }
            int highestScore = 0;
            for (Record record : user.getRecords()) {
                if (record.getScore() > highestScore) {
                    highestScore = record.getScore();
                }
            }
            data[i][3] = highestScore;
        }
        tableModel = new DefaultTableModel(data, columnNames);
    }

}
