package uk.ac.mmu.gamearchitecture.domain.dice;

public interface DiceShaker {

    boolean hasNext();

    DiceRoll next();
}

