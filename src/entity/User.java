package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.easyLevel = 1;
        this.mediumLevel = 1;
        this.hardLevel = 1;
        records = new ArrayList<>();
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEasyLevel() {
        return easyLevel;
    }

    public boolean isSetMusic() {
        return setMusic;
    }

    public void setSetMusic(boolean setMusic) {
        this.setMusic = setMusic;
    }

    public boolean isSetSound() {
        return setSound;
    }

    public void setSetSound(boolean setSound) {
        this.setSound = setSound;
    }

    public boolean isSetNotification() {
        return setNotification;
    }

    public void setSetNotification(boolean setNotification) {
        this.setNotification = setNotification;
    }

    public void setEasyLevel(int easyLevel) {
        this.easyLevel = easyLevel;
    }

    public int getMediumLevel() {
        return mediumLevel;
    }

    public void setMediumLevel(int mediumLevel) {
        this.mediumLevel = mediumLevel;
    }

    public int getHardLevel() {
        return hardLevel;
    }

    public void setHardLevel(int hardLevel) {
        this.hardLevel = hardLevel;
    }

    public List<Record> getRecords() {
        if (records == null) {
            records = new ArrayList<>();
        }
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}

