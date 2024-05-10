package modelTest;

import entity.User;
import entity.Record;
import entity.Leaf;
import model.RecordModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.LocalStorage;

import static org.junit.jupiter.api.Assertions.*;

class RecordModelTest {

    private User testuser;
    private String Username = "TestUsername";
    private String Password = "Password";
    @BeforeEach
    void setUp() {
        testuser = new User(Username, Password);
        LocalStorage.save(LocalStorage.CURRENT_USER, testuser);
    }

    @AfterEach
    void tearDown() {
        LocalStorage.remove(LocalStorage.CURRENT_USER);
    }

    @Test
    void saveRecord() {
        try{
            RecordModel.saveRecord(1,1,100, Leaf.Status.CORRECT);
            User newUser = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
            assertNotNull(newUser);
            assertEquals(2, newUser.getEasyLevel());
            System.out.println("Test saveRecord Pass");
        }catch (AssertionError e){
            System.out.println("Test saveRecord Fail");
            throw e;
        }
    }

    @Test
    void getRecords() {
        try{
            RecordModel.saveRecord(1,1,100,Leaf.Status.CORRECT);
            User newUser = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
            assertFalse(newUser.getRecords().isEmpty());
            System.out.println("Test getRecords Pass");
        }catch (AssertionError e){
            System.out.println("Test getRecords Fail");
            throw e;
        }
    }
}