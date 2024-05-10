package entityTest;

import entity.Record;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordTest {

    private Record record;
    private String time = "13:14";
    private int hardLevel = 1;
    private int level = 10;
    private int score = 100;
    @BeforeEach
    void setUp() {
        record = new Record(time,hardLevel,level,score);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTime() {
        try{
            assertEquals(time, record.getTime());
            System.out.println("Test getTime Pass");
        }catch (AssertionError e){
            System.out.println("Test getTime Fail");
            throw e;
        }
    }

    @Test
    void setTime() {
        String newTime = "5:20";
        try{
            record.setTime(newTime);
            assertEquals(newTime, record.getTime());
            System.out.println("Test setTime Pass");
        }catch (AssertionError e){
            System.out.println("Test setTime Fail");
            throw e;
        }
    }

    @Test
    void getHardLevel() {
        try{
            assertEquals(hardLevel, record.getHardLevel());
            System.out.println("Test getHardLevel Pass");
        }catch (AssertionError e){
            System.out.println("Test getHardLevel Fail");
            throw e;
        }
    }

    @Test
    void setHardLevel() {
        int newHardLevel = 2;
        try{
            record.setHardLevel(newHardLevel);
            assertEquals(newHardLevel, record.getHardLevel());
            System.out.println("Test set HardLevel Pass");
        }catch (AssertionError e){
            System.out.println("Test set HardLevel Fail");
            throw e;
        }
    }

    @Test
    void getLevel() {
        try{
            assertEquals(level, record.getLevel());
            System.out.println("Test getLevel Pass");
        }catch (AssertionError e){
            System.out.println("Test getLevel Fail");
            throw e;
        }
    }

    @Test
    void setLevel() {
        int newLevel = 20;
        try{
            record.setLevel(newLevel);
            assertEquals(newLevel, record.getLevel());
            System.out.println("Test setLevel Pass");
        }catch (AssertionError e){
            System.out.println("Test setLevel Fail");
            throw e;
        }
    }

    @Test
    void getScore() {
        try{
            assertEquals(score, record.getScore());
            System.out.println("Test getScore Pass");
        }catch (AssertionError e){
            System.out.println("Test getScore Fail");
            throw e;
        }
    }

    @Test
    void setScore() {
        int newScore = 200;
        try{
            record.setScore(newScore);
            assertEquals(newScore, record.getScore());
            System.out.println("Test setScore Pass");
        }catch (AssertionError e){
            System.out.println("Test setScore Fail");
            throw e;
        }
    }
}