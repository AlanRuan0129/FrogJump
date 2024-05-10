package entityTest;

import entity.DataObject;
import entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataObjectTest {

    private DataObject dataObject;
    private boolean testPassed;
    @BeforeEach
    void setUp() {
        dataObject = new DataObject();
        testPassed = true;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUsers(){
        try{
            assertTrue(dataObject.getUsers().isEmpty());
            List<User> expectedUser = new ArrayList<>();
            expectedUser.add(new User("TestUserName", "TestPassWord"));
            dataObject.setUsers(expectedUser);
            List<User> User = dataObject.getUsers();
            assertEquals(expectedUser, User);
            System.out.println("Test getUser Pass");
        }catch (AssertionError e){
            System.out.println("Test getUser Fail");
            throw e;
        }
    }

    @Test
    void setUsers() {
        try {
            List<User> usersToSet = new ArrayList<>();
            User user = new User("TestUserName1", "TestPassword1");
            usersToSet.add(user);
            dataObject.setUsers(usersToSet);
            assertFalse(dataObject.getUsers().isEmpty());
            assertSame(user, dataObject.getUsers().get(0));
            System.out.println("Test setUser Pass.");
        } catch (AssertionError e) {
            System.out.println("Test setUser Fail.");
            throw e;
        }
    }

}