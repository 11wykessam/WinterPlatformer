package animation;

import common.Game;
import javafx.scene.canvas.GraphicsContext;

/**
 * A simple class for animating a game.
 */
public class AnimationThread extends Thread {

    // the frames per second the thread will animate at.
    private double FPS;

    // the game being animated.
    private Game game;

    // the graphics context being animated to.
    private GraphicsContext gc;

    public AnimationThread(Game game, double FPS, GraphicsContext gc) {
        this.game = game;
        this.FPS = FPS;
        this.gc = gc;
        // set thread to close when program is closed.
        this.setDaemon(true);
    }

    /**
     * Called when the thread is started.
     */
    @Override
    public void run() {

        // calculate the delay between frames.
        double delay = 1.0 / FPS * 1000;
        double lastUpdate = System.currentTimeMillis();

        // animate until program is closed or thread is stopped.
        while (true) {
            // only animate if time according to delay has elapsed.
            if (System.currentTimeMillis() - lastUpdate > delay) {
                game.render(gc);
                lastUpdate = System.currentTimeMillis();
            }
        }
    }


}
