package common;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

/**
 * Represents a game that can be updated and rendered.
 */
public abstract class Game implements Updatable, Renderable{

    /**
     * Updates the game.
     * @param elapsed Time elapsed since last update in milliseconds.
     */
    public abstract void tick(double elapsed);

    /**
     * Renders the game to a given context.
     * @param gc {@link GraphicsContext} object being rendered to.
     */
    public abstract void render(GraphicsContext gc);

    /**
     * Called when key is pressed within the game.
     * @param e {@link KeyEvent} object triggered.
     */
    public abstract void keyPressed(KeyEvent e);

    /**
     * Called when key is released within the game.
     * @param e {@link KeyEvent} object triggered.
     */
    public abstract void keyReleased(KeyEvent e);

}
