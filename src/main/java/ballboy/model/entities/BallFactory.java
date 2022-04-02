package ballboy.model.entities;

import ballboy.model.LevelData;
import java.util.Map;

public class BallFactory implements PlayerFactory{
    @Override
    public Player createPlayer(Map<String, Object> entityData, LevelData levelData) {
        double x = getDouble(entityData, "x");
        double y = getDouble(entityData, "y");
        if (y < levelData.getFloorHeight()){
            y = levelData.getFloorHeight();
        }

        String size = (String) entityData.get("size");
        double width = 0;
        double height = 0;
        switch (size) {
            case "small":
                width = 30;
                height = 30;
                break;
            case "medium":
                width = 50;
                height = 50;
                break;
            case "large":
                width = 70;
                height = 70;
                break;
        }

        Position position = new EntityPosition(x, y, height, width, Layer.FOREGROUND, levelData);
        Player ball = new Ball(position);

        return ball;
    }

    public double getDouble(Map<String, Object> config, String key) {
        return Double.parseDouble(config.get(key).toString());
    }
}
