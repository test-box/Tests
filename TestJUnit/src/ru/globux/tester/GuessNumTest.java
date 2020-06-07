package ru.globux.tester;

import java.util.Random;
import java.util.Scanner;

class Game {
    public final static Scanner console = new Scanner(System.in);
    private Player[] players;
    private int number;

    public Game(Player... players) {
        this.players = players;
        this.number = new Random().nextInt(100);
    }

    public void run() {
        Player won = null;
        System.out.println("Game is begin");
        do {
            for (Player p : players) {
                int numPlayer = p.sayNumber();
                if (numPlayer > number) {
                    System.out.println("The entered number is more than the computer guessed");
                } else if (numPlayer < number) {
                    System.out.println("The entered number is less than the computer guessed");
                } else {
                    won = p;
                    System.out.println(won.getName() + " guessed the number!");
                    break;
                }
            }
        } while (won == null);
    }
}

class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public int sayNumber() {
        System.out.print(this.name + " enter a number from 0 to 100: ");
        return Game.console.nextInt();
    }
}


public class GuessNumTest {
    public static void main(String[] args) {
        System.out.println("Enter the name first player");
        Player player1 = new Player(Game.console.nextLine());
        System.out.println("Enter the name next player");
        Player player2 = new Player(Game.console.nextLine());
        do {
            new Game(player1, player2).run();
            System.out.print("Do you want play the Game again? Y/N: ");
        } while (!isGameOver());
        System.out.println("The game is over");
    }

    private static boolean isGameOver() {
        boolean result = false;
        String answer;
        do {
            answer = Game.console.next();
            if (answer.equalsIgnoreCase("Y")) {
                result = false;
                break;
            }
            else if (answer.equalsIgnoreCase("N")) {
                result = true;
                break;
            }
            else {
                System.out.print("Please enter Y or N: ");
            }
        } while (true);
        return result;
    }
}
