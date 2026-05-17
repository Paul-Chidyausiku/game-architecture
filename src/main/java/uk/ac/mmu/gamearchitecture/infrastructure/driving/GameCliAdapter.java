package uk.ac.mmu.gamearchitecture.infrastructure.driving;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uk.ac.mmu.gamearchitecture.domain.*;
import uk.ac.mmu.gamearchitecture.usecase.playgame.Provided;

@Component
public class GameCliAdapter implements CommandLineRunner {

    private final Provided playGame;

    public GameCliAdapter(Provided playGame) {
        this.playGame = playGame;
    }

    @Override
    public void run(String... args) {
        new Game(new NormalGameFactory()).start();

        System.out.println("\n=== Bounce Game ===");
        new Game(new BounceGameFactory()).start();

        System.out.println("\n=== Hit Game ===");
        new Game(new HitGameFactory()).start();

        System.out.println("\n=== Wormhole Game ===");
        new Game(new WormholeGameFactory()).start();

        System.out.println("\n=== Large Board Game ===");
        new Game(new LargeGameFactory()).start();

        System.out.println("\n=== Combined Game ===");
        new Game(new CombinedGameFactory()).start();
    }


}
