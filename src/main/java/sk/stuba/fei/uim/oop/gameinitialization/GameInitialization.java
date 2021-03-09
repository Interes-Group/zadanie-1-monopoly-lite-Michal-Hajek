package sk.stuba.fei.uim.oop;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameInitialization {
    private int countOfPlayers;
    private List<PLayer> playersInGame=new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public int getCountOfPlayers() {
        return countOfPlayers;
    }

    public GameInitialization() {
        System.out.println("Enter number of players:");
        int countOfPlayers = input.nextInt();
        this.countOfPlayers = countOfPlayers;

    }
    public void CreatePlayers(int countOfPlayers) {
        String name;
        for (int i = 0; i < countOfPlayers; i++) {
            System.out.println( "Enter name of player with number " + i);
            name = input.next();
            playersInGame.add(new PLayer(i, name));
        }
        input.close();
    }

}
