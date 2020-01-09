package platformergame.levels;

import javafx.scene.canvas.GraphicsContext;
import platformergame.collisions.Platform;

/**
 * First level in the game.
 */
public class LevelOne extends Level {

    public LevelOne(GraphicsContext gc) {
        super(gc);

        // add a collidable object.
        Platform platformOne = new Platform(200, gc.getCanvas().getHeight() - 100, 50, 25);
        this.addCollidable(platformOne);
    }

}
