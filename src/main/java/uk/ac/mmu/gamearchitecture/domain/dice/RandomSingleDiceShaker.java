package uk.ac.mmu.gamearchitecture.domain.dice;

import java.util.Random;
public class RandomSingleDiceShaker implements DiceShaker {

    private final Random random = new Random();

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public DiceRoll next() {

        int roll = random.nextInt(6) + 1;

        return new DiceRoll(roll);
    }
}

