package ballboy.model.entities;

import ballboy.model.LevelData;
import java.util.Map;

public interface EntityFactory {

    /**
     * Creates an entity
     * @param entityData read from the config file
     * @param levelData contains level height, width and floor height
     * @return entity object
     */
    Entity createEntity(Map<String, Object> entityData, LevelData levelData);
}
