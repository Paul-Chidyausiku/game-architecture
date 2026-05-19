package uk.ac.mmu.gamearchitecture.infrastructure.driven;

import uk.ac.mmu.gamearchitecture.domain.GameFactory;
import uk.ac.mmu.gamearchitecture.domain.GameType;
import uk.ac.mmu.gamearchitecture.usecase.ports.GameFactoryProvider;

import java.util.Map;

public class SpringGameFactoryProvider implements GameFactoryProvider {

    private final Map<GameType, GameFactory> factories;

    public SpringGameFactoryProvider(Map<GameType, GameFactory> factories) {
        this.factories = factories;
    }

    @Override
    public GameFactory getGameFactory(GameType gameType) {
        return factories.get(gameType);
    }
}
