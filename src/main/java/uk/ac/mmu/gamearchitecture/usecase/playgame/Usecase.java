package uk.ac.mmu.gamearchitecture.usecase.playgame;

import uk.ac.mmu.gamearchitecture.domain.Game;
import uk.ac.mmu.gamearchitecture.domain.GameFactory;
import uk.ac.mmu.gamearchitecture.domain.GameRecord;

public class Usecase implements Provided{

    private final GameFactory factory;
    private final Required required;

    public Usecase(GameFactory factory, Required required) {
        this.factory = factory;
        this.required = required;
    }

    @Override
    public int play() {
        Game game = new Game(factory);
        game.start();

        GameRecord record = new GameRecord((game.getDiceHistory()));
        int id = required.save (record);

        System.out.println("Game id: " + id + "saved ");
        return id;

    }
}
