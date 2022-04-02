package ballboy.model.entities;

import ballboy.model.LevelData;

public class NormalEnemyMoveStrat implements MovementStrategy{

    private double yV;
    private double xV;

    public NormalEnemyMoveStrat(){

        this.yV = 0;
        this.xV = 0.2;
    }

    @Override
    public void move(Position position) {

        double width = position.getWidth();
        double height = position.getHeight();

        double halfWidth = width / 2;
        double halfHeight = height / 2;

        LevelData levelData = position.getLevelData();

        double nextX = position.getX() + getXV();
        if (position.checkValidX(nextX)){
            position.setX(nextX);
        }
        else{
            reverseHV();
            nextX = position.getX() + getXV();
            position.setX(nextX);
        }

    }

    @Override
    public void reverseXV() {
        this.xV *= -1;
    }

    @Override
    public void reverseYV() {
        this.yV *= -1;
    }

    public void reverseHV(){
        this.xV *= -1;
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


    /** Setters **/

    @Override
    public void setXV(double xV) {
        this.xV = xV;
    }

    @Override
    public void setYV(double yV) {
        this.yV = yV;
    }


}
