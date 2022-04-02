package ballboy.model;

import ballboy.model.entities.*;

import java.util.List;
import java.util.Map;


public class LevelImpl implements Level{

    private LevelData levelData;

    private Player ball;
    private Map<String, Double> ballStartingPoint;
    private Entity endPoint;

    private List<Entity> terrainList;
    private List<Entity> enemiesList;
    private List<Entity> entityList;

    private boolean winState;
    private boolean loseState;


    public LevelImpl(LevelCreator levelCreator) {
        levelData = levelCreator.getLevelData();
        ball = levelCreator.getBall();
        ballStartingPoint = levelCreator.getBallStartingPoint();
        endPoint = levelCreator.getEndPoint();

        terrainList = levelCreator.getTerrainList();
        enemiesList = levelCreator.getEnemiesList();
        entityList = levelCreator.getEntityList();

        winState = levelCreator.getWinState();
        loseState = levelCreator.getLoseState();
    }

    @Override
    public List<Entity> getEntities() {
        return entityList;
    }

    @Override
    public double getLevelHeight() {
        return levelData.getHeight();
    }

    @Override
    public double getLevelWidth() {
        return levelData.getWidth();
    }

    @Override
    public void tick() {
        for(Entity entity: entityList) {
            entity.tick();
        }

        // check if player has collided with the endpoint, if true, set winState to true to close game
        if (checkCollision((Entity) ball, endPoint)){
            winState = true;
        }

        // check if player has collided with any terrain
        for (Entity terrain : terrainList){
            if (checkCollision(ball, terrain)) {
                ball.handleCollision(terrain);
            }
        }

        for (Entity enemy : enemiesList){
            // check if player has collided with the end point, if true, set loseState to true to reset player position
            if (checkCollision(ball, enemy)) {
                loseState = true;
            }
            // check if enemy has collided with terrain
            for (Entity terrain : terrainList){
                if (checkCollision(enemy, terrain)) {
                    enemy.handleCollision(terrain);

                }
            }
            // check if enemy has collided with another enemy
            for (Entity enemy2 : enemiesList){
                if (checkCollision(enemy, enemy2)) {
                    enemy.handleCollision(enemy2);
                    enemy2.handleCollision(enemy);

                }
            }
        }

    }

    @Override
    public boolean checkCollision(Entity entity, Entity entity2){
        if (entity == entity2) {
            return false;
        }

        return (entity.getPosition().getX() < (entity2.getPosition().getX() + entity2.getPosition().getWidth())) &&
                ((entity.getPosition().getX() + entity.getPosition().getWidth()) > entity2.getPosition().getX()) &&
                (entity.getPosition().getY() < (entity2.getPosition().getY() + entity2.getPosition().getHeight())) &&
                ((entity.getPosition().getY() + entity.getPosition().getHeight()) > entity2.getPosition().getY());
    }

    @Override
    public boolean getLoseState(){
        return loseState;
    }

    @Override
    public boolean getWinState(){
        return winState;
    }

    @Override
    public void setLoseState(boolean loseState){
        this.loseState = loseState;
    }

    @Override
    public void setWinState(boolean winState){
        this.winState = winState;
    }

    @Override
    public void resetPlayer(){
        ball.getPosition().setX(ballStartingPoint.get("x"));
        ball.getPosition().setY(ballStartingPoint.get("y"));
    }

    @Override
    public double getFloorHeight() {
        return levelData.getFloorHeight();
    }

    @Override
    public double getHeroX() {
        return ball.getPosition().getX();
    }

    @Override
    public double getHeroY() { return ball.getPosition().getY(); }

    @Override
    public boolean boostHeight() {
        return ball.boostHeight();
    }

    @Override
    public boolean dropHeight() {
        return ball.dropHeight();
    }

    @Override
    public boolean moveLeft() {
        return ball.moveLeft();
    }

    @Override
    public boolean moveRight() {
        return ball.moveRight();
    }

    @Override
    public boolean stop() {
        return ball.stop();
    }
}

