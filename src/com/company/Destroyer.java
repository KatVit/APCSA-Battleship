package com.company;

public class Destroyer extends Ship {
    private Position[] positions = new Position[2];

    public int getLength() {
        return 2;
    }

    public String getName() {
        return "Destroyer";
    }

    public void addPosition(int i, Position a) {
        positions[i] = a;
    }

    public Position[] getPosition() {
        return positions;
    }
}
