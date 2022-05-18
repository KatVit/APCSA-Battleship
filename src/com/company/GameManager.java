package com.company;

import java.util.Scanner;

public class GameManager {
    public void startGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("~~~BATTLESHIP~~~");
        System.out.print("Player 1, Please enter your name");
        Player player1 = new Player(input.next());
        player1.addShips();
        player1.shipsToGrid();
        System.out.print("Player 2, Please enter your name");
        Player player2 = new Player(input.next());
        player2.addShips();
        player2.shipsToGrid();
        input.close();
    }
}