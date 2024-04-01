package game;

import entity.*;
import model.RecordModel;
import utils.ImageBufferUtils;
import utils.LocalStorage;
import utils.MusicUtils;
import view.CompletePage;
import view.InCompletePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameCenterPanel extends JPanel implements MouseListener {

    private final GameSystem gameSystem;
    private final Frog frog;
    private final Leaf[] leaves = new Leaf[14];

    public GameCenterPanel(GameSystem gameSystem) {
        setPreferredSize(new Dimension(800, 600));
        this.gameSystem = gameSystem;
        setBackground(Color.WHITE);
        initLeaves();
        frog = new Frog(320, 400, 60, 60,
                ImageBufferUtils.getImageIcon(ImageBufferUtils.FROG).getImage());

        addMouseListener(this);
    }

    private void initLeaves() {
        int hardLevel = gameSystem.getHardLevel();
        int level = gameSystem.getLevel();
        // indexY == 1
        Leaf l = new Leaf(60, 320, 1, hardLevel, level);
        leaves[0] = l;
        l = new Leaf(240, 320, 1, hardLevel, level);
        leaves[1] = l;
        l = new Leaf(420, 320, 1, hardLevel, level);
        leaves[2] = l;
        l = new Leaf(600, 320, 1, hardLevel, level);
        leaves[3] = l;
        // indexY == 2
        l = new Leaf(150, 240, 2, hardLevel, level);
        leaves[4] = l;
        l = new Leaf(330, 240, 2, hardLevel, level);
        leaves[5] = l;
        l = new Leaf(510, 240, 2, hardLevel, level);
        leaves[6] = l;
        // indexY == 3
        l = new Leaf(60, 160, 3, hardLevel, level);
        leaves[7] = l;
        l = new Leaf(240, 160, 3, hardLevel, level);
        leaves[8] = l;
        l = new Leaf(420, 160, 3, hardLevel, level);
        leaves[9] = l;
        l = new Leaf(600, 160, 3, hardLevel, level);
        leaves[10] = l;
        // indexY == 4
        l = new Leaf(150, 80, 4, hardLevel, level);
        leaves[11] = l;
        l = new Leaf(330, 80, 4, hardLevel, level);
        leaves[12] = l;
        l = new Leaf(510, 80, 4, hardLevel, level);
        leaves[13] = l;

        for (Leaf leaf : leaves) {
            leaf.setQuestionPage(gameSystem);
        }

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawLine(g);
        drawBackground(g);
        drawGrass(g);

        for (Leaf leaf : leaves) {
            leaf.draw(g);
        }

        frog.draw(g);
    }


    private void drawBackground(Graphics g) {
        ImageIcon riverIcon = ImageBufferUtils.getImageIcon(ImageBufferUtils.RIVER);
        Image riverImage = riverIcon.getImage();
        g.drawImage(riverImage, 0, 100, 400, 20, null);
        g.drawImage(riverImage, 380, 100, 400, 20, null);
        g.drawImage(riverImage, 0, 150, 400, 20, null);
        g.drawImage(riverImage, 380, 150, 400, 20, null);
        g.drawImage(riverImage, 0, 200, 400, 20, null);
        g.drawImage(riverImage, 380, 200, 400, 20, null);
        g.drawImage(riverImage, 0, 250, 400, 20, null);
        g.drawImage(riverImage, 380, 250, 400, 20, null);
        g.drawImage(riverImage, 0, 300, 400, 20, null);
        g.drawImage(riverImage, 380, 300, 400, 20, null);
        g.drawImage(riverImage, 0, 350, 400, 20, null);
        g.drawImage(riverImage, 380, 350, 400, 20, null);
    }

    private void drawLine(Graphics g) {
        Image lineImage = ImageBufferUtils.getImageIcon(ImageBufferUtils.LINE).getImage();
        g.drawImage(lineImage, 0, 50, 780, 10, null);
        g.drawImage(lineImage, 0, 70, 780, 10, null);
    }

    private void drawGrass(Graphics g) {
        ImageIcon grassIcon = ImageBufferUtils.getImageIcon(ImageBufferUtils.GRASS);
        Image grassImage = grassIcon.getImage();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 3; j++) {
                g.drawImage(grassImage, i * 40, j * 40 + 390, 40, 40, null);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
        if (user.isSetSound()) {
            MusicUtils.playSound("sound");
        }
        int x = e.getX();
        int y = e.getY();

        for (Leaf leaf : leaves) {
            if (leaf.inRange(x, y)) {
                if (!frog.setLeaf(leaf)) {
                    user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
                    if (user.isSetNotification()) {
                        MusicUtils.playSound("notification");
                    }
                    JOptionPane.showMessageDialog(this, "You can only jump to the leaf in the row below.");
                    return;

                }
                leaf.showQuestion();
                startLeafThread(leaf);
                break;
            }
        }
    }

    private void startLeafThread(Leaf leaf) {
        new Thread(() -> {
            while (leaf.getStatus() == Leaf.Status.UNTOUCHED) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            if (frog.getLeaf().getIndexY() == 4) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                frame.dispose();
                if (leaf.getStatus() == Leaf.Status.CORRECT) {
                    leaf.hideQuestion();
                    gameSystem.getTimeSystem().stop();
                    RecordModel.saveRecord(gameSystem.getHardLevel(), gameSystem.getLevel(), gameSystem.getScore(), Leaf.Status.CORRECT);
                    new CompletePage(gameSystem.getScore()).setVisible(true);

                } else {
                    new InCompletePage(gameSystem.getScore()).setVisible(true);
                    RecordModel.saveRecord(gameSystem.getHardLevel(), gameSystem.getLevel(), gameSystem.getScore(), Leaf.Status.WRONG);

                }
            }
            repaint();
        }).start();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
