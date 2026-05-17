package uk.ac.mmu.gamearchitecture.usecase.playgame;

import uk.ac.mmu.gamearchitecture.domain.Game;
import uk.ac.mmu.gamearchitecture.domain.GameFactory;

public class Usecase implements Provided{

    private final GameFactory factory;

    public Usecase(GameFactory factory) {
        this.factory = factory;
    }

    @Override
    public void play() {
        Game game = new Game(factory);
        game.start();
    }
}
