package ballboy.model.entities;
import javafx.scene.image.Image;

public interface Entity {
    /**
     * Returns the current Image used by this Entity. This may change over time, such as for simple animations.
     * @return An Image representing the current state of this Entity
     */
    Image getImage();

    /**
     *
     * @return the position of the entity
     */
    Position getPosition();

    /**
     * Events of a single frame
     */
    void tick();

    /**
     * Handles collisions between this entity instance and the param entity
     * @param entity
     */
    void handleCollision(Entity entity);
}
