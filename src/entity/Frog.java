package entity;

import java.awt.*;


/**
 * The {@code Frog} class represent a frog object in the game that can be jump onto leaf
 * It extend {@code GameObject} to utilize common game object properties.
 * @ author rwang828
 * @ version 1.0
 * @since 2024 - 03 - 29
 */
public class Frog extends GameObject {
    private Leaf leaf;

    /**
     * Construct new {@code Frog} with specific location, size and its corresponding image.
     * @param x the initial x-coordinate of the frog
     * @param y the initial y-coordinate of the frog
     * @param width width of the frog
     * @param height height of the frog
     * @param image image of the frog
     */
    public Frog(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
    }

    /**
     * Set the leaf for the frog to jump on.
     * The frog can only jump to the leaf in sequence
     * (y-coordinate 1 unit higher than current, or first leaf if the frog does not on any leaf)
     * @param leaf the {@code Leaf} to set
     * @return {@code true} if the frog successfully jump to the next leaf
     *         {@code false} otherwise
     */
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

    /**
     * Get the current leaf that the frog on.
     * @return the current {@code Leaf} that the frog is on, or {@code null} if the frog is not on any leaf
     */
    public Leaf getLeaf() {
        return leaf;
    }

    /**
     * Draw the frog on current leaf and adjust its current position
     * It overrides the {@code draw} method in the {@code GameObject} class
     * @param g the {@code Graphics} object used for drawing
     */
    @Override
    public void draw(Graphics g) {
        if (leaf != null) {
            this.setX(leaf.getX() + (leaf.getWidth() - this.getWidth()) / 2);
            this.setY(leaf.getY() + (leaf.getHeight() - this.getHeight()) / 2);
        }

        super.draw(g);
    }
}
