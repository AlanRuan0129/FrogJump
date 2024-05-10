package entityTest;

import entity.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    private Question question;
    @BeforeEach
    void setUp() {
        question = new Question(1,1);
        question.generateNewQuestion();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void generateNewQuestion() {
        try{
            assertNotNull(question.getQuestion());
            assertNotNull(question.getAnswer());
            assertNotNull((question.getSolution()));
            System.out.println("Test generateNewQuestion Pass");
        }catch (AssertionError e){
            System.out.println("Test generateNewQuestion Fail");
            throw e;
        }
    }

    @Test
    void getAnswer() {
        String answer = question.getAnswer();
        try{
            assertEquals(answer, question.getAnswer());
            System.out.println("Test getAnswer Pass");
        }catch (AssertionError e){
            System.out.println("Test getAnswer Fail");
            throw e;
        }
    }

    @Test
    void getSolution() {
        String solution = question.getSolution();
        try{
            assertEquals(solution, question.getSolution());
            System.out.println("Test getAnswer Pass");
        }catch (AssertionError e){
            System.out.println("Test getAnswer Fail");
            throw e;
        }
    }

    @Test
    void getQuestion() {
        String Q = question.getQuestion();
        try{
            assertEquals(Q, question.getQuestion());
            System.out.println("Test getQuestion Pass");
        }catch (AssertionError e){
            System.out.println("Test getQuestion Fail");
            throw e;
        }
    }

    @Test
    void getChance() {
        int chance = question.getChance();
        try{
            assertEquals(chance, question.getChance());
            System.out.println("Test getChance Pass");
        }catch (AssertionError e){
            System.out.println("Test getChance Fail");
            throw e;
        }
    }

    @Test
    void reduceChance() {
        int iniChance = question.getChance();
        question.reduceChance();
        try{
            assertEquals(iniChance - 1, question.getChance());
            System.out.println("Test reduceChance Pass");
        }catch (AssertionError e){
            System.out.println("Test reduceChance Fail");
            throw e;
        }
    }
}