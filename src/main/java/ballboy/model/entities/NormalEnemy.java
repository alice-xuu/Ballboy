package ballboy.model.entities;

import javafx.scene.image.Image;

public class NormalEnemy implements Entity {

    private Position position;
    private Image image;
    private MovementStrategy strat;
    private CollisionStrategy collisionStrat;

    public NormalEnemy(Position position){
        this.position = position;
        this.strat = new NormalEnemyMoveStrat();
        this.image = new Image("/slimeRa.png");
        this.collisionStrat = new SimpleCollisionStrat();

    }

    @Override
    public void tick() {
        strat.move(position);
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
}
