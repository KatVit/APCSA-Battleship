package com.company;

import java.util.Scanner;

public class GameManager {
    public void startGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("~~~BATTLESHIP~~~");
        System.out.print("Player 1, Please enter your name");
        Player player1 = new Player(input.next());
        System.out.print("Player 2, Please enter your name");
        Player player2 = new Player(input.next());
        input.close();
    }
}
