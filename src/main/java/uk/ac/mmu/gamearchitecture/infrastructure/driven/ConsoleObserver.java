package uk.ac.mmu.gamearchitecture.infrastructure.driven;

public class ConsoleObserver implements GameObserver{

    @Override
    public void onEvent(GameEvent event) {
        System.out.println(event);
    }
}