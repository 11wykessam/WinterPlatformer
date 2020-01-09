package control;
import animation.AnimationThread;
import common.Game;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import platformergame.PlatformerGame;
import platformergame.UpdateThread;

/**
 * Class used for handling and controlling input.
 */
public class GameController {

    // the canvas where the game is rendered.
    @FXML
    private Canvas gameCanvas;

    // the game the controller is running.
    private Game game;

    /**
     * Called once the scene has loaded.
     */
    public void initialize() {

        // set up the game.
        game = new PlatformerGame(gameCanvas.getGraphicsContext2D());

        // animate the game.
        AnimationThread animationThread = new AnimationThread(game, PlatformerGame.FPS, gameCanvas.getGraphicsContext2D());
        animationThread.start();

        // set up update thread.
        UpdateThread updateThread = new UpdateThread(game, PlatformerGame.FPS);
        updateThread.start();

    }

    /**
     * Called when key is pressed.
     * @param e {@link KeyEvent} object.
     */
    @FXML
    private void keyPressed(KeyEvent e) {

        game.keyPressed(e);

    }

    /**
     * Called when key is released.
     * @param e {@link KeyEvent} object.
     */
    @FXML
    private void keyReleased(KeyEvent e) {

        game.keyReleased(e);

    }

}
