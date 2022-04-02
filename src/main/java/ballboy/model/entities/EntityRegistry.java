package ballboy.model.entities;

import java.util.HashMap;
import java.util.Map;

public class EntityRegistry {

    private Map<String, EntityFactory> factories;
    private PlayerFactory playerFactory;


    public EntityRegistry(){
        factories = new HashMap<String, EntityFactory>();
        addFactories();
        playerFactory = new BallFactory();
    }

    public void registerFactory(EntityFactory factory, String identifier){
        factories.put(identifier, factory);
    }

    public EntityFactory getFactory(String identifier){
        return factories.get(identifier);
    }

    public PlayerFactory getPlayerFactory(){
        return playerFactory;
    }

    private void addFactories() {
        EntityFactory cloudFactory = new CloudFactory();
        registerFactory(cloudFactory, "cloud");

        EntityFactory terrainFactory = new TerrainFactory();
        registerFactory(terrainFactory, "terrain");

        EntityFactory endPointFactory = new EndPointFactory();
        registerFactory(endPointFactory, "endPoint");

        EntityFactory normalEnemyFactory = new NormalEnemyFactory();
        registerFactory(normalEnemyFactory, "normalEnemy");

        EntityFactory floatingEnemyFactory = new FloatingEnemyFactory();
        registerFactory(floatingEnemyFactory, "floatingEnemy");

        EntityFactory grassFactory = new GrassFactory();
        registerFactory(grassFactory, "grass");

    }

}
