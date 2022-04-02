package ballboy.model.entities;

import ballboy.model.LevelData;

import java.util.Map;

public class CloudFactory implements EntityFactory {

    private double height = 30;
    private double width = 120;

    @Override
    public Entity createEntity(Map<String, Object> entityData, LevelData levelData) {

        double x = getDouble(entityData, "x");
        double y = getDouble(entityData, "y");
        double hv = getDouble(entityData, "cloudVelocity");

        Position position = new EntityPosition(x, y, height, width, Layer.BACKGROUND, levelData);
        Entity cloud = new Cloud(position, hv);

        return cloud;
    }

    public double getDouble(Map<String, Object> config, String key) {
        return Double.parseDouble(config.get(key).toString());
    }
}