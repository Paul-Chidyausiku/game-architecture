package uk.ac.mmu.gamearchitecture.usecase.replaygame;

import uk.ac.mmu.gamearchitecture.domain.Game;
import uk.ac.mmu.gamearchitecture.domain.GameFactory;
import uk.ac.mmu.gamearchitecture.domain.GameRecord;
import uk.ac.mmu.gamearchitecture.usecase.ports.GameFactoryProvider;

public class Usecase implements Provided{
    private final GameFactoryProvider factoryProvider;
    private final Required required;

    public Usecase(GameFactoryProvider factoryProvider, Required required) {
        this.factoryProvider = factoryProvider;
        this.required = required;
    }

    @Override
    public void replay(int id) {
        GameRecord record = required.load(id);

        if (record == null) {
            System.out.println("Game not found");
            return;
        }

        System.out.println("\n=== Replay Game id: " + id + "===");
        System.out.println("Game record: " + record.toString());
        System.out.println("Board size: " + record.getBoardSize());
        System.out.println("Players: " + record.getNumberOfPlayers());
        System.out.println("Dice rolls: " + record.getDiceRolls());

        GameFactory factory = factoryProvider.getGameFactory(record.getGameType());
        Game game = new Game(factory);

        for (int roll : record.getDiceRolls()) {
            if (game.isGameOver()) {
                break;
            }
            game.playTurnWithFixedRoll(roll);
        }
    }
}
