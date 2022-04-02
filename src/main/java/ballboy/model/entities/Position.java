package ballboy.model.entities;
import ballboy.model.LevelData;


public interface Position {

    /**
     * @param x x coordinate
     * @return true if the x coordinate is valid, valid when x is within 0 and width of the level
     */
    boolean checkValidX(double x);


    /**
     * @param y y coordinate
     * @return true if the y coordinate is valid
     */
    boolean checkValidY(double y);

    /**
     * Returns the current x position of this Entity
     * @return The x position using the top left hand corner as 0,0 and increasing as the position moves right on the screen.
     */
    double getX();

    /**
     * Returns the current y position of this Entity
     * @return The y position using the top left hand corner as 0.0 and increasing as the position moves down the screen
     */
    double getY();

    /**
     * Returns the current 'z' position to draw this entity. Order within each layer is undefined.
     * @return The layer to draw the entity on.
     */
    double getLayer();

    /**
     *  Returns the current height of this Entity
     * @return The height in coordinate space (e.g. number of pixels)
     */
    double getHeight();

    /**
     *  Returns the current width of this Entity
     * @return The width in coordinate space (e.g. number of pixels)
     */
    double getWidth();

    /**
     * Returns a LevelData object that contains the level's width, height and floorHeight
     * @return LevelData
     */
    LevelData getLevelData();

    /* Setters */
    void setX(double x);

    void setY(double y);

    void setHeight(double height);

    void setWidth(double width);
}
