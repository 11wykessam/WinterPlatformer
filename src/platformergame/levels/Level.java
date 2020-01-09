package platformergame.levels;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import common.Renderable;
import javafx.scene.canvas.GraphicsContext;
import platformergame.collisions.Collidable;
import platformergame.collisions.Floor;

import java.util.ArrayList;

/**
 * Represents levels in a platformer game.
 */
public abstract class Level implements Renderable {

    // the context the level is being rendered to.
    private GraphicsContext gc;

    // stores the collidable objects in the level.
    private ArrayList<Collidable> collidables = new ArrayList<>();

    // stores the floor of the level.
    private Floor floor;

    public Level(GraphicsContext gc) {
        this.gc = gc;
        this.floor = new Floor(gc.getCanvas().getHeight());
    }

    /**
     * Render the level.
     * @param gc {@link GraphicsContext} being rendered to.
     */
    @Override
    public void render(GraphicsContext gc) {
        for (Collidable collidable : collidables) collidable.render(gc);
    }

    /**
     * Getter for floor.
     * @return {@link Floor} object of level.
     */
    public Floor getFloor() {
        return this.floor;
    }

    /**
     * Getter for collidables.
     * @return List of {@link Collidable} objects.
     */
    public ArrayList<Collidable> getCollidables() {
        return this.collidables;
    }

    /**
     * Add a collidable object to the list.
     * @param collidable {@link Collidable} object.
     */
    public void addCollidable(Collidable collidable) {
        collidables.add(collidable);
    }
}
