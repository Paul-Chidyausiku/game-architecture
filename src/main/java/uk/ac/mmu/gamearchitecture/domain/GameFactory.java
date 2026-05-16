package uk.ac.mmu.gamearchitecture.domain;

import uk.ac.mmu.gamearchitecture.domain.dice.DiceShaker;
import uk.ac.mmu.gamearchitecture.domain.rules.GameRule;
import uk.ac.mmu.gamearchitecture.domain.strategy.WinStrategy;

import java.util.List;

public interface GameFactory {

    int getBoardSize();

    List<Player> createPlayers(Board board);

    DiceShaker createDiceShaker();
    PlayerSelector createPlayerSelector(Player... players);
    WinStrategy createWinStrategy();
    List<GameRule> createRule(Player... players);

}
