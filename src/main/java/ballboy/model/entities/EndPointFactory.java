package ballboy.model.entities;

import ballboy.model.LevelData;

import java.util.Map;

public class EndPointFactory implements EntityFactory {

        private double height = 100;
        private double width = 100;

        @Override
        public Entity createEntity(Map<String, Object> entityData, LevelData levelData) {

            double x = getDouble(entityData, "x");
            double y = getDouble(entityData, "y");

            Position position = new EntityPosition(x, y, height, width, Layer.FOREGROUND, levelData);
            Entity endPoint = new EndPoint(position);

            return endPoint;
        }

        public double getDouble(Map<String, Object> config, String key) {
            return Double.parseDouble(config.get(key).toString());
        }


}
