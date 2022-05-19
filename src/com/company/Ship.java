package com.company;

public class Ship {
    private final int length;
    private final String name;
    private Position[] positions;
    boolean onBoard;

    public Ship(int l, String n){
        length = l;
        name = n;
        positions = new Position[l];
        onBoard = false;
    }
    public void addedToBoard(){
        onBoard = true;
    }

    public String getName(){
        return name;
    };
    public int getLength(){
        return length;
    }
    public void addPosition(int i, Position a){
        positions[i] = a;
    }
    public Position[] getPosition() {
        return positions;
    }
}