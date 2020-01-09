package platformergame.collisions;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import platformergame.sprites.Player;

/**
 * Represents a simple platform.
 */
public class Platform implements Collidable {

    // color of the platform (by default black).
    private Paint color = Color.BLACK;

    // dimensions and location of platform.
    private double x, y, width, height;
    // bounding rectangle of platform.
    private Rectangle bounds;

    public Platform(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.bounds = new Rectangle(x, y, width, height);
    }

    /**
     * Setter for color.
     * @param color color of platform.
     */
    public void setColor(Paint color) {
        this.color = color;
    }

    /**
     * Check if rectangle collides with this objects bounds.
     * @param rectangle {@link Rectangle} object collisions are being checked for with.
     * @return Boolean dependent on whether collision occurs.
     */
    @Override
    public boolean collides(Rectangle rectangle) {
        return bounds.intersects(rectangle.getBoundsInLocal());
    }

    /**
     * Render the platform.
     * @param gc {@link GraphicsContext} being rendered to.
     */
    @Override
    public void render(GraphicsContext gc) {

        // remember the fill.
        Paint prevFill = gc.getFill();
        gc.setFill(color);

        // paint the platform.
        gc.fillRect(x, y, width, height);

        // reset color.
        gc.setFill(prevFill);
    }
}
