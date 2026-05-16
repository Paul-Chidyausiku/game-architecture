package uk.ac.mmu.gamearchitecture.domain.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DiceRoll {

    private final List<Integer> diceValues;

    // constructor for multiple dice
    public DiceRoll(List<Integer> diceValues) {
        this.diceValues = diceValues;
    }
    // constructor for single value
    public DiceRoll(int value) {
        this.diceValues = new ArrayList<>();
        this.diceValues.add(value);
    }

    public List<Integer> getDiceValues() {
        return diceValues;
    }

    public int getValue() {
        return diceValues.stream().mapToInt(Integer::intValue).sum();
    }

    // another extra dice roll used by decorator
    public DiceRoll add(int value) {
        List<Integer> newDice = new ArrayList<>(diceValues);
        newDice.add(value);
        return new DiceRoll(newDice);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DiceRoll)) return false;
        DiceRoll that = (DiceRoll) obj;
        return diceValues.equals(that.diceValues);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(diceValues);
    }

    @Override
    public String toString() {
        return diceValues.toString() + " = " + getValue();
    }
}