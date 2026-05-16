package uk.ac.mmu.gamearchitecture.domain;

import uk.ac.mmu.gamearchitecture.domain.dice.DiceRoll;
import uk.ac.mmu.gamearchitecture.domain.dice.DiceShaker;
import uk.ac.mmu.gamearchitecture.domain.rules.GameRule;
import uk.ac.mmu.gamearchitecture.domain.strategy.WinStrategy;
import uk.ac.mmu.gamearchitecture.infrastructure.driven.*;

import java.util.ArrayList;
import java.util.List;


public class TurnHandler {
    private final DiceShaker diceShaker;
    private final Board board;
    private final List<GameRule> rules;
    private final WinStrategy winStrategy;
    private final Game game;

    private final List<GameObserver> observers = new ArrayList<>();



    public TurnHandler(DiceShaker diceShaker, Board board, List<GameRule> rules, WinStrategy winStrategy, Game game) {
        this.diceShaker = diceShaker;
        this.board = board;
        this.rules = rules;
        this.winStrategy = winStrategy;
        this.game = game;
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(GameEvent event) {
        for (GameObserver observer : observers) {
            observer.onEvent(event);
        }
    }

    public boolean takeTurn(Player player) {

        notifyObservers(new TurnChangedEvent(
                player.getName(),
                player.getTurnsTaken() + 1
        ));

        DiceRoll roll = diceShaker.next();
        game.addDiceRoll(roll.getValue());

        notifyObservers(new DiceRolledEvent(
                player.getName(),
                roll
        ));

        Position before = player.getPosition();

        player.move(roll.getValue());

        notifyObservers(new PlayerMovedEvent(
                player.getName(),
                before, player.getPosition()
        ));

        // rule processing with loop protection
        // in case of infinite loop caused wormhole and hit rule when active together
        int maxApplications = 10;
        int count = 0;
        boolean changed;

        do {
            changed = false;

            for (GameRule rule : rules) {
                Position prev = player.getPosition();
                rule.apply(player, board, this);

                // notify the observers of movement caused the rules
                if(!player.getPosition().equals(prev)) {
                    notifyObservers(new PlayerMovedEvent(
                            player.getName(),
                            prev,
                            player.getPosition()
                    ));
                    changed = true;
                }
            }
            count++;
        } while (changed && count < maxApplications);

        if (winStrategy.isWinner(player, board)) {
            notifyObservers(new GameWonEvent(player.getName()));
            return true;
        }

        return false;
    }
}
