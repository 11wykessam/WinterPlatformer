package platformergame.collisions;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

/**
 * Represents the floor of the game.
 */
public class Floor implements Collidable {

    // the height of the screen.
    private double screenHeight;

    public Floor(double screenHeight) {
        this.screenHeight = screenHeight;
    }

    /**
     * Checks if the given {@link Rectangle} collides with the floor.
     * @param rectangle {@link Rectangle} object collisions are being checked for with.
     * @return
     */
    @Override
    public boolean collides(Rectangle rectangle) {

        return (rectangle.getY() + rectangle.getHeight() > screenHeight);

    }
}
