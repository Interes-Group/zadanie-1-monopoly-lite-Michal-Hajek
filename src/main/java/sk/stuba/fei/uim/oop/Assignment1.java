package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.gamecyclus.Gamecyclus;
import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of players:");
        int countOfPlayers = input.nextInt();
        Gamecyclus game=new Gamecyclus();
        game.createFieldsMap();
        game.createPlayers(countOfPlayers);
        game.gameRun(game.getPlayersInGame(),game.getGameFields(),input);
    }
}
