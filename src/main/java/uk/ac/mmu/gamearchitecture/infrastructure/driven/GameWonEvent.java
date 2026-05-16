package uk.ac.mmu.gamearchitecture.infrastructure.driven;

public class GameWonEvent implements GameEvent{

    private final String playerName;

    public GameWonEvent(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return playerName + " wins! ";
    }
}
