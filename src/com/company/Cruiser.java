package com.company;

public class Cruiser extends Ship {
    private Position[] positions = new Position[4];

    public int getLength() {
        return 4;
    }

    public String getName() {
        return "Cruiser";
    }

    public void addPosition(int i, Position a) {
        positions[i] = a;
    }

    public Position[] getPosition() {
        return positions;
    }
}
