package game;

public class TimeSystem {
    private int timeLeft;
    private boolean isRunning;

    public TimeSystem() {
        this.timeLeft = 100;
        this.isRunning = false;
        new Thread(() -> {
            while (isRunning) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (timeLeft > 0) {
                    timeLeft--;
                }
            }
        }).start();
    }

    public String getTimeLeft() {
        int minutes = timeLeft / 60;
        int seconds = timeLeft % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    public void start() {
        isRunning = true;

    }

    public void stop() {
        isRunning = false;
    }


    public boolean hasTime() {
        return timeLeft > 0;
    }

}
