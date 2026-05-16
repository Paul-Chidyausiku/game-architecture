package uk.ac.mmu.gamearchitecture.domain;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomSelector implements PlayerSelector {

    private final List<Player> players;
    private final Random random = new Random();
    private Player lastPlayer;

    public RandomSelector(Player... players) {
        this.players = Arrays.asList(players);
    }

    @Override
    public Player next() {
        lastPlayer = players.get(random.nextInt(players.size()));
        return lastPlayer;
    }

    @Override
    public Player current() {
        return lastPlayer;
    }

    @Override
    public int size() {
        return players.size();
    }
}
