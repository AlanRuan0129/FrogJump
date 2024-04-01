package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MathQuestionUtils {
    public static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

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

    public static int generateMaxNumber(int level) {
        return (int) Math.pow(10, level / 3 + 1) * level;
    }

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

    private static int precedence(String c) {
        if (c.equals("+") || c.equals("-")) {
            return 1;
        } else if (c.equals("*") || c.equals("/")) {
            return 2;
        } else {
            return 0;
        }
    }

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

    public static String[] generateAnswer(String question) {
        List<String> postfix = infixToPostfix(question);

        return evaluatePostfix(postfix);
    }


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
