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
    public int[][] getOwnGrid(){
        return pGrid;
    }
    public int[][] getGuesses(){
        return pGuesses;
    }

    public void printOwnBoard() {
        System.out.println("Below is your current board and ship placements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; i++) {
                System.out.print(pGrid[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void printGuessBoard() {
        System.out.println("Below are your current guesses:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; i++) {
                System.out.print(pGuesses[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] addShip(Ship ship, boolean isHorizontal, int xStart, int yStart) {
        if (isHorizontal) { // if the ship is being placed horizontally on the x axis
            // NEED TO FIGURE OUT WHAT TO PUT HERE TO MAKE SURE THE SHIPS ARENT OVERLAPPING
            // WHEN YOU ARE PLACING THEM!@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! While
            // statement? soething to compare positions of already made ships...
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
            for (int i = xStart; i < xStart + ship.getLength(); i++) { // placing the ship on the player grid
                pGrid[i][yStart] = ship.getLength();
            }
            for (int i = xStart; i < ship.getLength(); i++) { // updating the ship object to match the position
                ship.addPosition(i, new Position(xStart, yStart));
                xStart++;
            }
        } else {
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