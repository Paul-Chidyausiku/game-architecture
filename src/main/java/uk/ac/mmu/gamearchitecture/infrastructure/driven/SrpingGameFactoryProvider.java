package uk.ac.mmu.gamearchitecture.infrastructure.driven;

import uk.ac.mmu.gamearchitecture.domain.GameFactory;
import uk.ac.mmu.gamearchitecture.domain.GameType;
import uk.ac.mmu.gamearchitecture.usecase.ports.GameFactoryProvider;

import java.util.Map;

public class SrpingGameFactoryProvider implements GameFactoryProvider {

    private final Map<GameType, GameFactory> factories;

    public SrpingGameFactoryProvider(Map<GameType, GameFactory> factories) {
        this.factories = factories;
    }

    @Override
    public GameFactory getGameFactory(GameType gameType) {
        return factories.get(gameType);
    }
}
