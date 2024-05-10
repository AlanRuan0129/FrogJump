package entityTest;

import entity.Record;
import entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    private String Username = "TestUsername";
    private String Password = "TestPassword";
    @BeforeEach
    void setUp() {
        user = new User(Username, Password);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUsername() {
        try{
            assertEquals(Username, user.getUsername());
            System.out.println("Test getUsername Pass");
        }catch (AssertionError e){
            System.out.println("Test getUsername Fail");
            throw e;
        }
    }

    @Test
    void setUsername() {
        String Username1 = "TestUsername1";
        try{
            user.setUsername(Username1);
            assertEquals(Username1, user.getUsername());
            System.out.println("Test setUsername Pass");
        }catch (AssertionError e){
            System.out.println("Test setUsername Fail");
            throw e;
        }
    }

    @Test
    void getPassword() {
        try{
            assertEquals(Password, user.getPassword());
            System.out.println("Test getPassword Pass");
        }catch (AssertionError e){
            System.out.println("Test getPassword Fail");
            throw e;
        }
    }

    @Test
    void setPassword() {
        String Password1 = "TestPassword1";
        try{
            user.setPassword(Password1);
            assertEquals(Password1, user.getPassword());
            System.out.println("Test setPassword Pass");
        }catch (AssertionError e){
            System.out.println("Test setPassword Fail");
            throw e;
        }
    }

    @Test
    void getEasyLevel() {
        try{
            assertEquals(1, user.getEasyLevel());
            System.out.println("Test getEasyLevel Pass");
        }catch (AssertionError e){
            System.out.println("Test getEasyLevel Fail");
            throw e;
        }
    }

    @Test
    void isSetMusic() {
        try{
            assertTrue(user.isSetMusic());
            System.out.println("Test isSetMusic Pass");
        }catch (AssertionError e){
            System.out.println("Test isSetMusic Fail");
            throw e;
        }
    }

    @Test
    void setSetMusic() {
        boolean setMusic = false;
        try{
            user.setSetMusic(setMusic);
            assertFalse(user.isSetMusic());
            System.out.println("Test setSetMusic Pass");
        }catch (AssertionError e){
            System.out.println("Test setSetMusic Fail");
            throw e;
        }
    }

    @Test
    void isSetSound() {
        try{
            assertTrue(user.isSetSound());
            System.out.println("Test isSetSound Pass");
        }catch (AssertionError e){
            System.out.println("Test isSetSound Fail");
            throw e;
        }
    }

    @Test
    void setSetSound() {
        boolean setSound = false;
        try{
            user.setSetSound(setSound);
            assertFalse(user.isSetSound());
            System.out.println("Test setSetSound Pass");
        }catch (AssertionError e){
            System.out.println("Test setSetSound Fail");
            throw e;
        }
    }

    @Test
    void isSetNotification() {
        try{
            assertTrue(user.isSetNotification());
            System.out.println("Test isSetNotification Pass");
        }catch (AssertionError e){
            System.out.println("Test isSetNotification Fail");
            throw e;
        }
    }

    @Test
    void setSetNotification() {
        boolean setNotification = false;
        try{
            user.setSetNotification(setNotification);
            assertFalse(user.isSetNotification());
            System.out.println("Test setSetNotification Pass");
        }catch (AssertionError e){
            System.out.println("Test setSetNotification Fail");
            throw e;
        }
    }

    @Test
    void setEasyLevel() {
        int easyLevel = 2;
        try{
            user.setEasyLevel(easyLevel);
            assertEquals(easyLevel, user.getEasyLevel());
            System.out.println("Test setEasyLevel Pass");
        }catch (AssertionError e){
            System.out.println("Test setEasyLevel Fail");
            throw e;
        }
    }

    @Test
    void getMediumLevel() {
        try{
            assertEquals(1, user.getMediumLevel());
            System.out.println("Test getMediumLevel Pass");
        }catch (AssertionError e){
            System.out.println("Test getMediumLevel Fail");
            throw e;
        }
    }

    @Test
    void setMediumLevel() {
        int mediumLevel = 2;
        try{
            user.setMediumLevel(mediumLevel);
            assertEquals(mediumLevel, user.getMediumLevel());
            System.out.println("Test setMediumLevel Pass");
        }catch (AssertionError e){
            System.out.println("Test setMediumLevel Fail");
            throw e;
        }
    }

    @Test
    void getHardLevel() {
        try{
            assertEquals(1, user.getHardLevel());
            System.out.println("Test getHardLevel Pass");
        }catch (AssertionError e){
            System.out.println("Test getHardLevel Fail");
            throw e;
        }
    }

    @Test
    void setHardLevel() {
        int hardLevel = 2;
        try{
            user.setHardLevel(hardLevel);
            assertEquals(hardLevel, user.getHardLevel());
            System.out.println("Test setHardLevel Pass");
        }catch (AssertionError e){
            System.out.println("Test setHardLevel Fail");
            throw e;
        }
    }

    @Test
    void getRecords() {
        try{
            assertNotNull(user.getRecords());
            assertTrue(user.getRecords().isEmpty());
            System.out.println("Test getRecords Pass");
        }catch (AssertionError e){
            System.out.println("Test getRecords Fail");
            throw e;
        }
    }

    @Test
    void setRecords() {
        List<Record> records = new ArrayList<>();
        records.add(new Record("1:23", 2, 2, 20));
        records.add(new Record("2:34", 3, 3, 30));
        user.setRecords(records);
        try{
            assertNotNull(user.getRecords());
            assertEquals(2, user.getRecords().size());
            System.out.println("Test setRecords Pass");
        }catch (AssertionError e){
            System.out.println("Test setRecords Fail");
            throw e;
        }
    }
}