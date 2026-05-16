package uk.ac.mmu.gamearchitecture.domain.rules;

import uk.ac.mmu.gamearchitecture.domain.Board;
import uk.ac.mmu.gamearchitecture.domain.Player;
import uk.ac.mmu.gamearchitecture.domain.Position;
import uk.ac.mmu.gamearchitecture.domain.Wormhole;
import uk.ac.mmu.gamearchitecture.infrastructure.driven.WormholeEvent;
import uk.ac.mmu.gamearchitecture.domain.TurnHandler;

import java.util.List;

public class WormholeRule extends RuleSelector {

    private final List<Wormhole> wormholes;

    public WormholeRule(List<Wormhole> wormholes) {
        this.wormholes = wormholes;
    }

    @Override
    public void apply(Player player, Board board, TurnHandler handler) {
        for (Wormhole wormhole : wormholes) {
            if (wormhole.isEntry(player.getPosition())) {
                Position entry = player.getPosition();
                player.setPosition(wormhole.getExit());
                Position exit = player.getPosition();
                handler.notifyObservers(
                        new WormholeEvent(
                                player.getName(),
                                entry,
                                exit
                        )
                );
            }
        }
    }
}

