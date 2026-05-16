package uk.ac.mmu.gamearchitecture.domain.rules;

import uk.ac.mmu.gamearchitecture.domain.Board;
import uk.ac.mmu.gamearchitecture.domain.Player;
import uk.ac.mmu.gamearchitecture.domain.TurnHandler;

public interface GameRule {
    void apply(Player player, Board board, TurnHandler handler);
}
