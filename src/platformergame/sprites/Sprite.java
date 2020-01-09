package platformergame.sprites;

import common.Updatable;
import javafx.scene.shape.Rectangle;

/**
 * Represents all moving elements in the game.
 */
public abstract class Sprite implements Updatable {

    // dimensions and location of sprite.
    private double x, y, width, height;

    // the velocity components of the sprite.
    private double velX = 0;
    private double velY = 0;

    // the bounding rectangle of the sprite.
    private Rectangle bounds;

    public Sprite(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.bounds = new Rectangle(x, y, width, height);
    }

    /**
     * Change the position of the sprite according to the velocity.
     * @param elapsed Time since last update in milliseconds.
     */
    @Override
    public void tick(double elapsed) {
        this.setX(this.getX() + this.getVelX() * elapsed / 1000.0);
        this.setY(this.getY() + this.getVelY() * elapsed / 1000.0);
    }

    /**
     * Getter for x.
     * @return x coordinate of sprite.
     */
    public double getX() {
        return x;
    }

    /**
     * Setter for x.
     * @param x x coordinate of sprite.
     */
    public void setX(double x) {
        this.x = x;
        bounds.setX(x);
    }

    /**
     * Getter for y.
     * @return y coordinate of sprite.
     */
    public double getY() {
        return y;
    }

    /**
     * Setter for y.
     * @param y y coordinate of sprite.
     */
    public void setY(double y) {
        this.y = y;
        bounds.setY(y);
    }

    /**
     * Getter for width.
     * @return width of the sprite.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Setter for width.
     * @param width width of the sprite.
     */
    public void setWidth(double width) {
        this.width = width;
        bounds.setWidth(width);
    }

    /**
     * Getter for height.
     * @return height of the sprite.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Setter for height.
     * @param height height of the sprite.
     */
    public void setHeight(double height) {
        this.height = height;
        bounds.setHeight(height);
    }

    /**
     * Getter for velY.
     * @return vertical velocity of the sprite.
     */
    public double getVelY() {
        return velY;
    }

    /**
     * Setter for velY.
     * @param velY vertical velocity of the sprite.
     */
    public void setVelY(double velY) {
        this.velY = velY;
    }

    /**
     * Getter for velX.
     * @return horizontal velocity of the sprite.
     */
    public double getVelX() {
        return velX;
    }

    /**
     * Setter for velX.
     * @param velX horizontal velocity of the sprite.
     */
    public void setVelX(double velX) {
        this.velX = velX;
    }

    /**
     * Getter for bounds.
     * @return Bounding rectangle of sprite for collisions.
     */
    public Rectangle getBounds() {
        return this.bounds;
    }
}
