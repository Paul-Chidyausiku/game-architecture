package uk.ac.mmu.gamearchitecture.usecase.ports;

import uk.ac.mmu.gamearchitecture.domain.GameFactory;
import uk.ac.mmu.gamearchitecture.domain.GameType;

public interface GameFactoryProvider {
    GameFactory getGameFactory(GameType gameType);
}
