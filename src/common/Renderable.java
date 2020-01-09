package common;

import javafx.scene.canvas.GraphicsContext;

/**
 * Interface for all objects that need to be rendered to the screen.
 */
public interface Renderable {

    /**
     * Render object to given {@link GraphicsContext}.
     * @param gc {@link GraphicsContext} being rendered to.
     */
    void render(GraphicsContext gc);

}
