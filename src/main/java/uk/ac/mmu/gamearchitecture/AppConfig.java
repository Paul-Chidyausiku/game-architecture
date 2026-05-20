package uk.ac.mmu.gamearchitecture;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.ac.mmu.gamearchitecture.domain.*;
import uk.ac.mmu.gamearchitecture.infrastructure.driven.GameDatabaseAdapter;
import uk.ac.mmu.gamearchitecture.infrastructure.driven.InMemoryGameDatabase;
import uk.ac.mmu.gamearchitecture.infrastructure.driven.SpringGameFactoryProvider;
import uk.ac.mmu.gamearchitecture.usecase.ports.GameFactoryProvider;

import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    InMemoryGameDatabase createInMemoryDatabase() {
        return new InMemoryGameDatabase();
    }

    @Bean
    GameDatabaseAdapter createGameDatabaseAdapter(InMemoryGameDatabase database) {
        return new GameDatabaseAdapter(database);
    }

    @Bean
    GameFactoryProvider createGameFactoryProvider() {
        Map<GameType, GameFactory> factories = Map.of(
                GameType.NORMAL, new NormalGameFactory(),
                GameType.BOUNCE, new BounceGameFactory(),
                GameType.HIT, new HitGameFactory(),
                GameType.WORMHOLE, new WormholeGameFactory(),
                GameType.LARGE, new LargeGameFactory(),
                GameType.COMBINED, new CombinedGameFactory()
        );
        return new SpringGameFactoryProvider(factories);
    }


    @Bean
    uk.ac.mmu.gamearchitecture.usecase.playgame.Provided createPlayGame(
            GameFactoryProvider factoryProvider,
            GameDatabaseAdapter adapter
    ) {
        return new uk.ac.mmu.gamearchitecture.usecase.playgame.Usecase(factoryProvider, adapter);
    }

    @Bean
    uk.ac.mmu.gamearchitecture.usecase.replaygame.Provided createReplayGame(
            GameFactoryProvider factoryProvider,
            GameDatabaseAdapter adapter
    ) {
        return new uk.ac.mmu.gamearchitecture.usecase.replaygame.Usecase(factoryProvider, adapter);
    }
}
