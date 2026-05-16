package uk.ac.mmu.gamearchitecture.domain.dice;

import java.util.Random;

public class ExtraDiceDecorator extends DiceShakerDecorator{

    private final Random random = new Random();

    public ExtraDiceDecorator(DiceShaker inner) {
        super(inner);
    }

    @Override
    public DiceRoll next() {
        DiceRoll baseRoll = inner.next();
        int extra = random.nextInt(6) + 1;

        return baseRoll.add(extra);
    }
}

