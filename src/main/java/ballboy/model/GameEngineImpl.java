package ballboy.model;

import java.util.List;
import java.util.Map;

public class GameEngineImpl implements GameEngine {
    private Level currentLevel;
    private LevelCreator levelCreator;


    public GameEngineImpl(Map<String, Object> config){

        List<Map> configLevels = (List<Map>) config.get("levels");
        Map<String, Object> configLevel = configLevels.get(0);
        Map<String, Object> configLevelData = (Map<String, Object>) configLevel.get("levelData");

        LevelCreator levelCreator = new LevelCreatorImpl(configLevel);
        currentLevel = levelCreator.getLevel();

    }

    @Override
    public Level getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public void startLevel() { }

    @Override
    public boolean boostHeight() {
        return currentLevel.boostHeight();
    }

    @Override
    public boolean dropHeight() {
        return currentLevel.dropHeight();
    }

    @Override
    public boolean moveLeft() {
        return currentLevel.moveLeft();
    }

    @Override
    public boolean moveRight() {
        return currentLevel.moveRight();
    }

    @Override
    public boolean stop() {
        return currentLevel.stop();
    }

    @Override
    public void tick() {
        if (getCurrentLevel().getLoseState()){
            getCurrentLevel().setLoseState(false);
            getCurrentLevel().resetPlayer();
        }
        if (getCurrentLevel().getWinState()){
            System.exit(0);
        }
        getCurrentLevel().tick();
    }
}
