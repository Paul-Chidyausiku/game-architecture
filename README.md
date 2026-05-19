# Dice Game Architecture 

## Introduction 

This project implements a configurable turn based dice board game using Java and SpringBoot. The software was originally designed using an object-oriented structure before being refactored into clean architecture using ports and adapters. 
The aim of the project was to create a maintainable and extensible software product capable of supporting multiple variations while remaining separating core game logic from infrastructure and external technologies. 
The system also supports save and replay functionality, event-driven behavior and dependency injection using SpringBoot. Design patterns and solid principles were applied throughout implementation to prove functionality and reduce coupling.  

## Variations and advanced features 

The project was designed to support multiple gameplay variations through configurable factories and rule composition. 

### Normal game 
The normal game provides the base implementation of the game using a standard board and two players. 
### Bounce game 
The bounce variation introduces a 'BounceRule' which changes player movement behavior when a player overshoots the final board position. 
### Hit game 
The hit game variation familiarizes player interaction using the 'HitRule' allowing gameplay behavior to change when players collide on the same board position. 
### Wormhole game 
The wormhole variation introduces teleportation behavior using the WormholeRule which would allow players to move from one position to another depending on the square they land on. 
### Large board game
The large board variation increases the board sizer and number of players. different player paths are generated dynamically to support the larger game configuration. 
### Combined game
The combined variation demonstrates extensibility by combining the multiple gameplay rules together within a single game run or instance. 
### Save and replay 
The product includes save and replay functionality implemented using clear architecture principles and an in-memory database Map system. The completed games are converted into "GameRecord" 
objects which act as value objects storing the important replay information for a completed game. 
Each 'GameRecord' stores: 
- Game type 
- Board size 
- number of players 
- Dice roll history

The save system uses an 'InMemoryDatabase' together with a GameDatabaseAdapter to storage responsibilities from, the core application logic. 
The save and replay use cases depend on abstraction interfaces rather than concrete database implementations following the Dependency inversion Principle. 
Replay functionality reconstructs the correct game variations using the stored 'GameType' and recreates the appropriate 'GameFactory'. The stored Dice roll history
is then replayed through the existing game logic using 'playTurnWithFixedRoll()', This allows completed games to be replayed without generating new random dice values. 
the use of an In-memory adapter also makes the architecture extensible because the storage implementation could later be replaced with alternative mechanisms such as JSON or file-based storage without modifying the core usecase logic.



