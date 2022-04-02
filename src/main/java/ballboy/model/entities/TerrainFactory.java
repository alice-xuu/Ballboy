package ballboy.model.entities;

import ballboy.model.LevelData;

import java.util.Map;

public class TerrainFactory implements EntityFactory {

        private double height = 75;
        private double width = 75;

        @Override
        public Entity createEntity(Map<String, Object> entityData, LevelData levelData) {

            double x = getDouble(entityData, "x");
            double y = getDouble(entityData, "y");

            Position position = new EntityPosition(x, y, height, width, Layer.FOREGROUND, levelData);
            Entity terrain = new Terrain(position);

            return terrain;
        }

        public double getDouble(Map<String, Object> config, String key) {
            return Double.parseDouble(config.get(key).toString());
        }

}
