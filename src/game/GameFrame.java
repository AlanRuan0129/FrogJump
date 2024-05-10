package game;

import entity.Leaf;
import model.RecordModel;
import view.InCompletePage;
import view.custom.SettingPanel;

import javax.swing.*;
import java.awt.*;

/**
 * The {@code GameFrame} class extends {@link JFrame} to create the main game window for the application.
 * It initializes and displays the game's top panel, center panel, and a settings panel. It also handles
 * the game loop, updating the game's top panel with the current time and score, and checks for the win
 * condition. If the game is over, it disposes of the game frame and displays the incomplete page along
 * with saving the game record.
 *
 * @author Yujun Ma
 * @version 1.0
 * @since 2024/3/30
 */
public class GameFrame extends JFrame {

    /**
     * Constructs a new {@code GameFrame} and initializes the game's UI components and game loop.
     *
     * @param gameSystem The {@link GameSystem} object that contains the game's logic and state.
     */
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
