package ballboy.model.entities;

public interface MovementStrategy {

    /**
     * Controls the movement of the entity
     * @param position
     */
    void move(Position position);

    /**
     * reverses the horizontal direction of movement
     */
    void reverseXV();

    /**
     * reverses the vertical direction of movement
     */
    void reverseYV();

    /**
     *
     * @return x velocity
     */
    double getXV();

    /**
     *
     * @return y velocity
     */
    double getYV();

    /**
     *
     * @param xV sets the x velocity
     */
    void setXV(double xV);

    /**
     *
     * @param yV sets the y velocity
     */
    void setYV(double yV);
}
