package ballboy.model.entities;

public interface Player extends Entity {

    /**
     * raises the bounce height of player
     * @return true so KeyboardInputHandler knows when to play a sound
     */
    boolean boostHeight();

    /**
     * lowers the bounce height of player
     */
    boolean dropHeight();

    /**
     * moves player to the left
     */
    boolean moveLeft();

    /**
     * moves player to the right
     */
    boolean moveRight();

    /**
     * stops player left or right movement
     */
    boolean stop();

}
