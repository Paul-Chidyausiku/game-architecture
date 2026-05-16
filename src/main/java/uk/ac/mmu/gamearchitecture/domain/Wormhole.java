package uk.ac.mmu.gamearchitecture.domain;

public class Wormhole {

    private final Position entry;
    private final Position exit;

    public Wormhole(Position entry, Position exit) {
        this.entry = entry;
        this.exit = exit;
    }

    public boolean isEntry(Position position) {
        return entry.equals(position);
    }

    public Position getExit() {
        return exit;
    }

    public Position getEntry() {
        return entry;
    }
}

