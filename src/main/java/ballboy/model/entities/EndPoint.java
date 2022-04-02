package ballboy.model.entities;

import javafx.scene.image.Image;

public class EndPoint implements Entity {

    private Position position;
    private Image image;

    public EndPoint(Position position){
        this.position = position;
        this.image = new Image("/ch_stand4.png");

    }

    @Override
    public void tick() {
    }

    @Override
    public void handleCollision(Entity entity) {

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
