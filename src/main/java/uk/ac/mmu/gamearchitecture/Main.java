package uk.ac.mmu.gamearchitecture;

import uk.ac.mmu.gamearchitecture.domain.BounceGameFactory;
import uk.ac.mmu.gamearchitecture.domain.CombinedGameFactory;
import uk.ac.mmu.gamearchitecture.domain.DiceGameFacade;
import uk.ac.mmu.gamearchitecture.domain.HitGameFactory;
import uk.ac.mmu.gamearchitecture.domain.LargeGameFactory;
import uk.ac.mmu.gamearchitecture.domain.NormalGameFactory;
import uk.ac.mmu.gamearchitecture.domain.WormholeGameFactory;

public class Main {

    public static void main(String[] args) {
        DiceGameFacade facade = new DiceGameFacade();

        facade.play(new NormalGameFactory());

        System.out.println("\n=== Bounce Game ===");
        facade.play(new BounceGameFactory());

        System.out.println("\n=== Hit Game ===");
        facade.play(new HitGameFactory());

        System.out.println("\n=== Wormhole Game ===");
        facade.play(new WormholeGameFactory());

        System.out.println("\n=== Large Board Game ===");
        facade.play(new LargeGameFactory());

        System.out.println("\n=== Combined Game ===");
        facade.play(new CombinedGameFactory());
    }
}