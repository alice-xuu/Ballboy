# Overview

A basic ballboy game written in JavaFX. Try to reach the finish without colliding with the enemies!

# Getting Started

#### Running

`gradle run`

#### Building

`gradle build`

#### Testing

`gradle test`

#### Format

Json Format: list of "levels", then each level has

- "levelData" with height, width, floorHeight
- "grass" with height, width, x, y and imagePath to define appearance
- "ballboy" with size, x, y
- "endPoint" with x, y
- "cloud" with a list with each set containing x, y and cloudVelocity
- "terrain", "normalEnemy" and "floatingEnemy" in the same format as a list with each set having x and y.

To change JSON file, edit configPath in App.java

Example JSON configurations:

normalEnemyOnlyConfig demonstrates:

- player resetting to originally configured position when touching an enemy
- player size set to small
- player can accelerate left and right until top speed is reached
- reaching the endPoint (the person) closes the game
- ball continually bounces on the floor
- enemy on enemy collisions
- camera follow horizontal and vertical player movement

terrainOnlyConfig demonstrates:

- immobile objects player can bounce off
- player on terrain collisions
- player movement controls including boost height with up arrow key to get onto the first terrain
- player size set to large

config demonstrates:

- Floating enemy on terrain collisions
- different enemies have different movement personalities
- player resets to beginning on all enemy collisions
- player size set to medium
- enemy on enemy collisions
- cloud constant velocity movement
- ballboy can't interact with clouds

Design patterns:
Move Strategy pattern: MovementStrategy, FloatingEnemyMoveStrat, NormalEnemyMoveStrat, CloudMoveStrat, PlayerMovementStrategy, BallMoveStrat
Collision Strategy pattern: CollisionStrategy, SimpleCollisionStrat, CollisionStrat

Factory Pattern:

- Product: Entity
- Concrete Product: EndPoint, Cloud, Grass, Terrain, NormalEnemy, FloatingEnemy
- Creator: EntityFactory
- ConcreteCreator: EndPointFactory, CloudFactory, GrassFactory, TerrainFactory, NormalEnemyFactory, FloatingEnemyFactory
- Factory Registry: EntityRegistry

#### Screenshot

<img width="642" alt="Screen Shot 2024-05-28 at 9 46 43 pm" src="https://github.com/alice-xuu/Ballboy/assets/61668791/54ebccd5-cce5-4aef-b322-748e91916595">



