package ballboy.model.entities;

import ballboy.model.LevelData;

import java.util.Map;

public class GrassFactory implements EntityFactory {

    @Override
    public Entity createEntity(Map<String, Object> entityData, LevelData levelData) {

        double height = getDouble(entityData, "height");
        double width = getDouble(entityData, "width");
        double x = getDouble(entityData, "x");
        double y = getDouble(entityData, "y");
        String imagePath = entityData.get("imagePath").toString();

        Position position = new EntityPosition(x, y, height, width, Layer.BACKGROUND, levelData);
        Entity grass = new Grass(position, imagePath, width, height);

        return grass;
    }
    public double getDouble(Map<String, Object> config, String key) {
        return Double.parseDouble(config.get(key).toString());
    }
}
