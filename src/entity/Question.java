package entity;

import utils.MathQuestionUtils;

public class Question {
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


    public Question(int hardLevel, int level) {
        this.hardLevel = hardLevel;
        this.level = level;
    }

    public void generateNewQuestion() {
        this.question = MathQuestionUtils.generateQuestion(this.hardLevel, this.level);
        String[] answer = MathQuestionUtils.generateAnswer(this.question);
        this.answer = answer[0];
        this.solution = answer[1];
    }

    public String getAnswer() {
        return answer;
    }

    public String getSolution() {
        return solution;
    }

    public String getQuestion() {
        return question;
    }

    public int getChance() {
        return chance;
    }

    public void reduceChance() {
        this.chance--;
    }
}
