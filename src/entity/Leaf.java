package entity;

import game.GameSystem;
import utils.ImageBufferUtils;
import view.QuestionPage;

import java.awt.*;


/**
 * Represent a leaf object in the game, encapsulate the question logic and visual representation
 * Each leaf can have a status indicating whether it has been interacted with,
 * if so whether the interaction was correct or incorrect.
 * It is associated with a question and can display question on a question page
 * @ author rwang828
 * @ version 1.0
 * @since 2024 - 03 - 29
 */
public class Leaf extends GameObject {
    public int getIndexY() {
        return indexY;
    }

    /**
     * Status of the leaf indicating whether it has been interacted with
     * and result of that interaction
     */
    public enum Status {
        UNTOUCHED, // Leaf has not been interacted with.
        CORRECT, // Leaf was interacted with correctly
        WRONG // Leaf was interacted with incorrectly

    }

    private Question question;
    private Status status = Status.UNTOUCHED;
    private int indexY;
    private QuestionPage questionPage;


    /**
     * Construct a {@code Leaf} object with specific coordinates, index, difficulty level and game level
     * Initialize the associated question and sets the leaf image
     * @param x the x-coordinate of the leaf
     * @param y the y-coordinate
     * @param indexY the vertical index of the leaf
     * @param hardLevel the difficulty level of the question
     * @param level the game level
     */
    public Leaf(int x, int y, int indexY, int hardLevel, int level) {
        super(x, y, 80, 80, ImageBufferUtils.getImageIcon(ImageBufferUtils.LEAF).getImage());
        question = new Question(hardLevel, level);
        question.generateNewQuestion();
        this.indexY = indexY;
    }

    /**
     * Set the question page associated with the leaf.
     * @param gameSystem
     */
    public void setQuestionPage(GameSystem gameSystem) {
        this.questionPage = new QuestionPage(this,gameSystem);
    }

    /**
     * Draw the leaf on the screen, changing its appearance based on its status
     * @param g the {@link Graphics} context used for drawing
     */
    @Override
    public void draw(Graphics g) {
        if (status == Status.CORRECT) {
            setImage(ImageBufferUtils.getImageIcon(ImageBufferUtils.LEAF1).getImage());
        } else if (status == Status.WRONG) {
            setImage(ImageBufferUtils.getImageIcon(ImageBufferUtils.LEAF2).getImage());
        } else {
            setImage(ImageBufferUtils.getImageIcon(ImageBufferUtils.LEAF).getImage());
        }
        super.draw(g);
    }

    /**
     * The default constructor
     */
    public Leaf() {
    }

    /**
     * Reverse the question associated with this leaf
     * @return the current question object associated with this leaf.
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Generate a new question for the leaf based on its current difficulty level
     */
    public void generateNewQuestion() {
        question.generateNewQuestion();
    }

    /**
     * Shows the question associated with this leaf on the question page.
     */
    public void showQuestion() {
        questionPage.setVisible(true);
    }

    /**
     * Hides the question page associated with this leaf.
     */
    public void hideQuestion() {
        questionPage.setVisible(false);
    }

    /**
     * Get the current status of the leaf
     * @return The current status of the leaf, indicating if it has been touched,
     *         and if so, whether the interaction was correct or wrong.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Set the status of the leaf
     * @param status the new status for the leaf, reflecting the outcome of the interaction
     */
    public void setStatus(Status status) {
        this.status = status;
    }

}
