package uk.ac.mmu.gamearchitecture.domain;

import java.util.Objects;

public class Position {

    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Position move(int steps) {
        return new Position(value + steps);
    }

    public Position add(int amount) {
        return new Position(value + amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position that = (Position) obj;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return String.format("%d", value);
    }
}