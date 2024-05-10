package game;

/**
 * The Game Systems class is responsible for managing the state of the game, including the score, level, difficulty level, and time system.
 * This class provides ways to increase the score, get the current score, level, and difficulty level,
 * As well as starting the game and determining whether the player has won the game.
 *
 * @author Pengyuan Wei
 * @version 1.0
 * @since 2024/3/29
 */
public class GameSystem {
    private int score;//Player's score
    private int level;//Current game level
    private int hardLevel;//Game difficulty level
    private TimeSystem timeSystem;//Game timing system
    private boolean win;//Whether the player wins the game
    /**
     * Construct a new instance of the game system, initializing the score, level, and difficulty level.
     * @param hardLevel The difficulty level of the game
     * @param level Current game level
     */
    public GameSystem(int hardLevel,int level) {
        this.score = 0;
        this.timeSystem = new TimeSystem();
        this.level = level;
        this.hardLevel = hardLevel;
    }

    /**
     * Increases the player's score.
     * @param score The number of points to be increased.
     */
    public void increaseScore(int score) {
        this.score += score;
    }

    /**
     * Gets the player's current score.
     * @return Current score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Get the current game level.
     * @return Game level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Get the difficulty level of the game.
     * @return Hard level
     */
    public int getHardLevel() {
        return hardLevel;
    }

    /**
     * Gets an instance of the game's time system.
     * @return Time system instance
     */
    public TimeSystem getTimeSystem() {
        return timeSystem;
    }

    /**
     * Start the game, initialize the time system and create the game interface.
     */
    public void startGame() {
        timeSystem.start();
        new GameFrame(this);
    }

    /**
     * Check whether the player has won the game.
     * @return Return true if the player wins the game, false otherwise.
     */
    public boolean isWin() {
        return win;
    }

    /**
     * Sets whether the player wins the game.
     * @param win Whether the player wins the game
     */
    public void setWin(boolean win) {
        this.win = win;
    }
}
