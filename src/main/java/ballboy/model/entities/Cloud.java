package ballboy.model.entities;

import javafx.scene.image.Image;

public class Cloud implements Entity {

    private Position position;
    private Image image;
    private MovementStrategy strat;

    public Cloud(Position position, double hv){
        this.position = position;
        this.strat = new CloudMoveStrat(hv);
        this.image = new Image("/cloud_1.png");

    }

    @Override
    public void tick() {
        strat.move(position);
    }

    @Override
    public void handleCollision(Entity entity) { }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
