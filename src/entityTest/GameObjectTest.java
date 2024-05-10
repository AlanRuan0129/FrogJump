package entityTest;

import entity.GameObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GameObjectTest {

    private GameObject gameObject;
    private final int initialX = 10;
    private final int initialY = 20;
    private final int width = 100;
    private final int height = 200;
    @BeforeEach
    void setUp() {
        gameObject = new GameObject(initialX, initialY, width, height, null){
            public void draw(Graphics g){

            }
        };
    }

    @AfterEach
    void tearDown() {
        gameObject = null;
    }

    @Test
    void getX() {
        try{
            assertEquals(initialX, gameObject.getX());
            System.out.println("Test getX Pass");
        }catch (AssertionError e){
            System.out.println("Test getX Fail");
            throw e;
        }
    }

    @Test
    void setX() {
        try{
            int x = 100;
            gameObject.setX(x);
            assertEquals(x, gameObject.getX());
            System.out.println("Test setX Pass");
        }catch (AssertionError e){
            System.out.println("Test setX Fail");
            throw e;
        }

    }

    @Test
    void getY() {
        try{
            assertEquals(initialY,gameObject.getY());
            System.out.println("Test getY Pass");
        }catch (AssertionError e){
            System.out.println("Test getY Fail");
            throw e;
        }
    }

    @Test
    void setY() {
        try{
            int y = 200;
            gameObject.setY(y);
            assertEquals(y, gameObject.getY());
            System.out.println("Test setY Pass");
        }catch (AssertionError e){
            System.out.println("Test setY Fail");
            throw e;
        }
    }

    @Test
    void getWidth() {
        try{
            assertEquals(width, gameObject.getWidth());
            System.out.println("Test getWidth Pass");
        }catch (AssertionError e){
            System.out.println("Test getWidth Fail");
            throw e;
        }
    }

    @Test
    void setWidth() {
        try{
            int newWidth = 1000;
            gameObject.setWidth(newWidth);
            System.out.println("Test setWidth Pass");
        }catch (AssertionError e){
            System.out.println("Test setWidth Fail");
            throw e;
        }
    }

    @Test
    void getHeight() {
        try{
            assertEquals(height, gameObject.getHeight());
            System.out.println("Test getHeight Pass");
        }catch (AssertionError e){
            System.out.println("Test getHeight Fail");
            throw e;
        }
    }

    @Test
    void setHeight() {
        try{
            int newHeight = 2000;
            gameObject.setHeight(newHeight);
            assertEquals(newHeight, gameObject.getHeight());
            System.out.println("Test setHeight Pass");
        }catch (AssertionError e){
            System.out.println("Test setHeight Fail");
            throw e;
        }
    }

    @Test
    void getImage() {
    }

    @Test
    void setImage() {
    }

    @Test
    void draw() {
    }
    @Test
    void inRange() {
        try{
            assertTrue(gameObject.inRange(initialX + 1, initialY + 1));
            assertFalse(gameObject.inRange(initialX - 1, initialY));
            assertFalse(gameObject.inRange(initialX, initialY - 1));
            assertFalse(gameObject.inRange(initialX - 1, initialY - 1));
            assertFalse(gameObject.inRange(initialX + width + 1, initialY));
            assertFalse(gameObject.inRange(initialX, initialY + height + 1));
            assertFalse(gameObject.inRange(initialX + width + 1, initialY + height + 1));
            System.out.println("Test inRange Pass");
        }catch (AssertionError e){
            System.out.println("Test inRange Fail");
            throw e;
        }
    }
}