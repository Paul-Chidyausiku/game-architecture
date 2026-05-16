package uk.ac.mmu.gamearchitecture.domain;

public class DiceGameFacade implements StatelessFacade {

    @Override
    public void play(GameFactory factory) {

        Game game = new Game(factory);

        game.start();
    }

}
