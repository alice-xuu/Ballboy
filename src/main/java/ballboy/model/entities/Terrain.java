package ballboy.model.entities;

import javafx.scene.image.Image;

public class Terrain implements Entity {

    private Position position;
    private Image image;

    public Terrain(Position position){
        this.position = position;
        this.image = new Image("/foot_tile.png");

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
