package uk.ac.mmu.gamearchitecture.domain.state;

import uk.ac.mmu.gamearchitecture.domain.Game;

public class ReadyState implements GameState{

    @Override
    public void handle(Game game) {
        game.setState(new PlayingState());
    }

    @Override
    public String getName() {
        return "Ready";
    }
}

