package com.company;

import java.util.Scanner;

public class PlayerGrid {
    Scanner input = new Scanner(System.in);
    final int rows = 10;
    final int columns = 10;
    private int[][] pGrid;
    private int[][] pGuesses;

    public PlayerGrid() {
        pGrid = new int[rows][columns];
        pGuesses = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                pGrid[i][j] = 0;
                pGuesses[i][j] = 0;
            }
        }
    }

    public int[][] getOwnGrid() {
        return pGrid;
    }

    public int[][] getGuesses() {
        return pGuesses;
    }

    public void printOwnBoard() {
        System.out.println("Below is your current board and ship placements:");
        System.out.println("0  1  2  3  4  5  6  7  8  9  \n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(pGrid[i][j] + "  ");
            }
            System.out.println("   | " + i);
        }
        System.out.println();
    }

    public void printGuessBoard() {
        System.out.println("Below are your current guesses:");
        System.out.println("0  1  2  3  4  5  6  7  8  9 \n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; i++) {
                System.out.print(pGuesses[i][j] + "  ");
            }
            System.out.println("   | " + i);
        }
        System.out.println();
    }

    public int[][] addShip(Player player, Ship ship, boolean isHorizontal, int xStart, int yStart) {
        boolean loop = true;
        boolean newPosition = false;
        if (isHorizontal) {
            while (loop) {
                while (xStart + ship.getLength() > 9 || xStart < 0) { // if it is going to not fit in the xaxis
                    System.out.println(
                            "This placement exceeds the horizontal boundaries of the grid. Please enter a valid x-coordinate for the leftmost point of the "
                                    + ship.getName() + " : ");
                    xStart = input.nextInt();
                }
                while (yStart < 0 || yStart > 9) { // if it wont fit on the y axis
                    System.out.println(
                            "This placement exceeds the vertical boundaries of the grid. Please enter a valid y-coordinate for this "
                                    + ship.getName() + " to be placed along : ");
                    yStart = input.nextInt();
                }
                newPosition = false;
                for (int i = 0; i < player.getShips().size(); i++) {
                    if (player.getShips().get(i).onBoard) {
                        for (int j = 0; j < player.getShips().get(i).getPosition().length; j++) {
                            if ((xStart == player.getShips().get(i).getPosition()[j].getX())
                                    && (yStart == player.getShips().get(i).getPosition()[j].getY())) {
                                System.out.println(
                                        "This ship overlaps with another ship that has already been placed on the board. Please enter a new starting x position for your ship");
                                yStart = input.nextInt();
                                System.out.println("Please enter a new starting y position for your ship");
                                xStart = input.nextInt();
                                newPosition = true;
                            }
                        }
                    }
                }
                if (!newPosition) {
                    loop = false;
                }
            }
            for (int i = xStart; i < xStart + ship.getLength(); i++) { // placing the ship on the player grid
                pGrid[i][yStart] = ship.getLength();
            }
            for (int i = 0; i < ship.getLength(); i++) { // updating the ship object to match the position
                ship.addPosition(i, new Position(xStart, yStart));
                xStart++;
            }
        } else {
            while (loop) {
                while (yStart + ship.getLength() > 9 || yStart < 0) { // if it is going to not fit in the yaxis
                    System.out.println(
                            "This placement exceeds the vertical boundaries of the grid. Please enter a valid y-coordinate for the topmost point of the "
                                    + ship.getName() + " : ");
                    yStart = input.nextInt();
                }
                while (xStart < 0 || xStart > 9) { // if it wont fit on the x axis
                    System.out.println(
                            "This placement exceeds the horizontal boundaries of the grid. Please enter a valid x-coordinate for this "
                                    + ship.getName() + " to be placed along : ");
                    xStart = input.nextInt();
                }
                newPosition = false;
                for (int i = 0; i < player.getShips().size(); i++) {
                    if (player.getShips().get(i).onBoard) {
                        for (int j = 0; j < player.getShips().get(i).getPosition().length; j++) {
                            if ((xStart == player.getShips().get(i).getPosition()[j].getX())
                                    && (yStart == player.getShips().get(i).getPosition()[j].getY())) {
                                System.out.println(
                                        "This ship overlaps with another ship that has already been placed on the board. Please enter a new starting x position for your ship");
                                yStart = input.nextInt();
                                System.out.println("Please enter a new starting y position for your ship");
                                xStart = input.nextInt();
                                newPosition = true;
                            }
                        }
                    }
                }
                if (!newPosition) {
                    loop = false;
                }
            }
            for (int i = yStart; i < yStart + ship.getLength(); i++) {
                pGrid[xStart][i] = ship.getLength();
            }
            for (int i = 0; i < ship.getLength(); i++) {
                ship.addPosition(i, new Position(xStart, yStart));
                yStart++;
            }
        }
        return pGrid;
    }
}