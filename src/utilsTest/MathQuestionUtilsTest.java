package utilsTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.MathQuestionUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MathQuestionUtilsTest {

    @BeforeEach
    void setUp() {
        System.out.println("setUp()");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown()");
    }

    @Test
    void generateRandomNumber() {
        int min = 1;
        int max = 10;
        int randomNumber = MathQuestionUtils.generateRandomNumber(min, max);
        assertTrue(randomNumber >= min && randomNumber <= max, "Generated number should be within the specified range.");
    }

    @Test
    void generateRandomOperator() {
        String operator = MathQuestionUtils.generateRandomOperator(2); // Levels 0 to 2 include +, -, *, /
        assertTrue(Arrays.asList(" + ", " - ", " * ", " / ").contains(operator), "Operator should be one of the expected values.");
    }

    @Test
    void generateMaxNumber() {
        int level = 3;
        int maxNumber = MathQuestionUtils.generateMaxNumber(level);
        int expectedMax = (int) Math.pow(10, level / 3 + 1) * level;
        assertEquals(expectedMax, maxNumber, "The generated max number does not match the expected value for the given level.");
    }

    @Test
    void generateQuestion() {
        // Testing the question generation is tricky due to its randomness,
        // so we'll mainly check if it returns a non-empty string that ends with "= "
        String question = MathQuestionUtils.generateQuestion(1, 1);
        assertFalse(question.isEmpty(), "Generated question should not be empty.");
        assertTrue(question.endsWith(" = "), "Generated question should end with \" = \".");
    }

    @Test
    void infixToPostfix() {
        List<String> expectedPostfix = Arrays.asList("3", "4", "2", "*", "+");
        List<String> actualPostfix = MathQuestionUtils.infixToPostfix("3 + 4 * 2 = ");
        assertEquals(expectedPostfix, actualPostfix, "The conversion from infix to postfix did not produce the expected result.");
    }

    @Test
    void evaluatePostfix() {
        List<String> postfixExpression = Arrays.asList("3", "4", "2", "*", "+");
        String[] result = MathQuestionUtils.evaluatePostfix(postfixExpression);
        assertEquals("11.0", result[0], "Postfix expression evaluation did not produce the expected result.");
        assertNotNull(result[1], "The solution explanation should not be null.");
    }

    @Test
    void generateAnswer() {
        // This test is slightly artificial because we know the answer to the specific question
        // "3 + 4 * 2 = " should be 11 based on standard order of operations
        String question = "3 + 4 * 2 = ";
        String[] answer = MathQuestionUtils.generateAnswer(question);
        assertEquals("11.0", answer[0], "The generated answer should be correct.");
        assertTrue(answer[1].contains("Solution:"), "The answer should include a solution explanation.");
    }
}