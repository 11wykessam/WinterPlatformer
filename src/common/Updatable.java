package common;

/**
 * Interface for all objects in game that are to be updated during ticks.
 */
public interface Updatable {

    /**
     * Updates the object.
     * @param elapsed Time since last update in milliseconds.
     */
    void tick(double elapsed);

}
