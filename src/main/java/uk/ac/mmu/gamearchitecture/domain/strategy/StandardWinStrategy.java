package uk.ac.mmu.gamearchitecture.domain.strategy;

import uk.ac.mmu.gamearchitecture.domain.Board;
import uk.ac.mmu.gamearchitecture.domain.Player;
import uk.ac.mmu.gamearchitecture.domain.Position;

import java.util.List;

public class StandardWinStrategy implements WinStrategy {

    @Override
    public boolean isWinner(Player player, Board board ) {

        if (player.getPath() != null) {
            List<Position> positions = player.getPath().getPositions();
            Position end = positions.get(positions.size() - 1);
            return player.getPosition().equals(end);
        }

        int pos = player.getPosition().getValue();

        if (player.getDirection() ==1) {
            return pos >= board.getSize();
        }else {
            return pos <=1;
        }
    }
}

