package ballboy.model.entities;

import javafx.scene.image.Image;

public class Ball implements Player {

    private Position position;
    private Image image;
    private PlayerMovementStrategy strat;
    private CollisionStrategy collisionStrat;

    public Ball(Position position){

        this.position = position;
        this.image = new Image("/slimePa.png");
        this.strat = new BallMoveStrat();
        this.collisionStrat = new CollisionStrat();

    }

    @Override
    public void tick() {
        strat.move(getPosition());
    }

    @Override
    public void handleCollision(Entity entity) {
        collisionStrat.handleCollision(strat, position, entity.getPosition());
    }


    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public boolean boostHeight() {
        strat.boostHeight();
        return true;
    }

    @Override
    public boolean dropHeight() {
        strat.dropHeight();
        return true;
    }

    @Override
    public boolean moveLeft() {
        strat.moveLeft();
        return true;
    }

    @Override
    public boolean moveRight() {
        strat.moveRight();
        return true;
    }

    @Override
    public boolean stop() {
        strat.stop();
        return true;
    }

}
