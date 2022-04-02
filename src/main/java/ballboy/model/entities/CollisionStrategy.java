package ballboy.model.entities;

public interface CollisionStrategy {

    /**
     *
     * @param strat strategy of the entity that position belongs to
     * @param position position of entity 1
     * @param position2 position of entity 2
     * handles the collision between entity 1 (position) and entity 2 position2)
     */
    void handleCollision(MovementStrategy strat, Position position, Position position2);
}
