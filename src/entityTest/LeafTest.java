package entityTest;

import entity.Leaf;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeafTest {
    private Leaf leaf;
    private final int hardLevel = 1;
    private final int level = 1;
    private final int indexY = 2;
    @BeforeEach
    void setUp() {
        leaf = new Leaf (0, 0, indexY, hardLevel, level);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getIndexY() {
        try{
            assertEquals(indexY, leaf.getIndexY());
            System.out.println("Test getIndexY Pass");
        }catch (AssertionError e){
            System.out.println("Test getIndexY Fail");
            throw e;
        }
    }

    @Test
    void setQuestionPage() {
    }

    @Test
    void draw() {
    }

    @Test
    void getQuestion() {
        try{
            assertNotNull(leaf.getQuestion());
            System.out.println("Test getQuestion Pass");
        }catch (AssertionError e){
            System.out.println("Test getQuestion Fail");
            throw e;
        }
    }


    @Test
    void generateNewQuestion() {
        try{
            String oldQuestionAnswer = leaf.getQuestion().getSolution();
            leaf.generateNewQuestion();
            String newQuestionAnswer = leaf.getQuestion().getSolution();
            assertNotEquals(oldQuestionAnswer, newQuestionAnswer);
            System.out.println("Test generateQuestion Pass");
        }catch (AssertionError e){
            System.out.println("Test generateQuestion Fail");
            throw e;
        }
    }

    @Test
    void showQuestion() {
    }

    @Test
    void hideQuestion() {
    }

    @Test
    void getStatus() {
        try{
            assertEquals(Leaf.Status.UNTOUCHED, leaf.getStatus());
            System.out.println("Test getStatus Pass");
        }catch (AssertionError e){
            System.out.println("Test getStatus Fail");
            throw e;
        }
    }

    @Test
    void setStatus() {
        try{
            leaf.setStatus(Leaf.Status.CORRECT);
            assertEquals(Leaf.Status.CORRECT, leaf.getStatus());
            leaf.setStatus(Leaf.Status.WRONG);
            assertEquals(Leaf.Status.WRONG, leaf.getStatus());
            System.out.println("Test setStatus Pass");
        }catch (AssertionError e){
            System.out.println("Test setStatus Fail");
            throw e;
        }
    }
}