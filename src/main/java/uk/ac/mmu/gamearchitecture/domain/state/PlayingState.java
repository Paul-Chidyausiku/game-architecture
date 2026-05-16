package uk.ac.mmu.gamearchitecture.domain.state;

import uk.ac.mmu.gamearchitecture.domain.Player;
import uk.ac.mmu.gamearchitecture.domain.Game;

public class PlayingState implements GameState{

    @Override
    public void handle(Game game) {
        Player current = game.getSelector().next();
        boolean won = game.getTurnHandler().takeTurn(current);

        if(won) {
            game.setState(new GameOverState());
        }
    }

    @Override
    public String getName() {
        return "InPlay";
    }
}
