package game;

import entity.Leaf;
import model.RecordModel;
import view.InCompletePage;
import view.custom.SettingPanel;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame(GameSystem gameSystem) {
        GameTopPanel gameTopPanel = new GameTopPanel();
        GameCenterPanel gameCenterPanel = new GameCenterPanel(gameSystem);

        setTitle("Game");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(gameTopPanel, BorderLayout.NORTH);
        add(gameCenterPanel, BorderLayout.CENTER);
        add(new SettingPanel("Quit"), BorderLayout.SOUTH);

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        while (!gameSystem.isWin() && gameSystem.getTimeSystem().hasTime()) {
            gameTopPanel.setTime(gameSystem.getTimeSystem().getTimeLeft());
            gameTopPanel.setScore(gameSystem.getScore());
        }

        this.dispose();
        new InCompletePage(gameSystem.getScore()).setVisible(true);
        RecordModel.saveRecord(gameSystem.getHardLevel(), gameSystem.getLevel(), gameSystem.getScore(), Leaf.Status.WRONG);


    }

    public static void main(String[] args) {
        GameSystem gameSystem = new GameSystem(1, 1);
        gameSystem.startGame();
    }

}
