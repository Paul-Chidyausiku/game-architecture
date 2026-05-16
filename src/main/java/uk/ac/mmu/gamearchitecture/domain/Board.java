package uk.ac.mmu.gamearchitecture.domain;

public class Board {

    private final int size;

    public Board(int size) {
        this.size = size;
    }

    // returns the total number of positions on the board
    public int getSize() {
        return size;
    }

    public Position getRedStart() {
        return new Position(1);
    }

    public Position getRedEnd() {
        return new Position(size);
    }

    public Position getBlueStart() {
        return new Position(size);
    }

    public Position getBlueEnd() {
        return new Position(1);
    }

}
