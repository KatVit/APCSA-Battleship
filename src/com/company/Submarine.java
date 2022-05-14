package com.company;

public class Submarine extends Ship {
    private Position[] positions = new Position[3];

    public int getLength() {
        return 3;
    }

    public String getName() {
        return "Submarine";
    }

    public void addPosition(int i, Position a) {
        positions[i] = a;
    }

    public Position[] getPosition() {
        return positions;
    }
}
