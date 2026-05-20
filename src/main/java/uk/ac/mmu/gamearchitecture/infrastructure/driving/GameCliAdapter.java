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
        runAndReplay(GameType.NORMAL, "Normal Game");
        runAndReplay(GameType.BOUNCE, "Bounce Game");
        runAndReplay(GameType.HIT, "Hit Game");
        runAndReplay(GameType.WORMHOLE, "Wormhole Game");
        runAndReplay(GameType.LARGE, "Large Board Game");
        runAndReplay(GameType.COMBINED, "Combined Game");
    }

    private void runAndReplay(GameType gameType, String title) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("PLAYING: " + title);
        System.out.println("==================================================");

        int id = playGame.play(gameType);

        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("REPLAYING: " + title + " | Game ID: " + id);
        System.out.println("--------------------------------------------------");

        replayGame.replay(id);

        System.out.println();
    }

}
