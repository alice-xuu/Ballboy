package ballboy.model;

import ballboy.model.entities.*;

import java.util.*;

public class LevelCreatorImpl implements LevelCreator {

    private LevelData levelData;

    private Player ball;
    private Map<String, Double> ballStartingPoint;

    private Entity endPoint;

    private List<Entity> terrainList;
    private List<Entity> enemiesList;

    private List<Entity> entityList; // list of all entities

    private EntityRegistry entityRegistry;

    private boolean loseState;
    private boolean winState;

    // creator takes the config and creates each entity
    public LevelCreatorImpl(Map<String, Object> configLevel) {

        terrainList = new ArrayList<>();
        enemiesList = new ArrayList<>();
        entityList = new ArrayList<>();
        ballStartingPoint = new HashMap<>();
        entityRegistry = new EntityRegistry();

        // set height, width, floorheight of level
        setLevelData(configLevel);

        // create player controlled ball
        setPlayer(configLevel);

        // create endPoint of game
        setEndPoint(configLevel);

        // create clouds, terrain, enemies
        setEntities(configLevel);

        setLoseState(false);
        setWinState(false);

    }

    @Override
    public boolean getWinState() {
        return winState;
    }

    @Override
    public boolean getLoseState() {
        return loseState;
    }

    @Override
    public void setWinState(boolean b) {
        winState = b;
    }

    @Override
    public void setLoseState(boolean b) {
        loseState = b;
    }

    @Override
    public Entity getEndPoint() {
        return endPoint;
    }

    @Override
    public List<Entity> getTerrainList() {
        return terrainList;
    }

    @Override
    public List<Entity> getEnemiesList() {
        return enemiesList;
    }

    @Override
    public Level getLevel() {
        return new LevelImpl(this);
    }

    @Override
    public LevelData getLevelData() {
        return levelData;
    }

    @Override
    public List<Entity> getEntityList() {
        return entityList;
    }

    @Override
    public Player getBall() {
        return ball;
    }

    @Override
    public Map<String, Double> getBallStartingPoint() {
        return ballStartingPoint;
    }

    public double getDouble(Map<String, Object> config, String key) {
        return Double.parseDouble(config.get(key).toString());
    }

    @Override
    public void setLevelData(Map<String, Object> configLevel) {
        Map<String, Object> configLevelData = (Map<String, Object>) configLevel.get("levelData");
        double width = getDouble(configLevelData, "width");
        double height = getDouble(configLevelData, "height");
        double floorHeight = getDouble(configLevelData, "floorHeight");
        levelData = new LevelData(width, height, floorHeight);
    }

    @Override
    public void setPlayer(Map<String, Object> configLevel) {
        PlayerFactory playerFactory = entityRegistry.getPlayerFactory();
        Map<String, Object> configBall = (Map<String, Object>) configLevel.get("ballBoy");
        ball = playerFactory.createPlayer(configBall, levelData);
        entityList.add((Entity) getBall());

        ballStartingPoint.put("x", ball.getPosition().getX());
        ballStartingPoint.put("y", ball.getPosition().getY());
    }

    @Override
    public void setEndPoint(Map<String, Object> configLevel) {
        EntityFactory endPointFactory = entityRegistry.getFactory("endPoint");
        Map<String, Object> configEndPoint = (Map<String, Object>) configLevel.get("endPoint");
        endPoint = endPointFactory.createEntity(configEndPoint, levelData);
        entityList.add(getEndPoint());
    }

    @Override
    public void setEntities(Map<String, Object> configLevel) {

        EntityFactory factory;

        List<String> singleEntities = Arrays.asList("grass");
        for (String entity : singleEntities) {
            factory = entityRegistry.getFactory(entity);
            Map<String, Object> configs = (Map<String, Object>) configLevel.get(entity);
            entityList.add(factory.createEntity(configs, levelData));
        }

        Entity newEntity;
        // create multiple entities
        List<String> entities = Arrays.asList("cloud", "terrain", "normalEnemy", "floatingEnemy");
        for (String entity : entities) {
            factory = entityRegistry.getFactory(entity);
            if (configLevel.containsKey(entity)){
                for (Map<String, Object> entityData : (List<Map>) configLevel.get(entity)) {
                    newEntity = factory.createEntity(entityData, levelData);
                    if (entity.equals("terrain")) {
                        terrainList.add(newEntity);
                    }
                    if (entity.equals("normalEnemy") || entity.equals("floatingEnemy")) {
                        enemiesList.add(newEntity);
                    }
                    entityList.add(newEntity);
                }
            }
        }
    }
}
