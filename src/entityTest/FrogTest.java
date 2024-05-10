package entityTest;

import entity.Frog;
import entity.Leaf;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrogTest {
    private Frog frog;
    private Leaf leaf1, leaf2;
    @BeforeEach
    void setUp() {
        frog = new Frog(0,0,10,10,null);
        leaf1 = new Leaf(100, 100, 1, 1, 1);
        leaf2 = new Leaf(100, 150, 2, 1, 1);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setLeaf() {
        try{
            assertTrue(frog.setLeaf(leaf1));
            assertTrue(frog.setLeaf(leaf2));
            assertFalse(frog.setLeaf(new Leaf(100, 200,10,0,0)));
            System.out.println("Test setLeaf Pass");
        }catch (AssertionError e){
            System.out.println("Test setLeaf Fail");
            throw e;
        }
    }

    @Test
    void getLeaf() {
        try{
            assertNull(frog.getLeaf());
            frog.setLeaf(leaf1);
            assertEquals(leaf1, frog.getLeaf());
            System.out.println("Test getLeaf Pass");
        }catch (AssertionError e){
            System.out.println("Test getLeaf Fail");
            throw e;
        }
    }

    @Test
    void draw() {
    }
}