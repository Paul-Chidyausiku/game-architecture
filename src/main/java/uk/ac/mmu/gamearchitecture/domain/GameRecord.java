package uk.ac.mmu.gamearchitecture.domain;

import java.util.List;
import java.util.ArrayList;
public class GameRecord {
    private List<Integer> diceRolls;

    public GameRecord(List<Integer> diceRolls) {
        this.diceRolls = new ArrayList<>(diceRolls);
    }

    public List<Integer> getDiceRolls() {
        return diceRolls;
    }

}
