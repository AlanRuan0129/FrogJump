package entity;

import utils.MathQuestionUtils;


/**
 * Represent the math question in the game with difficulty level, answer and solution as well as
 * the number of chance a play has to solve
 * <p>
 * This class using {@code MathQuestionUtils} to generate questions base on specific level of difficulty.
 * @ author rwang828
 * @ version 1.0
 * @since 2024 - 03 - 29
 */
public class Question {

    /**
     * Instruction message for player when they play the game
     */
    public static final String HIT = "Hint:3 chance for a question!\n" +
            "First Chance Correct:10 points\n" +
            "Second Chance Correct 5 points\n" +
            "Third Chance Correct:3 points\n" +
            "More than three chances no challenge,will look at the solution";
    private final int hardLevel;
    private final int level;
    private String question;
    private String answer;
    private String solution;
    private int chance = 3;


    /**
     * Construct a new Question object
     * @param hardLevel the difficulty level of the question(easy, medium and hard)
     * @param level the game level, each level of difficulty may have 9 different levels.
     */
    public Question(int hardLevel, int level) {
        this.hardLevel = hardLevel;
        this.level = level;
    }

    /**
     * Generate a new question with its answer and solution.
     * Utilize {@code MathQuestionUtils} for generation.
     */
    public void generateNewQuestion() {
        this.question = MathQuestionUtils.generateQuestion(this.hardLevel, this.level);
        String[] answer = MathQuestionUtils.generateAnswer(this.question);
        this.answer = answer[0];
        this.solution = answer[1];
    }


    /**
     * Get the answer of current question
     * @return the {@code String} representation of the answer of current question.
     */
    public String getAnswer() {
        return answer;
    }


    /**
     * Get the solution of current question
     * @return the {@code String} representation of the solution of current question
     */
    public String getSolution() {
        return solution;
    }


    /**
     * Get the content of current question
     * @return  the {@code String} representation of content of current question
     */
    public String getQuestion() {
        return question;
    }


    /**
     * Get number of chance left to answer question correctly
     * @return the {@code int} representation of the number of remaining chance.
     */
    public int getChance() {
        return chance;
    }


    /**
     * Decrease the number of chance by 1 when player does not answer question correctly.
     */
    public void reduceChance() {
        this.chance--;
    }

}

