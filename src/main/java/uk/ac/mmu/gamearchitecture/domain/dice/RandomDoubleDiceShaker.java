package uk.ac.mmu.gamearchitecture.domain.dice;

import java.util.List;
import java.util.Random;

public class RandomDoubleDiceShaker implements DiceShaker {

    private final Random random = new Random();

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public DiceRoll next() {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;

        return new DiceRoll(List.of(die1,  die2));
    }
}
