package entity;

import java.awt.*;

/**
 * Represent an abstract base for game object.
 * This class encapsulates the common properties and functionality such as position, size and image.
 * @ author rwang828
 * @ version 1.0
 * @since 2024 - 03 - 29
 */
public abstract class GameObject {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;

    /**
     * Construct a new {@code GameoObject} with default properties
     */
    public GameObject() {
    }


    /**
     * Construct a new {@code GameObject} with specific location, size and image.
     *
     * @param x the initial x-coordinate of the game object
     * @param y the initial y-coordinate of the game object
     * @param width the width of the game object
     * @param height the height of the game object
     * @param image the image of the game object
     */
    public GameObject(int x, int y, int width, int height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }


    /**
     * Get the x-coordinate of the game object
     * @return the x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Set the x-coordinate of the game object
     * @param x the new x-coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get the y-coordinate of the game object
     * @return the y-coordinate
     */
    public int getY() {
        return y;
    }


    /**
     * Set the y-coordinate of the game object
     * @param y the new y-coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get the width of the game object
     * @return the width of the game object
     */
    public int getWidth() {
        return width;
    }


    /**
     * Set the width of the game object
     * @param width the new width of the game object
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Get the height of the game object
     * @return the height of the game object
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set the height of the game object
     * @param height the new height of the game object
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Get the image of the game object
     * @return the image of the game object
     */
    public Image getImage() {
        return image;
    }

    /**
     * Set the image of the game object
     * @param image the new image of the game object
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Draw the game object at its current location with its specific size
     * @param g the {@link Graphics} context used for drawing
     */
    public void draw(Graphics g){
        g.drawImage(image,x,y,width,height,null);
    };

    /**
     * Determine if a point is out of bound or not.
     * @param x the x-coordinate of the point to check
     * @param y the y-coordinate of the point to check
     * @return {@code true} if the point within the bounds of this game object
     *         {@code false} otherwise
     */
    public boolean inRange(int x, int y){
        return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height;
    }
}
