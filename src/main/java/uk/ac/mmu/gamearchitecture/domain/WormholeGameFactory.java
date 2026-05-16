package uk.ac.mmu.gamearchitecture.domain;

import uk.ac.mmu.gamearchitecture.domain.dice.DiceShaker;
import uk.ac.mmu.gamearchitecture.domain.dice.RandomDoubleDiceShaker;
import uk.ac.mmu.gamearchitecture.domain.rules.GameRule;
import uk.ac.mmu.gamearchitecture.domain.rules.WormholeRule;
import uk.ac.mmu.gamearchitecture.domain.strategy.StandardWinStrategy;
import uk.ac.mmu.gamearchitecture.domain.strategy.WinStrategy;

import java.util.List;

public class WormholeGameFactory implements GameFactory {

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
    public List<GameRule> createRule(Player... players) {

        List<Wormhole> wormholes = List.of(
                new Wormhole(new Position(4), new Position(9)),
                new Wormhole( new Position(19), new Position(23))
        );
        return List.of(new WormholeRule(wormholes));
    }
}

