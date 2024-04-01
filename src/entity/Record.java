package entity;

import java.io.Serializable;

public class Record implements Serializable {
    private String time;
    private int hardLevel;
    private int level;
    private int score;

    public Record(String time, int hardLevel, int level, int score) {
        this.time = time;
        this.hardLevel = hardLevel;
        this.level = level;
        this.score = score;
    }

    public Record() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getHardLevel() {
        return hardLevel;
    }

    public void setHardLevel(int hardLevel) {
        this.hardLevel = hardLevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
