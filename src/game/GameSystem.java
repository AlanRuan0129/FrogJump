package game;

public class GameSystem {
    private int score;
    private int level;
    private int hardLevel;
    private TimeSystem timeSystem;
    private boolean win;

    public GameSystem(int hardLevel,int level) {
        this.score = 0;
        this.timeSystem = new TimeSystem();
        this.level = level;
        this.hardLevel = hardLevel;
    }

    public void increaseScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public int getHardLevel() {
        return hardLevel;
    }

    public TimeSystem getTimeSystem() {
        return timeSystem;
    }

    public void startGame() {
        timeSystem.start();
        new GameFrame(this);
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
