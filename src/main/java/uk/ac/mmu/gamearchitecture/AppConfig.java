package uk.ac.mmu.gamearchitecture;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.ac.mmu.gamearchitecture.domain.GameFactory;
import uk.ac.mmu.gamearchitecture.domain.NormalGameFactory;
import uk.ac.mmu.gamearchitecture.usecase.playgame.Provided;
import uk.ac.mmu.gamearchitecture.usecase.playgame.Required;
import uk.ac.mmu.gamearchitecture.usecase.playgame.Usecase;

@Configuration
public class AppConfig {

    @Bean
    GameFactory createGameFactory() {
        return new NormalGameFactory();
    }

    @Bean
    Provided createPlayGame(GameFactory factory, Required required) {
        return new Usecase(factory, required);
    }
}
