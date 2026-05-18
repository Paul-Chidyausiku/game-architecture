package uk.ac.mmu.gamearchitecture.usecase.replaygame;

import uk.ac.mmu.gamearchitecture.domain.GameRecord;

public interface Required {
    GameRecord load(int id);
}