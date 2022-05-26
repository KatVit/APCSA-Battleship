package com.company;

import java.util.Scanner;

public class GameManager {
    public void startGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("~~~BATTLESHIP~~~");
        System.out.print("Player 1, Please enter your name: ");
        Player player1 = new Player(input.next());
        player1.addShips();
        player1.shipsToGrid(player1);
        System.out.print("Player 2, Please enter your name: ");
        String name = input.next();
        Player player2 = new Player(name);
        player2.addShips();
        player2.shipsToGrid(player2);
        while (player1.getShips().size() > 0 && player2.getShips().size() > 0) {
            //player1.getGrids().printOwnBoard(); //problem
            player1.makeTurn(player2); //problem
            System.out.println();
            System.out.println(
                    "Your ships: " + player1.getShips().size() + " | Opponent's ships: " + player2.getShips().size());
            if (player1.getShips().size() == 0 || player2.getShips().size() == 0) {
                gameOver(player1, player2);
                System.exit(0);
            }
            //player2.getGrids().printOwnBoard();
            player2.makeTurn(player1);
            System.out.println();
            System.out.println();
            System.out.println(
                    "Your ships: " + player2.getShips().size() + " | Opponent's ships: " + player1.getShips().size());
            System.out.println();
        }
        gameOver(player1, player2);
        input.close();
    }

    public void gameOver(Player player1, Player player2) {
        System.out.println(
                "Player 1's ships: " + player1.getShips().size() + " | Player 2's ships: " + player2.getShips().size());
        if (player1.getShips().size() > 0 && player2.getShips().size() <= 0) {
            System.out.println(player1 + " wins! :)");
        } else {
            System.out.println(player2 + " wins! :)");
        }
        System.out.println();
    }
}