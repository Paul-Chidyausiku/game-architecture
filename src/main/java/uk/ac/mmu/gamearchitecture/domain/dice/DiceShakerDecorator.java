package uk.ac.mmu.gamearchitecture.domain.dice;

public abstract class DiceShakerDecorator implements DiceShaker{

    protected final DiceShaker inner;

    public DiceShakerDecorator(DiceShaker inner) {
        this.inner = inner;
    }

    @Override
    public boolean hasNext() {
        return inner.hasNext();
    }
}