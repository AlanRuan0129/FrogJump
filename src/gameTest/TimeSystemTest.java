package gameTest;

import game.TimeSystem;

import static org.junit.jupiter.api.Assertions.*;

class TimeSystemTest {
    private TimeSystem timeSystem;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.timeSystem = new TimeSystem();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getTimeLeft() {
        assertEquals("1:40", timeSystem.getTimeLeft(), "Initial time left should be formatted as 1:40");
    }

    @org.junit.jupiter.api.Test
    void start() throws InterruptedException {
        assertFalse(timeSystem.isRunning(), "Timer should not be running initially");
        timeSystem.start();
        Thread.sleep(100);
        assertTrue(timeSystem.isRunning(), "Timer should be running after start()");
    }

    @org.junit.jupiter.api.Test
    void stop() throws InterruptedException {
        timeSystem.start();
        Thread.sleep(100);
        timeSystem.stop();
        Thread.sleep(100);
        assertFalse(timeSystem.isRunning(), "Timer should not be running after stop()");
    }

    @org.junit.jupiter.api.Test
    void hasTime() {
        assertTrue(timeSystem.hasTime(), "hasTime() should return true initially");
        timeSystem.start();
        timeSystem.stop();
    }
}