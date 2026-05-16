package uk.ac.mmu.gamearchitecture.domain.rules;

import uk.ac.mmu.gamearchitecture.domain.Board;
import uk.ac.mmu.gamearchitecture.domain.Player;
import uk.ac.mmu.gamearchitecture.domain.TurnHandler;

public class HitRule extends RuleSelector {

    private final Player[] players;

    public HitRule(Player... players) {
        this.players = players;
    }

    @Override
    public void apply(Player player, Board board, TurnHandler handler) {

        for (Player other : players) {
            if (other != player && other.getPosition().equals(player.getPosition())) {
                System.out.println(player.getName() + " hit " + other.getName()
                        + " at position " + player.getPosition());

                player.undoMove();
            }
        }
    }
}

