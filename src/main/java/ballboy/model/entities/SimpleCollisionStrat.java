package ballboy.model.entities;

public class SimpleCollisionStrat implements CollisionStrategy{

    // checks x collision only, reverses movement
    public SimpleCollisionStrat() { }

    public void handleCollision(MovementStrategy strat1, Position entity1, Position entity2){

        double newX;
        double newX2;

        if ((entity1.getX() < (entity2.getX()))) {

            double left = (entity1.getX() - (entity2.getX() + entity2.getWidth()));
            newX = entity1.getX() - left;

            double right = ((newX + entity1.getWidth()) - entity2.getX());
            newX2 = newX - right;

            if (entity1.checkValidX(newX) && entity1.checkValidX(newX2)) {
                entity1.setX(newX2);
                strat1.reverseXV();
            }
        }

        else if ((entity1.getX() + entity1.getWidth() > entity2.getX() + entity2.getWidth())) {
            double right = ((entity1.getX() + entity1.getWidth()) - entity2.getX());
            newX = entity1.getX() - right;

            double left = (newX - (entity2.getX() + entity2.getWidth()));
            newX2 = newX - left;

            if (entity1.checkValidX(newX) && entity1.checkValidX(newX2)) {
                entity1.setX(newX2);
                strat1.reverseXV();
            }
        }
    }
}
