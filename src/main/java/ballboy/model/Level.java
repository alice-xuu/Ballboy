package ballboy.model;

import ballboy.model.entities.Entity;
import java.util.List;

/**
 * The base interface for a Ballboy level.
 */
public interface Level {
    /**
     * Return a List of the currently existing Entities.
     * @return The list of current entities for this level
     */
    List<Entity> getEntities();

    /**
     * The height of the level
     * @return The height (should be in the same format as Entity sizes)
     */
    double getLevelHeight();

    /**
     * The width of the level
     * @return The width (should be in the same format as Entity sizes)
     */
    double getLevelWidth();

    /**
     * Instruct the level to progress forward in time by one increment.
     */
    void tick();

    /**
     * The height of the floor for this level. This is where the ground stops and the sky starts.
     * @return The floor height (should be in the same format as Entity sizes)
     */
    double getFloorHeight();

    /**
     * The current x position of the hero. This is useful for views so they can follow the hero.
     * @return The hero x position (should be in the same format as Entity sizes)
     */
    double getHeroX();

    /**
     * The current y position of the hero. This is useful for views so they can follow the hero.
     * @return The hero y position (should be in the same format as Entity sizes)
     */
    double getHeroY();

    // Hero inputs - boolean for success (possibly for sound feedback)

    /**
     * Increase the height the bouncing hero can reach. This could be the vertical acceleration of the hero, unless the current level has special behaviour.
     * @return true if successful
     */
    boolean boostHeight();

    /**
     * Reduce the height the bouncing hero can reach. This could be the vertical acceleration of the hero, unless the current level has special behaviour.
     * @return true if successful
     */
    boolean dropHeight();

    /**
     * Move the hero left or accelerate the hero left, depending on the current level's desired behaviour
     *
     * @return true if successful
     */
    boolean moveLeft();

    /**
     * Move the hero right or accelerate the hero right, depending on the current level's desired behaviour
     *
     * @return true if successful
     */
    boolean moveRight();

    /**
     * Stop the hero's movement
     * @return true if successful
     */
    boolean stop();

    /**
     * @return true if player has collided with the endPoint
     */
    boolean getWinState();

    /**
     *
     * @param entity
     * @param entity2
     * @return true if entity and entity2 overlap
     */
    boolean checkCollision(Entity entity, Entity entity2);

    /**
     * @return true if player has collided with any enemy
     */
    boolean getLoseState();

    /* Setters */

    void setLoseState(boolean b);

    void setWinState(boolean b);

    void resetPlayer();
}