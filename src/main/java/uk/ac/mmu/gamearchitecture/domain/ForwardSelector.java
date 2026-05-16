package uk.ac.mmu.gamearchitecture.domain;

import java.util.Arrays;
import java.util.List;

public class ForwardSelector implements PlayerSelector {

    private final List<Player> players;
    private int index = 0;

    public ForwardSelector(Player... players) {
        this.players = Arrays.asList(players);
    }

    @Override
    public Player next() {
        Player player = players.get(index);
        index = (index + 1) % players.size();
        return player;
    }

    @Override
    public Player current() {
        int currentIndex = (index - 1 + players.size()) % players.size();
        return players.get(currentIndex);
    }

    @Override
    public int size() {
        return players.size();
    }
}
