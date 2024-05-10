package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * This class represent a User object in the game,
 * it stores the user's credential, preference of sound, music and notification
 * and record player's achievement.
 * @ author rwang828
 * @ version 1.0
 * @since 2024 - 03 - 29
 */
public class User implements Serializable {
    private String username;
    private String password;
    private int easyLevel;
    private int mediumLevel;
    private int hardLevel;
    private List<Record> records;
    private boolean setMusic = true;
    private boolean setSound = true;
    private boolean setNotification = true;

    /**
     * Construct a new User object with corresponding username and password.
     * Initialize easy, medium and hard level to 1 and set up empty list of recording.
     * Music, sound and notification are enabled as default.
     * @param username username of the player
     * @param password password of the player
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.easyLevel = 1;
        this.mediumLevel = 1;
        this.hardLevel = 1;
        records = new ArrayList<>();
    }


    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * Get username of player
     * @return the {@code String} representation of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username of player
     * @param username String representation of username of player
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * Get password of player
     * @return the {@code String} representation of password of player
     */
    public String getPassword() {
        return password;
    }


    /**
     * Set password of player
     * @param password String representation of password of player
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Get the level achieved by user of easy level
     * @return the {@code int} representation of game level.
     */
    public int getEasyLevel() {
        return easyLevel;
    }


    /**
     * Get the status of music, whether it have benn enable or not
     * @return {@code true} if music is enable
     *         {@code false} other wise
     */
    public boolean isSetMusic() {
        return setMusic;
    }


    /**
     * Enable or disable the music
     * @param setMusic {@code true} to enable the music
     *                 {@code false} otherwise
     */
    public void setSetMusic(boolean setMusic) {
        this.setMusic = setMusic;
    }


    /**
     * Get the status of sound, whether it have benn enable or not
     * @return {@code true} if sound is enable
     *         {@code false} otherwise
     */
    public boolean isSetSound() {
        return setSound;
    }


    /**
     * Enable or disable the music
     * @param setSound {@code true} to enable the sound
     *                 {@code false} otherwise
     */
    public void setSetSound(boolean setSound) {
        this.setSound = setSound;
    }

    /**
     * Get the status of notification, whether it have benn enable or not
     * @return {@code true} if notification is enable
     *         {@code false} otherwise
     */
    public boolean isSetNotification() {
        return setNotification;
    }


    /**
     * Enable or disable the notification, whether it have been enable or not
     * @param setNotification {@code true} to enable the notification
     *                        {@code false} otherwise
     */
    public void setSetNotification(boolean setNotification) {
        this.setNotification = setNotification;
    }


    /**
     * Set the easy level achieved by player
     * @param easyLevel the new game level of easy level.
     */
    public void setEasyLevel(int easyLevel) {
        this.easyLevel = easyLevel;
    }


    /**
     * Get the level achieved by user of medium level
     * @return the {@code int} representation of game level.
     */
    public int getMediumLevel() {
        return mediumLevel;
    }

    /**
     * Set the medium level achieved by player
     * @param mediumLevel the new game level of medium level.
     */
    public void setMediumLevel(int mediumLevel) {
        this.mediumLevel = mediumLevel;
    }

    /**
     * Get the level achieved by user of hard level
     * @return the {@code int} representation of game level.
     */
    public int getHardLevel() {
        return hardLevel;
    }

    /**
     * Set the hard level achieved by player
     * @param hardLevel the new game level of hard level.
     */
    public void setHardLevel(int hardLevel) {
        this.hardLevel = hardLevel;
    }


    /**
     * Return the list of records associated with the player.
     * If no record found, return empty list.
     * @return the list of records
     */
    public List<Record> getRecords() {
        if (records == null) {
            records = new ArrayList<>();
        }
        return records;
    }

    /**
     * Set the list of records for the player
     * @param records the new list of records
     */
    public void setRecords(List<Record> records) {
        this.records = records;
    }
}

