package uk.ac.mmu.gamearchitecture.domain.rules;

import uk.ac.mmu.gamearchitecture.domain.Board;
import uk.ac.mmu.gamearchitecture.domain.Player;
import uk.ac.mmu.gamearchitecture.domain.Position;
import uk.ac.mmu.gamearchitecture.domain.TurnHandler;

public class BounceRule extends OvershootRule {

    @Override
    public void apply(Player player, Board board, TurnHandler handler) {
        int size = board.getSize();
        int pos = player.getPosition().getValue();

        if(player.getDirection() == 1 && pos > size) {
            int overshoot = pos - size;
            player.setPosition(new Position(size - overshoot));
        }
        if (player.getDirection() == -1 && pos < 1) {
            int overshoot = 1 - pos;
            player.setPosition(new Position(1 + overshoot));
        }
    }
}
