package uk.ac.mmu.gamearchitecture.domain.state;

import uk.ac.mmu.gamearchitecture.domain.Game;

public interface GameState {
    void handle(Game context);
    String getName();
}

