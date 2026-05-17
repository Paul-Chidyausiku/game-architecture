package uk.ac.mmu.gamearchitecture.domain;

import uk.ac.mmu.gamearchitecture.domain.dice.DiceRoll;
import uk.ac.mmu.gamearchitecture.domain.dice.DiceShaker;
import uk.ac.mmu.gamearchitecture.domain.rules.GameRule;
import uk.ac.mmu.gamearchitecture.domain.state.GameOverState;
import uk.ac.mmu.gamearchitecture.domain.state.GameState;
import uk.ac.mmu.gamearchitecture.domain.state.ReadyState;
import uk.ac.mmu.gamearchitecture.domain.strategy.WinStrategy;
import uk.ac.mmu.gamearchitecture.infrastructure.driven.ConsoleObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final Board board;
    private final DiceShaker diceShaker;
    private final List<Player> players;
    private final PlayerSelector selector;
    private final WinStrategy winStrategy;
    private final List<GameRule> rules;
    private final TurnHandler turnHandler;
    private int totalTurns;
    private GameState state = new ReadyState();
    private Path path;
    private boolean replayMode = false;

    private final List<Integer> diceHistory = new ArrayList<>();
    private int rollIndex = 0;

    public int getNextGameRoll() {
        if (rollIndex < diceHistory.size()) {
            return diceHistory.get(rollIndex++);
        }else {
            DiceRoll diceRoll = diceShaker.next();
            int roll = diceRoll.getValue();
            addDiceRoll(roll);
            return roll;
        }
    }

    public Game(GameFactory factory) {
        // Creates a 5x5 board
        board = new Board(factory.getBoardSize());

        //creates players using the boards start positions
        players = factory.createPlayers(board);

        if (players.size() ==2) {
            assignNormalPaths();
        }else if (players.size() == 4) {
            assignLargeBoardPaths();
        }

        diceShaker = factory.createDiceShaker();
        selector = factory.createPlayerSelector(players.toArray(new Player[0]));
        winStrategy = factory.createWinStrategy();
        rules = factory.createRule(players.toArray(new Player[0]));

        turnHandler = new TurnHandler(diceShaker, board, rules, winStrategy, this);

        turnHandler.addObserver(new ConsoleObserver());

    }

    private void assignNormalPaths() {

        for (Player player : players) {
            boolean forward = player.getDirection() == +1;
            Path playerPath = createBoustrophedonPath(board.getSize(), forward);
            player.setPath(playerPath);
        }
    }

    private void assignLargeBoardPaths() {
        Path base = createBoustrophedonPath(36, true);

        for (Player player : players) {
            switch (player.getColor()) {
                case "Red": player.setPath(createShiftedPath(base, 1, false));
                    break;
                case "Blue": player.setPath(createShiftedPath(base, 31, false));
                    break;
                case "Yellow": player.setPath(createShiftedPath(base, 36, true));
                    break;
                case "Green": player.setPath(createShiftedPath(base, 6, true));
                    break;
            }
        }
    }

    public PlayerSelector getSelector() {
        return selector;
    }

    public TurnHandler getTurnHandler() {
        return turnHandler;
    }


    public int getTotalTurns() {
        return players.stream().mapToInt(Player::getTurnsTaken).sum();
    }
    public List<Integer> getDiceHistory() {
        return List.copyOf(diceHistory);
    }
    public void setState(GameState newState) {
        System.out.println("Game State " + this.state.getName() + " → " + newState.getName());
        this.state = newState;
    }

    public boolean isGameOver() {
        return state instanceof GameOverState;
    }



    public void resetReplay() {
        rollIndex = 0;
    }

    public void setReplayMode(boolean replayMode) {
        this.replayMode = replayMode;
    }


    public void addDiceRoll(int roll) {
        diceHistory.add(roll);
    }

    public boolean checkWin() {
        Player player = selector.current(); // or however you access the current player
        return winStrategy.isWinner(player, board);
    }

    public void playTurnWithFixedRoll(int roll) {
        Player player = selector.next();
        System.out.println(player.getColor() + " rolled: " + roll);
        Position before = player.getPosition();
        player.move(roll);

        for (GameRule rule : rules) {
            rule.apply(player, board, turnHandler);
        }
        if (winStrategy.isWinner(player, board)) {
            System.out.println(player.getColor() + " wins! ");
        }
    }

    private Path createBoustrophedonPath(int size, boolean forward) {
        List<Position> positions = new ArrayList<>();

        int dimension = (int) Math.sqrt(size);

        for (int row = 0; row < dimension; row++) {

            int start = row * dimension + 1;
            int end = start + dimension - 1;

            if (row % 2 == 0) {
                for (int i = start; i <=end; i++) {
                    positions.add(new Position(i));
                }
            }else {
                for (int i = end; i >= start; i--) {
                    positions.add(new Position(i));
                }
            }
        }
        if (!forward) {
            Collections.reverse(positions);
        }
        return new Path(positions);
    }

    private Path createShiftedPath(Path basePath, int startValue, boolean reverse) {

        List<Position> base = new ArrayList<>(basePath.getPositions());

        if (reverse) {
            Collections.reverse(base);
        }

        int startIndex = 0;
        for (int i = 0; i < base.size(); i ++) {
            if (base.get(i).getValue() == startValue) {
                startIndex = i;
                break;
            }
        }
        List<Position> rotated = new ArrayList<>();

        for (int i = startIndex; i < base.size(); i++) {
            rotated.add(base.get(i));
        }

        for (int i = 0; i < startIndex; i++) {
            rotated.add(base.get(i));
        }
        return new Path(rotated);
    }

    //This starts and runs the base game
    public void start() {

        System.out.println("Game Started");
        state.handle(this);
        System.out.println("Board size: " + board.getSize());
        for (Player player : players) {
            System.out.println(player.getPath().describe(player.getColor()));
        }
        System.out.print("Game rules: ");

        // if statement to determine what game rule variations are active
        if (rules.isEmpty()) {
            System.out.println("None");
        }else {
            for (GameRule rule : rules) {
                System.out.print(rule.getClass().getSimpleName() + " ");
            }
            System.out.println();
        }

        // outputs the red and blue players starting position into a readable format
        for (Player player : players) {
            System.out.println(player.getColor() +
                    " player starting position " + player.getPosition());
        }
        System.out.println();

        // loop through each players turn until the game ends
        while (!(state instanceof GameOverState)) {
            state.handle(this);
        }

        System.out.println("Dice rolls: " + diceHistory);

        // printing readable text
        System.out.println("\nTurn Summary");
        totalTurns = getTotalTurns();
        System.out.println("Total turns taken: " + totalTurns);



    }
}