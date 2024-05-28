package ballboy.view;

import ballboy.model.entities.Entity;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class EntityViewImpl implements EntityView {
    private Entity entity;
    private boolean delete = false;
    private ImageView node;

    EntityViewImpl(Entity entity) {
        this.entity = entity;
        node = new ImageView(entity.getImage());
        node.setViewOrder(entity.getPosition().getLayer());
        update(0.0, 0.0);
    }

    @Override
    public void update(double xViewportOffset, double yViewportOffset) {
        if (!node.getImage().equals(entity.getImage())) {
            node.setImage(entity.getImage());
        }
        node.setX(entity.getPosition().getX() - xViewportOffset);
        node.setY(entity.getPosition().getY() - yViewportOffset);
        node.setFitHeight(entity.getPosition().getHeight());
        node.setFitWidth(entity.getPosition().getWidth());
        node.setPreserveRatio(true);
        delete = false;
    }

    @Override
    public boolean matchesEntity(Entity entity) {
        return this.entity.equals(entity);
    }

    @Override
    public void markForDelete() {
        delete = true;
    }

    @Override
    public Node getNode() {
        return node;
    }

    @Override
    public boolean isMarkedForDelete() {
        return delete;
    }
}
