package uk.ac.mmu.gamearchitecture.infrastructure.driven;

import uk.ac.mmu.gamearchitecture.domain.Position;

public class PlayerMovedEvent implements GameEvent{

    private final String playerName;
    private final Position from;
    private final Position to;

    public PlayerMovedEvent(String playerName, Position from, Position to) {
        this.playerName = playerName;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return playerName + " moved from " + from + " to " + to;
    }
}

