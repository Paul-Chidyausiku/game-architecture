package uk.ac.mmu.gamearchitecture.domain;

public class Player {

    private final String name;
    private final String color;
    private final int direction; //+1 for Red -1 for Blue
    private Position position;
    private Position previousPosition;
    private int turnsTaken;
    private Path path;

    //Creating a new player
    //Constructor to initialize name, startPosition, direction & Turns taken
    public Player(String name, String color,Position startPosition, int direction) {
        this.name = name;
        this.color = color;
        this.position = startPosition;
        this.direction = direction;
        this.turnsTaken = 0;
        this.path = null;

    }
    /***
     * @param steps/number rolled on dice
     */

    public void move(int steps) {
        previousPosition = position;

        if (path != null) {
            position = path.move(position, steps);
        }else {
            position = position.move(steps * direction);
        }
        turnsTaken++;
    }

    public void setPath(Path path) {
        this.path = path;
        this.position = path.getStart();
    }

    public void undoMove() {
        position = previousPosition;
    }
    //Used when a wormhole teleports the player
    public void setPosition(Position position) {
        this.position = position;
    }
    // Getters for direction, turns taken, position and name
    public String getName(){
        return name;
    }
    public String getColor() {return color;}
    public Position getPosition() {
        return position;
    }
    public int getDirection() {
        return direction;
    }
    public int getTurnsTaken() {
        return turnsTaken;
    }

    public Path getPath() {
        return path;
    }
}

