package uk.ac.mmu.gamearchitecture.domain;

import uk.ac.mmu.gamearchitecture.domain.dice.DiceShaker;
import uk.ac.mmu.gamearchitecture.domain.dice.RandomDoubleDiceShaker;
import uk.ac.mmu.gamearchitecture.domain.rules.BounceRule;
import uk.ac.mmu.gamearchitecture.domain.rules.GameRule;
import uk.ac.mmu.gamearchitecture.domain.strategy.StandardWinStrategy;
import uk.ac.mmu.gamearchitecture.domain.strategy.WinStrategy;

import java.util.List;


public class BounceGameFactory implements GameFactory {

    @Override
    public DiceShaker createDiceShaker() {
        return new RandomDoubleDiceShaker();
    }

    @Override
    public int getBoardSize() {
        return 25;
    }

    @Override
    public List<Player> createPlayers(Board board) {
        Player red = new Player("Red", "Red", board.getRedStart(), +1);
        Player blue = new Player("Blue", "Blue", board.getBlueStart(), -1);
        return List.of(red, blue);
    }

    @Override
    public PlayerSelector createPlayerSelector(Player... players) {
        return new ForwardSelector(players);
    }

    @Override
    public WinStrategy createWinStrategy() {
        return new StandardWinStrategy();
    }

    @Override
    public List<GameRule> createRule(Player... player) {
        return List.of(new BounceRule());
    }


}
