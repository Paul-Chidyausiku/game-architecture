package uk.ac.mmu.gamearchitecture.usecase.playgame;

import uk.ac.mmu.gamearchitecture.domain.*;
import uk.ac.mmu.gamearchitecture.usecase.ports.GameFactoryProvider;

public class Usecase implements Provided{

    private final GameFactoryProvider factoryProvider;
    private final Required required;

    public Usecase(GameFactoryProvider factoryProvider, Required required) {
        this.factoryProvider = factoryProvider;
        this.required = required;
    }

    @Override
    public int play(GameType gameType) {
        GameFactory factory = factoryProvider.getGameFactory(gameType);
        Game game = new Game(factory);

        game.start();

        GameRecord record = new GameRecord(
                gameType,
                game.getBoardSize(),
                game.getNumberOfPlayers(),
                game.getDiceHistory()
        );
        int id = required.save (record);

        System.out.println("Game id: " + id + "saved ");
        return id;

    }

}
