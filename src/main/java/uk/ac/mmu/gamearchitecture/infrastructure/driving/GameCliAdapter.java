package uk.ac.mmu.gamearchitecture.infrastructure.driving;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uk.ac.mmu.gamearchitecture.domain.GameType;

@Component
public class GameCliAdapter implements CommandLineRunner {

    private final uk.ac.mmu.gamearchitecture.usecase.playgame.Provided playGame;
    private final uk.ac.mmu.gamearchitecture.usecase.replaygame.Provided replayGame;


    public GameCliAdapter(
            uk.ac.mmu.gamearchitecture.usecase.playgame.Provided playGame,
            uk.ac.mmu.gamearchitecture.usecase.replaygame.Provided replayGame
    ) {
        this.playGame = playGame;
        this.replayGame = replayGame;
    }


    @Override
    public void run(String... args) {
        int normalId = playGame.play(GameType.NORMAL);
        replayGame.replay(normalId);

        int bounceId = playGame.play(GameType.BOUNCE);
        replayGame.replay(bounceId);

        int hitId = playGame.play(GameType.HIT);
        replayGame.replay(hitId);

        int wormholeId = playGame.play(GameType.WORMHOLE);
        replayGame.replay(wormholeId);

        int largeId = playGame.play(GameType.LARGE);
        replayGame.replay(largeId);

        int combinedId = playGame.play(GameType.COMBINED);
        replayGame.replay(combinedId);
    }



}
