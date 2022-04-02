package ballboy.model.entities;

import ballboy.model.LevelData;

import java.util.Random;


public class FloatingEnemyMoveStrat implements MovementStrategy{

    private double yV;
    private double xV;
    private Random random; // creating Random object
    private double minV;
    private double maxV;

    public FloatingEnemyMoveStrat(){
        this.yV = 0;
        this.xV = 0.1;
        random = new Random();
        minV = -1;
        maxV = 1;
    }

    @Override
    public void move(Position position) {

        double width = position.getWidth();
        double height = position.getHeight();

        double halfWidth = width / 2;
        double halfHeight = height / 2;

        LevelData levelData = position.getLevelData();

        double randomValue = minV + (maxV - minV) * random.nextDouble();

        setYV(randomValue);

        double nextY = position.getY() + getYV();
        if (position.checkValidY(nextY)){
            position.setY(nextY);
        }
        else{
            reverseYV();
            nextY = position.getY() + yV;
            position.setY(nextY);
        }

        double nextX = position.getX() + getXV();
        if (position.checkValidX(nextX)){
            position.setX(nextX);
        }
        else{
            reverseHV();
            nextX = position.getX() + xV;
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
