package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private ArrayList<Ship> ships;
    PlayerGrid grids;
    public Player(String n) {
        name = n;
        grids = new PlayerGrid(); // giving each player grids
    }

    public String getName() {
        return name;
    }

    public void addShips() {
        ships.add(new Ship(5, "Battleship"));
        ships.add(new Ship(4, "Cruiser"));
        ships.add(new Ship(3, "Destroyer"));
        ships.add(new Ship(3, "Frigate"));
        ships.add(new Ship(2, "Submarine"));
    }

    public void shipsToGrid() {
        Scanner input = new Scanner(System.in);
        boolean isHorizontal = false;
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < ships.size(); i++) {
            grids.printOwnBoard();
            System.out.println("You are currently placing your " + ships.get(i).getName() + ". Please enter H if you would like to place this ship horizontally, and V if you would like to place it vertically");
            isHorizontal = input.next().equalsIgnoreCase("H");
            System.out.println("Please enter the x value for the leftmost end of the ship. Remember that this ship is " + ships.get(i).getLength() + " units long");
            startX = input.nextInt();
            System.out.println("Please enter the y value for the topmost end of the ship. Remember that this ship is " + ships.get(i).getLength() + " units long");
            startY = input.nextInt();
            grids.addShip(ships.get(i), isHorizontal, startX, startY);
        }
        input.close();
    }

    public void displayShipInfo() { // inventory
        for (int i = 0; i < ships.size(); i++) {
            System.out.println(ships.get(i).getName() + ": Size - " + ships.get(i).getLength());
        }
        
        System.out.println();
    }
}
