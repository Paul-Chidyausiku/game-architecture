package uk.ac.mmu.gamearchitecture.domain;

import uk.ac.mmu.gamearchitecture.domain.dice.DiceShaker;
import uk.ac.mmu.gamearchitecture.domain.dice.RandomDoubleDiceShaker;
import uk.ac.mmu.gamearchitecture.domain.rules.GameRule;
import uk.ac.mmu.gamearchitecture.domain.strategy.StandardWinStrategy;
import uk.ac.mmu.gamearchitecture.domain.strategy.WinStrategy;

import java.util.List;

public class LargeGameFactory implements GameFactory {

    @Override
    public int getBoardSize() {
        return 36;
    }

    @Override
    public DiceShaker createDiceShaker() {
        return new RandomDoubleDiceShaker();
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
    public List<Player> createPlayers(Board board) {
        Player red = new Player("Red", "Red", new Position(1), +1);
        Player blue = new Player("Blue", "Blue", new Position(31), +1);
        Player yellow = new Player("Yellow", "Yellow", new Position(36), -1);
        Player green = new Player("Green", "Green", new Position(6), -1);

        return List.of(red, blue, yellow, green);
    }

    @Override
    public List<GameRule> createRule(Player... players) {
        return List.of();
    }
}

