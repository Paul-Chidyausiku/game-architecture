package uk.ac.mmu.gamearchitecture.infrastructure.driven;

import uk.ac.mmu.gamearchitecture.domain.GameRecord;

import java.util.HashMap;
import java.util.Map;

public class InMemoryGameDatabase {

    private int idCounter = 1;
    private final Map<Integer, GameRecord> games = new HashMap<>();

    public int save(GameRecord record) {
        int id = idCounter++;
        games.put(id, record);
        return id;
    }

    public GameRecord load(int id) {
        return games.get(id);
    }
}
