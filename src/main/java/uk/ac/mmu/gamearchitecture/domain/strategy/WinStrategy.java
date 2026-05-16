package uk.ac.mmu.gamearchitecture.domain.strategy;

import uk.ac.mmu.gamearchitecture.domain.Board;
import uk.ac.mmu.gamearchitecture.domain.Player;

public interface WinStrategy {
    boolean isWinner(Player player, Board board);
}

