package uk.ac.mmu.gamearchitecture.domain;

import java.util.List;
import java.util.ArrayList;

public class GameRecord {

    private final GameType gameType;
    private final int boardSize;
    private final int numberOfPlayers;
    private List<Integer> diceRolls;


    public GameRecord(
            GameType gameType,
            int boardSize,
            int numberOfplayers,
            List<Integer> diceRolls

    ) {
        this.gameType = gameType;
        this.boardSize = boardSize;
        this.numberOfPlayers = numberOfplayers;
        this.diceRolls = new ArrayList<>(diceRolls);
    }

    public GameType getGameType() {
        return gameType;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public List<Integer> getDiceRolls() {
        return List.copyOf(diceRolls);
    }

}
