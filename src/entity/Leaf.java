package entity;

import game.GameSystem;
import utils.ImageBufferUtils;
import view.QuestionPage;

import java.awt.*;

public class Leaf extends GameObject {
    public int getIndexY() {
        return indexY;
    }

    public enum Status {
        UNTOUCHED,
        CORRECT,
        WRONG

    }

    private Question question;
    private Status status = Status.UNTOUCHED;
    private int indexY;
    private QuestionPage questionPage;


    public Leaf(int x, int y, int indexY, int hardLevel, int level) {
        super(x, y, 80, 80, ImageBufferUtils.getImageIcon(ImageBufferUtils.LEAF).getImage());
        question = new Question(hardLevel, level);
        question.generateNewQuestion();
        this.indexY = indexY;
    }

    public void setQuestionPage(GameSystem gameSystem) {
        this.questionPage = new QuestionPage(this,gameSystem);
    }

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

    public Leaf() {
    }


    public Question getQuestion() {
        return question;
    }

    public void generateNewQuestion() {
        question.generateNewQuestion();
    }

    public void showQuestion() {
        questionPage.setVisible(true);
    }

    public void hideQuestion() {
        questionPage.setVisible(false);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
