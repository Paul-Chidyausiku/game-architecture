package uk.ac.mmu.gamearchitecture.infrastructure.driven;

import uk.ac.mmu.gamearchitecture.domain.Position;

public class WormholeEvent implements GameEvent{

    private final String playerName;
    private final Position entry;
    private final Position exit;

    public WormholeEvent(String playerName, Position entry, Position exit) {
        this.playerName = playerName;
        this.entry = entry;
        this.exit = exit;
    }

    @Override
    public String toString() {
        return playerName + " enters wormhole at " + entry + " and teleports to " + exit;
    }
}

