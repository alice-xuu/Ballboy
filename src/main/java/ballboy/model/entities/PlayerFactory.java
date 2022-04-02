package ballboy.model.entities;

import ballboy.model.LevelData;

import java.util.Map;

public interface PlayerFactory {

    /**
     * Creates a player
     * @param entityData read from the config file
     * @param levelData contains level height, width and floor height
     * @return player obejct
     */
    Player createPlayer(Map<String, Object> entityData, LevelData levelData);
}
