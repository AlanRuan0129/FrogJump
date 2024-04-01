package view;

import entity.Record;
import model.RecordModel;
import utils.ImageBufferUtils;
import view.custom.SettingPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.Comparator;
import java.util.List;

public class HistoryPage extends JFrame {

    JLabel l1 = new JLabel("Highest: Easy Level 1, 90");
    JLabel l2 = new JLabel("Lowest: Hard Level 3, 40");
    TableModel tableModel = new DefaultTableModel();
    public HistoryPage() {
        initComponents();
    }

    private void initComponents() {
        setData();

        setTitle("History Page");
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
        JLabel label = new JLabel("History View");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.setBackground(Color.WHITE);
        JPanel container = new JPanel();
        container.setBackground(Color.WHITE);
        container.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        container.add(label);
        titlePanel.add(container);

        topPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel topMainPanel = new JPanel();
        topMainPanel.setLayout(new BorderLayout());
        topMainPanel.setBackground(Color.WHITE);

        JLabel iconLabel = new JLabel();
        ImageIcon icon = ImageBufferUtils.getImageIcon(ImageBufferUtils.RANKING);
        iconLabel.setIcon(icon);
        JPanel topLeftPanel = new JPanel();
        topLeftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        topLeftPanel.setBackground(Color.WHITE);
        topLeftPanel.add(iconLabel);
        topLeftPanel.setPreferredSize(new Dimension(100, 68));
        topMainPanel.add(topLeftPanel, BorderLayout.WEST);


        JPanel topRightPanel = new JPanel();
        topRightPanel.setLayout(new GridLayout(2,1,5,5));
        topRightPanel.setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        p1.setBackground(Color.WHITE);

        p1.add(l1);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.setBackground(Color.WHITE);

        p2.add(l2);

        topRightPanel.add(p1);
        topRightPanel.add(p2);

        topMainPanel.add(topRightPanel, BorderLayout.CENTER);
        topPanel.add(topMainPanel, BorderLayout.CENTER);

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
        int highestScore = 0;
        int highestLevel = 0;
        String highestLevelStr = "";
        int lowestScore = Integer.MAX_VALUE;
        int lowestLevel = 0;
        String lowestLevelStr = "";

        List<Record> records = RecordModel.getRecords();
        Object[][] data = new Object[records.size()][5];
        for (int i = 0; i < records.size(); i++) {
            Record record = records.get(i);
            data[i][0] = i + 1;
            if (record.getHardLevel() == 1) {
                data[i][1] = "Easy";
            } else if (record.getHardLevel() == 2) {
                data[i][1] = "Medium";
            } else {
                data[i][1] = "Hard";
            }
            data[i][2] = record.getLevel();
            data[i][3] = record.getScore();
            data[i][4] = record.getTime();

            if (record.getScore() > highestScore && record.getLevel() >= highestLevel) {
                highestScore = record.getScore();
                highestLevel = record.getLevel();
                highestLevelStr = String.valueOf(data[i][1]);
            }
            if (record.getScore() < lowestScore && record.getLevel() <= lowestLevel) {
                lowestScore = record.getScore();
                lowestLevel = record.getLevel();
                lowestLevelStr = String.valueOf(data[i][1]);
            }
        }
        tableModel = new DefaultTableModel(data, new String[]{"Order", "Easy/Medium/Hard", "Level", "Score", "Time"});
        l1.setText("Highest: " + highestLevelStr + " Level " + highestLevel + ", " + highestScore);
        l2.setText("Lowest: " + lowestLevelStr + " Level " + lowestLevel + ", " + lowestScore);
    }

}
