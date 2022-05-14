package com.company;

public class Battleship extends Ship {
    private Position[] positions = new Position[5];

    public int getLength() {
        return 5;
    }

    public String getName() {
        return "Battleship";
    }

    public void addPosition(int i, Position a) {
        positions[i] = a;
    }

    public Position[] getPosition() {
        return positions;
    }
}
