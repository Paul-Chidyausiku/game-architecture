package uk.ac.mmu.gamearchitecture.infrastructure.driven;

public class TurnChangedEvent implements GameEvent{

    private final String playerName;
    private final int turnNumber;

    public TurnChangedEvent(String playerName, int turnNumber) {
        this.playerName = playerName;
        this.turnNumber = turnNumber;
    }

    @Override
    public String toString() {
        return playerName + " Turn " + turnNumber;
    }
}
