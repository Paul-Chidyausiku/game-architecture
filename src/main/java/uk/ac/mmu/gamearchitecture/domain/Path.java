package uk.ac.mmu.gamearchitecture.domain;

import java.util.List;

public class Path {
    private final List<Position> positions;

    public Path(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public Position getStart() {
        return positions.get(0);
    }


    public Position move(Position current, int steps) {
        int index = positions.indexOf(current);
        int newIndex = index + steps;

        if (newIndex >= positions.size()) {
            newIndex = positions.size() - 1;
        }
        return positions.get(newIndex);
    }

    public String describe(String color) {
        StringBuilder sb = new StringBuilder();
        sb.append(color).append(" moves ");

        for (int i = 0; i < positions.size(); i ++) {
            Position p = positions.get(i);

            if (i == 0) {
                sb.append("Home (Position ").append(p.getValue()).append(")");
            }else if (i == positions.size() - 1) {
                sb.append(", End (Position ").append(p.getValue()).append(")");
            }else {
                sb.append(", ").append(p.getValue());
            }
        }return sb.toString();
    }
}

