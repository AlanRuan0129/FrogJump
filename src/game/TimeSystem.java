package game;


/**
 * The TimeSystem class provides a simple timing mechanism for a game, allowing for a countdown
 * from a specified amount of time.
 * Authors: Ziwen Ma
 * Version: 1.0
 * Since: 2024-03-27
 */
public class TimeSystem {
    private int timeLeft;
    private boolean isRunning;

    /**
     * Constructs a new TimeSystem which set the start time of 100 seconds.
     * The timer is not running upon creation. It must be explicitly started using the {@code start()} method.
     */
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

    /**
     * Returns the remaining time in a format of minutes and seconds style which will show in screen.
     *
     * @return A string representing the remaining time.
     */
    public String getTimeLeft() {
        int minutes = timeLeft / 60;
        int seconds = timeLeft % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    /**
     * Starts the countdown timer.
     */
    public void start() {
        isRunning = true;

    }

    /**
     * Stops the countdown timer.
     */
    public void stop() {
        isRunning = false;
    }

    /**
     * Checks if there is still time left on the timer.
     *
     * @return {@code true} if there is time remaining, {@code false} otherwise.
     */
    public boolean hasTime() {
        return timeLeft > 0;
    }

    /**
     * Checks if the timer is currently running.
     *
     * @return true if the timer is running, false otherwise.
     */
    public boolean isRunning(){
        return this.isRunning;
    }

}
