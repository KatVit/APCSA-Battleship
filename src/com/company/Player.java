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
        grids.printOwnBoard();
        input.close();
    }
    public void makeTurn(Player opponent){
        Scanner input = new Scanner((System.in));
        System.out.println("Please enter the x-coord of your guess: ");
        int x = input.nextInt();
        System.out.println("Please enter the y-coord of your guess: ");
        int y = input.nextInt();
        Position guess = new Position(x,y);
        for (int i = 0; i <opponent.ships.size(); i++){
            for (int j = 0; j<opponent.ships.get(i).getPosition().length; i++){
                if (guess == opponent.ships.get(i).getPosition()[j]){
                    System.out.println("You hit one of your opponents ships! :D you're so cool look at you go");
                    opponent.grids.getOwnGrid()[x][y] = -1; //shows opponent ship was hit
                    grids.getGuesses()[x][y] = 1; //shows you opponent ship was hit
                }
            }
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