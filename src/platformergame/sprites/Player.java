package platformergame.sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import common.Renderable;
import javafx.scene.shape.Rectangle;
import platformergame.PlatformerGame;
import platformergame.collisions.Collidable;
import platformergame.levels.Level;

import java.util.ArrayList;

/**
 * Represents the player in the game.
 */
public class Player extends WeightedSprite implements Renderable {

    // dimensions of player.
    private static final double WIDTH = 40.0;
    private static final double HEIGHT = 40.0;

    // speed of player.
    private static final double SPEED = 250.0;
    private static final double JUMPSPEED = 400;

    // whether the player is moving left or right.
    private boolean movingLeft = false;
    private boolean movingRight = false;

    // default color of player.
    private final Paint COLOR = Color.RED;

    // level the player is in.
    private Level level;

    public Player(double x, double y, Level level) {
        super(x, y, WIDTH, HEIGHT);
        this.level = level;
    }

    /**
     * Update player.
     * @param elapsed Time since last update in milliseconds.
     */
    @Override
    public void tick(double elapsed) {

        // store previous x and y coordinates for collisions.
        double prevX = this.getX();
        double prevY = this.getY();

        // check for horizontal movement.
        this.setVelX(0);
        if (movingLeft) this.setVelX(-Player.SPEED);
        if (movingRight) this.setVelX(this.getVelX() + Player.SPEED);

        // process gravity.
        super.tick(elapsed);

        // check for collisions due to gravity.
        if (level.getFloor().collides(this.getBounds())) {
            this.setY(PlatformerGame.GAMEHEIGHT - this.getHeight());
            this.setGrounded(true);
            this.setVelY(0);
        }

        // check for other collisions.
        ArrayList<Collidable> collidables = level.getCollidables();
        for (Collidable collidable : collidables) {

            // if a collision occurs we need to shift some coords.
            if (collidable.collides(this.getBounds())) {

                // check which direction occurs from.
                // a horizontal collision occurs if a change in x coordinate caused collision.
                boolean horizontalCollision = !collidable.collides(new Rectangle(prevX, getY(), getWidth(), getHeight()));
                // similarly vertical collision occurs if a change in y coordinate caused collision.
                boolean verticalCollision = !collidable.collides(new Rectangle(getX(), prevY, getWidth(), getHeight()));



            }

        }

    }

    /**
     * Renders player to screen.
     * @param gc {@link GraphicsContext} being rendered to.
     */
    @Override
    public void render(GraphicsContext gc) {

        // remember previous fill and change to current fill.
        Paint prevFill = gc.getFill();
        gc.setFill(COLOR);

        gc.fillRect(getX(), getY(), getWidth(), getHeight());

        // reset color.
        gc.setFill(prevFill);

    }

    /**
     * Jump if possible.
     */
    public void jump() {

        if (isGrounded()) {
            this.setGrounded(false);
            this.setVelY(-JUMPSPEED);
        }

    }

    /**
     * Setter for movingLeft.
     * @param movingLeft Sets whether the player is moving left.
     */
    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    /**
     * Setter for movingRight.
     * @param movingRight Sets whether the player is moving right.
     */
    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }
}
