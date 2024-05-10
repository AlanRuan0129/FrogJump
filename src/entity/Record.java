package entity;

import java.io.Serializable;

/**
 * Represent a record of a game session, include time, difficulty level, game level and score achieved.
 * This class implement {@link Serializable} to allow objects to be easily saved and loaded from a file system.
 * @ author rwang828
 * @ version 1.0
 * @since 2024 - 03 - 29
 */
public class Record implements Serializable {
    private String time;
    private int hardLevel;
    private int level;
    private int score;


    /**
     * Construct a new record with corresponding time, difficulty level, game level and scores.
     * @param time time for palyer to complete game
     * @param hardLevel difficulty level of the game session
     * @param level game level achieved in a session
     * @param score score achieved in a session
     */
    public Record(String time, int hardLevel, int level, int score) {
        this.time = time;
        this.hardLevel = hardLevel;
        this.level = level;
        this.score = score;
    }


    /**
     * Default constructor for creating an empty record
     */
    public Record() {
    }


    /**
     * Get the time remaining of the game session.
     * @return the {@code String} representation of time remaining.
     */
    public String getTime() {
        return time;
    }


    /**
     * Set the time remaining of the game session.
     * @param time the new {@code String} representation of time remaining
     */
    public void setTime(String time) {
        this.time = time;
    }


    /**
     * Get the level of difficulty.
     * @return the {@code int} representation of level of difficulty.
     */
    public int getHardLevel() {
        return hardLevel;
    }


    /**
     * Set the level of difficulty
     * @param hardLevel the new {@code int} representation of level of difficulty.
     */
    public void setHardLevel(int hardLevel) {
        this.hardLevel = hardLevel;
    }


    /**
     * Get the level of game
     * @return the {@code int} representation of level of game.
     */
    public int getLevel() {
        return level;
    }


    /**
     * Set the level of game.
     * @param level the new {@code int} representation of level of game.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Get the score achieve in the game session.
     * @return the {@code int} representation of scores achieved.
     */
    public int getScore() {
        return score;
    }

    /**
     * Set the score achieved in the game session
     * @param score the new {@code int} representation of scores achieved.
     */
    public void setScore(int score) {
        this.score = score;
    }
}
