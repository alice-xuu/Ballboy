package ballboy.model.entities;

public class CollisionStrat implements CollisionStrategy{

    public CollisionStrat() {

    }

    @Override
    public void handleCollision(MovementStrategy strat1, Position entity1, Position entity2){

        double newX;
        double newX2;

        // move entity1 so it doesn't overlap with entity 2 and set appropriate responses

        if ((entity1.getY() > (entity2.getY()))
            && ((entity1.getY() + entity1.getHeight()) < (entity2.getY() + entity2.getHeight()))
            && ((entity1.getX()) < (entity2.getX() + entity2.getWidth()/2))){

            double left = (entity1.getX() - (entity2.getX() + entity2.getWidth()));
            newX = entity1.getX() - left;

            double right = ((newX + entity1.getWidth()) - entity2.getX());
            newX2 = newX - right;

            if (entity1.checkValidX(newX) && entity1.checkValidX(newX2)) {
                entity1.setX(newX2);
            }
        }

        else if ((entity1.getY() > (entity2.getY()))
            && ((entity1.getY() + entity1.getHeight()) < (entity2.getY() + entity2.getHeight()))
            && ((entity1.getX() + entity1.getWidth()) > (entity2.getX()))) {

            double right = ((entity1.getX() + entity1.getWidth()) - entity2.getX());
            newX = entity1.getX() - right;

            double left = (newX - (entity2.getX() + entity2.getWidth()));
            newX2 = newX - left;

            if (entity1.checkValidX(newX) && entity1.checkValidX(newX2)) {
                entity1.setX(newX2);
            }
        }

        // bottom of entity2
        else if ((entity1.getY())  > (entity2.getY())){
            double bot = ((entity1.getY() - entity1.getHeight()) + entity2.getY());
            entity1.setY(entity1.getY() - bot);
            double top = (entity1.getY() - (entity2.getY() + entity2.getHeight()));
            entity1.setY(entity1.getY() - top);

            strat1.reverseYV();
        }

        // top of entity2
        else if ((entity1.getY()) < (entity2.getY() + entity2.getHeight())) {
            double top = (entity1.getY() - (entity2.getY() + entity2.getHeight()));
            entity1.setY(entity1.getY() - top);
            double bot = ((entity1.getY() + entity1.getHeight()) - entity2.getY());
            entity1.setY(entity1.getY() - bot);
            strat1.reverseYV();
        }
    }
}
