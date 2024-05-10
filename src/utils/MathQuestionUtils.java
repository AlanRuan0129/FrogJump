package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * The {@code MathQuestionUtils} class provides utility methods for generating mathematical
 * questions and their solutions. It supports creating questions with varying levels of
 * difficulty and complexity based on the specified parameters.
 * @author Jingpeng Ruan
 * @version 1.0
 * @since 2024/3/31
 */
public class MathQuestionUtils {

    /**
     * Generates a random number within a specified range.
     *
     * @param min The minimum value (inclusive) of the generated number.
     * @param max The maximum value (inclusive) of the generated number.
     * @return An integer between {@code min} and {@code max}, inclusive.
     */
    public static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    /**
     * Generates a random operator based on the difficulty level. The difficulty level
     * influences the types of operators generated, allowing for more complex operations
     * at higher levels.
     *
     * @param hardLevel The difficulty level of the question. Higher values allow for more
     *                  complex operators.
     * @return A string representation of the operator.
     */
    public static String generateRandomOperator(int hardLevel) {
        int random = (int) (Math.random() * (1 + hardLevel));
        switch (random) {
            case 0:
                return " + ";
            case 1:
                return " - ";
            case 2:
                return " * ";
            case 3:
                return " / ";
        }
        return "";
    }

    /**
     * Generates the maximum number that can be used in a question based on the provided level.
     * The maximum number increases with the level to adjust the difficulty.
     *
     * @param level The level of the question, affecting the maximum number generated.
     * @return The maximum number allowed for use in the question.
     */
    public static int generateMaxNumber(int level) {
        return (int) Math.pow(10, level / 3 + 1) * level;
    }

    /**
     * Generates a mathematical question as a string. The complexity and number range
     * of the question are determined by the hardLevel and level parameters.
     *
     * @param hardLevel The difficulty level of the question, affecting the types of operations.
     * @param level     The overall level, influencing the range of numbers and the complexity.
     * @return A string representing a math question, ending with "= ".
     */
    public static String generateQuestion(int hardLevel, int level) {
        String question = "";

        String operator = "";
        for (int i = 0; i < hardLevel + level / 5; i++) {
            int number = 0;
            if (operator.equals(" * ")) {
                number = generateRandomNumber(1, 9);
            } else if (operator.equals(" / ")) {
                int r = generateRandomNumber(1, 2);
                if (r == 1) {
                    number = 2;
                } else {
                    number = 4;
                }
            } else {
                number = generateRandomNumber(1, generateMaxNumber(level));
            }
            operator = generateRandomOperator(hardLevel);
            question += number + operator;
        }


        if (operator.equals(" * ")) {
            question += generateRandomNumber(1, 9) + " = ";
        } else if (operator.equals(" / ")) {
            int r = generateRandomNumber(1, 2);
            if (r == 1) {
                question += 2 + " = ";
            } else {
                question += 4 + " = ";
            }
        } else {
            question += generateRandomNumber(1, generateMaxNumber(level)) + " = ";
        }

        return question;
    }

    /**
     * Returns the precedence level of the specified mathematical operator. This method
     * is useful in parsing mathematical expressions, particularly in converting from infix
     * to postfix notation, or when evaluating expressions where the order of operations
     * needs to be considered.
     *
     * @param c A string representing a mathematical operator. Expected values are "+", "-", "*", or "/".
     * @return An integer representing the precedence level of the operator, where higher numbers
     *         indicate higher precedence. Returns 0 for any input that is not a recognized operator.
     */
    private static int precedence(String c) {
        if (c.equals("+") || c.equals("-")) {
            return 1;
        } else if (c.equals("*") || c.equals("/")) {
            return 2;
        } else {
            return 0;
        }
    }

    /**
     * Converts an infix expression to a postfix expression to facilitate easier calculation.
     * This method is used internally to help evaluate the solution to a generated question.
     *
     * @param expression The infix mathematical expression as a string.
     * @return A list of strings representing the expression in postfix notation.
     */
    public static List<String> infixToPostfix(String expression) {
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        String[] tokens = expression.substring(0, expression.length() - 3).split(" ");

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    postfix.add(stack.pop());
                }
                stack.push(token);
            } else {
                postfix.add(token);
            }
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return postfix;
    }

    /**
     * Evaluates a postfix expression and returns the result along with a step-by-step
     * solution. This method is designed to provide both the answer to a question and
     * a detailed solution process.
     *
     * @param postfix A list of strings representing a postfix mathematical expression.
     * @return An array of strings, where the first element is the answer and the second
     *         element is a string detailing the solution steps.
     */
    public static String[] evaluatePostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();
        String solution = "Solution: \n";

        for (int i = 0; i < postfix.size(); i++) {
            String token = postfix.get(i);
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = 0;
                switch (token.charAt(0)) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                }
                solution += operand1 + " " + token + " " + operand2 + " = " + result + "\n";
                stack.push(result);
            } else {
                stack.push(Double.parseDouble(token));

            }
        }

        String answer = String.valueOf(stack.pop());
        return new String[]{answer, solution};

    }

    /**
     * Generates the answer to a given mathematical question. This method combines the
     * process of converting the question to postfix notation and then evaluating it
     * to produce both the final answer and a detailed solution.
     *
     * @param question The math question in infix notation as a string.
     * @return An array of strings, where the first element is the answer and the second
     *         element provides a detailed solution.
     */
    public static String[] generateAnswer(String question) {
        List<String> postfix = infixToPostfix(question);

        return evaluatePostfix(postfix);
    }

    /**
     * The main method to demonstrate the functionality of the {@code MathQuestionUtils}
     * class. It generates and prints math questions along with their answers and
     * step-by-step solutions.
     *
     * @param args Command-line arguments (not used).
     */

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            String question = generateQuestion(3, 9);
            String[] answer = generateAnswer(question);
            System.out.println(question);
            System.out.println(answer[0]);
            System.out.println(answer[1]);
        }
    }

}
