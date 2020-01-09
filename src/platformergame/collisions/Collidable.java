package platformergame.collisions;

import common.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

/**
 * Interface for all classes that can have collisions.
 */
public interface Collidable extends Renderable {

    /**
     * Checks if a given rectangle collides with the object.
     * @param rectangle {@link Rectangle} object collisions are being checked for with.
     * @return Boolean dependent on whether collision occurred.
     */
    boolean collides(Rectangle rectangle);

    /**
     * By default render nothing.
     * @param gc {@link GraphicsContext} being rendered to.
     */
    @Override
    default void render(GraphicsContext gc) {

    }
}
