package uk.ac.mmu.gamearchitecture.domain;

public interface PlayerSelector {
    Player next();
    Player current();
    int size();
}

