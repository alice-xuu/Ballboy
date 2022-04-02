package ballboy.model.entities;

import ballboy.model.LevelData;

public class BallMoveStrat implements MovementStrategy, PlayerMovementStrategy {

    private double fixedxV; // full horizontal velocity for ball to accelerate to
    private double fixedyV; // full vertical velocity that is reset to on ground bounce

    private double xV; // altering horizontal velocity
    private double yV; // altering vertical velocity

    private final double minyV; // minimum vertical velocity for bounce that fixedyV can be set to
    private final double maxyV; // maximum vertical velocity for bounce that fixedyV can be set to
    private final double gravity;

    private final double increment; // increment y velocity when dropping/boosting

    private boolean left;
    private boolean right;

    public BallMoveStrat(){
        this.fixedyV = 3;
        this.fixedxV = 2;

        this.yV = 3;
        this.xV = 0;

        this.minyV = 1;
        this.maxyV = 5;

        this.gravity = 2.0/60;
        this.increment = 0.5;

        this.left = false;
        this.right = false;

    }

    @Override
    public void move(Position position) {

        double width = position.getWidth();
        double height = position.getHeight();

        double halfWidth = width / 2;
        double halfHeight = height / 2;

        LevelData levelData = position.getLevelData();

        // set next y position
        position.setY(position.getY() + getYV());
        double nextX = position.getX() + getXV();
        if (position.checkValidX(nextX)){
            position.setX(nextX);
        }

        // top border
        if (position.getY() < 0) {
            position.setY(0);
            reverseYV();
        }

        // bottom border - bounce up again
        if (position.getY() >= levelData.getFloorHeight()) {
            position.setY(levelData.getFloorHeight());
            resetAndReverseYV();
        }

        // Apply gravity if position is not on the ground
        if (position.getY() < levelData.getFloorHeight()) {
            setYV( getYV() + gravity);
        }

        if (isLeft()){
            moveLeft();
        }
        if (isRight()){
            moveRight();
        }

    }

    @Override
    public void resetAndReverseYV(){
        setYV(getFixedyV() * -1);
    }

    @Override
    public void reverseXV() {
            xV *= -1;
    }

    @Override
    public void reverseYV() {
        yV *= -1;
    }


    @Override
    public void boostHeight() {
        double newyV = getFixedyV() + increment;
        if (newyV <= maxyV) {
            setFixedyV(newyV);
        }
    }

    @Override
    public void dropHeight() {
        double newyV = getFixedyV() - increment;
        if (newyV >= minyV) {
            setFixedyV(newyV);
        }
    }

    @Override
    public void moveLeft() {
        setLeft(true);
        double newxV = getXV() - increment;
        if (newxV >= -1 * getFixedxV()) {
            setXV(newxV);
        }
    }

    @Override
    public void moveRight() {
        setRight(true);
        double newxV = getXV() + increment;
        if (newxV <= getFixedxV()) {
            setXV(newxV);
        }
    }

    @Override
    public void stop() {
        setLeft(false);
        setRight(false);
        setXV(0);
    }

    /** Getters **/

    @Override
    public double getXV() {
        return xV;
    }

    @Override
    public double getYV() {
        return yV;
    }

    @Override
    public double getFixedyV() {
        return fixedyV;
    }

    @Override
    public double getFixedxV() {
        return fixedxV;
    }

    @Override
    public boolean isLeft() {
        return left;
    }

    @Override
    public boolean isRight() {
        return right;
    }

    /** Setters **/

    @Override
    public void setXV(double xV) {
        this.xV = xV;
    }

    @Override
    public void setYV(double yV) {
        this.yV = yV;
    }

    @Override
    public void setFixedyV(double fixedyV) {
        this.fixedyV = fixedyV;
    }

    @Override
    public void setLeft(boolean left) {
        this.left = left;
    }

    @Override
    public void setRight(boolean right) {
        this.right = right;
    }

}
