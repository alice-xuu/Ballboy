package ballboy.model.entities;

import ballboy.model.LevelData;

public class EntityPosition implements Position {

    // coordinates of the entity
    private double x;
    private double y;
    private double z;

    // length sizes of the entity
    private double height;
    private double width;

    private LevelData levelData;

    public EntityPosition(double x, double y, double height, double width,  Layer layer, LevelData levelData){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.z = layer.getZ();
        this.levelData = levelData;
    }

    /**
     *
     * @param x coordinate
     * @return false if out of bounds, true if in bounds
     */
    @Override
    public boolean checkValidX(double x){
        if (x < 0 || x > levelData.getWidth() - width){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public boolean checkValidY(double y){
        if (y < 0 || y > levelData.getHeight() - height){
            return false;
        }
        else {
            return true;
        }
    }

    /* Getters */
    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getLayer() {
        return z;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public LevelData getLevelData() {
        return levelData;
    }

    /* Getters end */


    /* Setters */
    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    /* Setters end */


}
