package platformergame;

import common.Game;
import common.Renderable;
import common.Updatable;
import javafx.scene.canvas.GraphicsContext;
import platformergame.collisions.Floor;
import platformergame.levels.Level;
import platformergame.levels.LevelOne;
import platformergame.sprites.Player;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Controls a simple platformer game.
 */
public class PlatformerGame extends Game {

    // store the dimensions of the game.
    public final static double GAMEWIDTH = 600.0;
    public final static double GAMEHEIGHT = 400.0;

    // the FPS the game should be ran at.
    public static final double FPS = 30.0;

    // the graphics context the game is being animated in.
    private GraphicsContext gc;

    // all objects being rendered in game.
    private ArrayList<Renderable> renderables = new ArrayList<>();
    // all objects that need to be updated.
    private ArrayList<Updatable> updatables = new ArrayList<>();

    // current level of the game.
    private Level currentLevel;

    // the player being controlled by user.
    private Player player;

    /**
     * Set up game.
     * @param gc {@link GraphicsContext} game will be rendered in.
     */
    public PlatformerGame(GraphicsContext gc) {
        this.gc = gc;

        // set up level.
        currentLevel = new LevelOne(gc);
        renderables.add(currentLevel);

        // set up player.
        player = new Player(0, 0, currentLevel);
        renderables.add(player);
        updatables.add(player);
    }

    /**
     * Updates all objects in the game.
     * @param elapsed Time elapsed since last update in milliseconds.
     */
    @Override
    public void tick(double elapsed) {

        // tick all updatables.
        for (Updatable updatable : updatables) updatable.tick(elapsed);

    }

    /**
     * Renders the game.
     * @param gc {@link GraphicsContext} object being rendered to.
     */
    @Override
    public void render(GraphicsContext gc) {
        // firstly clear the screen.
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

        // render all objects.
        for (Renderable renderable : renderables) renderable.render(gc);
    }

    /**
     * Called when key is pressed in the game.
     * @param e {@link KeyEvent} object triggered.
     */
    @Override
    public void keyPressed(javafx.scene.input.KeyEvent e) {

        switch (e.getCode()) {
            // move player to left.
            case A:
                player.setMovingLeft(true);
                break;
            // move player to right.
            case D:
                player.setMovingRight(true);
                break;
            case SPACE:
                player.jump();
                break;
        }

    }

    /**
     * Called when key is released in the game.
     * @param e {@link KeyEvent} object triggered.
     */
    @Override
    public void keyReleased(javafx.scene.input.KeyEvent e) {

        switch (e.getCode()) {
            case A:
                player.setMovingLeft(false);
                break;
            case D:
                player.setMovingRight(false);
                break;
        }

    }
}
