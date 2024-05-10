package modelTest;

import entity.DataObject;
import model.UserModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.LocalStorage;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserModelTest {

    @BeforeEach
    void setUp() {
        DataObject dataObject = new DataObject();
        dataObject.setUsers(new ArrayList<>());
        LocalStorage.save(LocalStorage.DATA, dataObject);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void register() {
        boolean firstReg = UserModel.register("testUsername", "testPassword");
        boolean secondReg = UserModel.register("testUsername", "testPassword2");
        try{
            assertTrue(firstReg);
            assertFalse(secondReg);
            DataObject dataObject = LocalStorage.get(LocalStorage.DATA, DataObject.class);
            assertNotNull(dataObject);
            assertEquals(1, dataObject.getUsers().size());
            System.out.println("Test register Pass");
        }catch (AssertionError e){
            System.out.println("Test register Fail");
            throw e;
        }

    }

    @Test
    void login() {
        UserModel.register("testUsername", "testPassword");
        boolean loginSuccess = UserModel.login("testUsername", "testPassword");
        boolean usernameWrong = UserModel.login("123", "testPassword");
        boolean passwordWrong = UserModel.login("testUsername", "123");
        try{
            assertTrue(loginSuccess);
            assertFalse(usernameWrong);
            assertFalse(passwordWrong);
            System.out.println("Test login Pass");
        }catch (AssertionError e){
            System.out.println("Test login Fail");
            throw e;
        }
    }
}