package entity;

import java.awt.*;

public class Frog extends GameObject {
    private Leaf leaf;

    public Frog(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
    }

    public boolean setLeaf(Leaf leaf) {
        if (this.leaf != null && this.leaf.getIndexY() != leaf.getIndexY() - 1) {
            return false;
        }
        if (this.leaf == null && leaf.getIndexY() != 1) {
            return false;
        }
        this.leaf = leaf;
        return true;

    }

    public Leaf getLeaf() {
        return leaf;
    }

    @Override
    public void draw(Graphics g) {
        if (leaf != null) {
            this.setX(leaf.getX() + (leaf.getWidth() - this.getWidth()) / 2);
            this.setY(leaf.getY() + (leaf.getHeight() - this.getHeight()) / 2);
        }

        super.draw(g);
    }
}
