package uk.ac.mmu.gamearchitecture.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ReverseSelector implements PlayerSelector {

    private final List<Player> players;
    private int index = 0;

    public ReverseSelector(Player... players) {
        this.players = Arrays.asList(players);
        Collections.reverse(this.players);
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

