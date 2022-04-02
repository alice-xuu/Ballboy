package ballboy.model.entities;

import javafx.scene.image.Image;

public class Grass implements Entity{
    private Position position;
    private Image image;

    public Grass(Position position, String imagePath, double imageX, double imageY){
        this.position = position;
        this.image = new Image(imagePath, imageX, imageY, false, false);
    }

    @Override
    public void tick() { }

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
