package uk.ac.mmu.gamearchitecture.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class GameManager {

    private static int idCounter = 1;
    private static Map<Integer, GameRecord> games = new HashMap<>();

    public static int save(GameRecord game) {
        int id = idCounter++;
        games.put(id, game);
        return id;
    }

    public static GameRecord load(int id) {
        return games.get(id);
    }

    public static void replayGame(int id) {
        GameRecord record = load(id);
        if (record == null) {
            System.out.println("Game not found ");
            return;
        }

        System.out.println("Replaying game " + id);

        Game game = new Game(new NormalGameFactory());

        List<Integer> rolls = record.getDiceRolls();

        for(int roll : rolls) {
            if (game.isGameOver()) break;
            game.playTurnWithFixedRoll(roll);
        }



    }
}

