package uk.ac.mmu.gamearchitecture.infrastructure.driven;

import uk.ac.mmu.gamearchitecture.domain.GameRecord;

public class GameDatabaseAdapter implements
        uk.ac.mmu.gamearchitecture.usecase.playgame.Required,
        uk.ac.mmu.gamearchitecture.usecase.replaygame.Required {

    private final InMemoryGameDatabase database;

    public GameDatabaseAdapter(InMemoryGameDatabase database) {
        this.database = database;
    }

    @Override
    public int save(GameRecord record) {
        return database.save(record);
    }

    @Override
    public GameRecord load(int id) {
        return database.load(id);
    }
}
