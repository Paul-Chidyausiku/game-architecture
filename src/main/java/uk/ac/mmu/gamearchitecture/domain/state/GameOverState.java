package uk.ac.mmu.gamearchitecture.domain.state;

import uk.ac.mmu.gamearchitecture.domain.Game;

public class GameOverState implements GameState{

    @Override
    public void handle(Game game) {
        System.out.println("Game State: InPLay → GameOver");
    }

    @Override
    public String getName() {
        return "GameOver";
    }
}


