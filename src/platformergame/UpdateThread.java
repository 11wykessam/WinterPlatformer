package platformergame;

import common.Game;
import common.Updatable;

/**
 * Keeps track of ticks in a {@link common.Game} object.
 */
public class UpdateThread extends Thread {

    // the game being updated.
    private Game game;

    // the number of ticks being performed per second.
    private double TPS;

    public UpdateThread(Game game, double TPS) {
        this.game = game;
        this.TPS = TPS;

        // make it so thread stops when progam is closed.
        this.setDaemon(true);
    }

    /**
     * Called when the thread is started.
     */
    @Override
    public void run() {

        // calculate time between updates.
        double delay = 1.0/TPS * 1000.0;
        double lastUpdate = System.currentTimeMillis();

        // tick until program closes.
        while (true) {
            // only update when appropriate delay has elapsed.
            if (System.currentTimeMillis() - lastUpdate > delay) {
                game.tick(System.currentTimeMillis() - lastUpdate);
                lastUpdate = System.currentTimeMillis();
            }
        }

    }

}
