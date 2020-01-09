package platformergame.sprites;

/**
 * Sprite affected by gravity.
 */
public abstract class WeightedSprite extends Sprite {

    // gravitational constant within game in px/s^2.
    private final double G = 750.0;

    // terminal velocity in game.
    private final double TERMINAL = 250.0;

    // stores whether the object is grounded.
    private boolean grounded = false;

    WeightedSprite(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    /**
     * Applies gravity.
     * @param elapsed Time since last update in milliseconds.
     */
    @Override
    public void tick(double elapsed) {

        // move sprite.
        super.tick(elapsed);

        if (!grounded) {
            // increase velocity in vertical direction.
            if (this.getVelY() < TERMINAL) {
                this.setVelY(this.getVelY() + elapsed * G / 1000.0);
                if (this.getVelY() > TERMINAL) this.setVelY(TERMINAL);
            }
        }

    }

    public void setGrounded(boolean grounded) {
        this.grounded = grounded;
    }

    public boolean isGrounded() {
        return grounded;
    }
}
