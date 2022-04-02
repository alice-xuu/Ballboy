package ballboy.model.entities;

public class CloudMoveStrat implements MovementStrategy{

    private double xV;
    private double yV;

    public CloudMoveStrat(double hv){
        this.xV = hv;
        this.yV = 0;
    }

    @Override
    public void move(Position position) {
        double nextX = position.getX() + getXV();
        if (nextX < position.getLevelData().getWidth()){
            position.setX(nextX);
        }
        else{
            position.setX(0);
        }
    }

    @Override
    public void reverseXV() {
        this.xV *= -1;
    }

    @Override
    public void reverseYV() {
    }

    @Override
    public double getXV() {
        return xV;
    }

    @Override
    public double getYV() {
        return yV;
    }

    @Override
    public void setXV(double xV) {

    }

    @Override
    public void setYV(double yV) {

    }

}
