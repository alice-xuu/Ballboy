package ballboy.model.entities;

public interface PlayerMovementStrategy extends MovementStrategy{

    /**
     * resets player speed to a fixed y velocity and reverses the velocity, i.e. direction
     */
    void resetAndReverseYV();

    /**
     * raises fixed y velocity if not at max velocity so player will bounce higher
     */
    void boostHeight();

    /**
     * lowers the fixed y velocity if not at min velocity so player will bounce lower
     */
    void dropHeight();

    /**
     * accelerate left until max horizontal speed is reached
     */
    void moveLeft();

    /**
     * accelerate right until max horizontal speed is reached
     */
    void moveRight();

    /**
     * stops horizontal movement
     */
    void stop();

    /**
     *
     * @return vertical velocity at which player will reset to upon hitting the floor
     */
    double getFixedyV();

    double getFixedxV();

    /**
     *
     * @return true if moveLeft() has been called
     */
    boolean isLeft();

    /**
     *
     * @return true if moveRight() has been called
     */
    boolean isRight();

    /* Setters */

    void setXV(double xV);

    void setYV(double yV);

    void setFixedyV(double fixedyV);

    void setLeft(boolean left);

    void setRight(boolean right);
}

