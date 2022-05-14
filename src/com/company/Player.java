package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private ArrayList<Ship> ships;

    public Player(String n) {
        name = n;
        PlayerGrid name = new PlayerGrid(); // giving each player grids
    }

    public String getName() {
        return name;
    }

    public void addShips() {
        ships.add(new Battleship());
        ships.add(new Cruiser());
        ships.add(new Destroyer());
        ships.add(new Frigate());
        ships.add(new Submarine());
    }

    public void shipsToGrid() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < ships.size(); i++) {

        }
        input.close();
    }

    public void displayShips() { // inventory
        for (int i = 0; i < ships.size(); i++) {
            System.out.println(ships.get(i).getName() + ": Size - " + ships.get(i).getLength());
        }
        
        System.out.println();
    }
}
