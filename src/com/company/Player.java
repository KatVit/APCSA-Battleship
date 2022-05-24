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

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public PlayerGrid getGrids() {
        return grids;
    }

    public void addShips() {
        ships = new ArrayList<Ship>();
        ships.add(new Ship(5, "Battleship"));
        ships.add(new Ship(4, "Cruiser"));
        ships.add(new Ship(3, "Destroyer"));
        ships.add(new Ship(3, "Frigate"));
        ships.add(new Ship(2, "Submarine"));
    }

    public void shipsToGrid(Player player) {
        Scanner input = new Scanner(System.in);
        boolean isHorizontal = false;
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < ships.size(); i++) {
            grids.printOwnBoard();
            System.out.println("You are currently placing your " + ships.get(i).getName()
                    + " (Size: " + ships.get(i).getLength() +"). Please enter H if you would like to place this ship vertically, and V if you would like to place it horizontally");
            isHorizontal = input.next().equalsIgnoreCase("H");
            System.out.println("Please enter the x value for the leftmost end of the ship. Remember that this ship is "
                    + ships.get(i).getLength() + " units long");
            startX = input.nextInt();
            System.out.println("Please enter the ys value for the topmost end of the ship. Remember that this ship is "
                    + ships.get(i).getLength() + " units long");
            startY = input.nextInt();
            grids.addShip(player, ships.get(i), isHorizontal, startX, startY);
            ships.get(i).addedToBoard();
        }
        grids.printOwnBoard();
        input.close();
    }

    public void makeTurn(Player opponent) {
        Scanner input = new Scanner((System.in));
        grids.printGuessBoard();
        System.out.println("Please enter the x-coord of your guess: ");
        int x = input.nextInt();
        System.out.println("Please enter the y-coord of your guess: ");
        int y = input.nextInt();
        Position guess = new Position(x, y);
        for (int i = 0; i < opponent.ships.size(); i++) {
            for (int j = 0; j < opponent.ships.get(i).getPosition().length; i++) {
                if (guess == opponent.ships.get(i).getPosition()[j]) {
                    opponent.ships.get(i).getPosition()[j] = new Position(-1, -1);
                    System.out.println(
                            "You hit one of your opponents ships! :D you're so cool look at you go. now guess again");
                    opponent.grids.getOwnGrid()[x][y] = -1; // shows opponent ship was hit
                    grids.getGuesses()[x][y] = 1; // shows you opponent ship was hit
                    makeTurn(opponent); // make another turn if they got it right
                }
            }
        }
        int i = 0;
        while (i < 50) {
            System.out.println();
            i++;
        }
        input.close();
    }

    public void displayShipInfo() { // inventory
        for (int i = 0; i < ships.size(); i++) {
            System.out.println(ships.get(i).getName() + ": Size - " + ships.get(i).getLength());
        }

        System.out.println();
    }

    public void isSunk() {
        for (int i = 0; i < ships.size(); i++) {
            for (int j = 0; j < ships.get(i).getLength(); j++) {
                if ((ships.get(i).getPosition()[j].getX() != -1)) {
                    i++;
                }
                if (j == ships.get(i).getLength() - 1) {
                    if ((ships.get(i).getPosition()[j].getX() == -1)) {
                        System.out.println("Your " + ships.get(i).getName() + " has been sunk!");
                        ships.remove(i);
                    }
                }
            }
        }
    }
}