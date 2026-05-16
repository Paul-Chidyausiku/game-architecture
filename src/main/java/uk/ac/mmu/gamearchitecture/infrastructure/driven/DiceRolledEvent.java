package uk.ac.mmu.gamearchitecture.infrastructure.driven;

import uk.ac.mmu.gamearchitecture.domain.dice.DiceRoll;

import java.util.List;

public class DiceRolledEvent implements GameEvent{
    private final String playerName;
    private final DiceRoll roll;

    public DiceRolledEvent(String playerName, DiceRoll roll) {
        this.playerName = playerName;
        this.roll = roll;
    }

    @Override
    public String toString() {

        List<Integer> dice = roll.getDiceValues();

        //  for single dice
        if (dice.size() == 1) {
            return playerName + " rolled " + dice.get(0);
        }

        // double dice
        if (dice.size() == 2) {
            int d1 = dice.get(0);
            int d2  = dice.get(1);

            return playerName + " rolled: " + d1 + " + " + d2 + " = " + (d1 + d2);

        }

        if (dice.size() == 3) {

            int d1 = dice.get(0);
            int d2 = dice.get(1);
            int extra = dice.get(2);

            int baseTotal = d1 + d2;
            int total = roll.getValue();

            return playerName + " rolled: " + d1 + " + " + d2 + " = " + baseTotal
                    + ", extra dice: " + extra + ", total: " + total;

        }

        return playerName + " rolled: " + roll.getValue();
    }
}
