package ballboy.model;
import ballboy.model.entities.*;

import java.util.List;
import java.util.Map;

public interface LevelCreator {

    Level getLevel();

    LevelData getLevelData();

    List<Entity> getEntityList();

    Player getBall();

    Entity getEndPoint();

    List<Entity> getTerrainList();

    List<Entity> getEnemiesList();

    Map<String, Double> getBallStartingPoint();

    boolean getWinState();

    boolean getLoseState();

    void setLevelData(Map<String, Object> configLevel);

    void setPlayer(Map<String, Object> configLevel);

    void setEndPoint(Map<String, Object> configLevel);

    void setEntities(Map<String, Object> configLevel);

    void setWinState(boolean b);

    void setLoseState(boolean b);
}
