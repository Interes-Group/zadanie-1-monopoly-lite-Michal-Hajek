package sk.stuba.fei.uim.oop.gameinitialization;

import sk.stuba.fei.uim.oop.fields.Buildings;
import sk.stuba.fei.uim.oop.fields.Cards.Chance;
import sk.stuba.fei.uim.oop.fields.Fields;
import sk.stuba.fei.uim.oop.fields.corner.Police;
import sk.stuba.fei.uim.oop.fields.corner.Prison;
import sk.stuba.fei.uim.oop.fields.corner.Start;
import sk.stuba.fei.uim.oop.fields.corner.Tax;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public abstract class GameInitialization  {
    protected List<Fields> gameFields=new ArrayList<>();
    protected List<Player> playersInGame=new ArrayList<>();
    public List<Fields> getGameFields() {
        return gameFields;
    }

    public List<Player> getPlayersInGame() {
        return playersInGame;
    }
    public void createPlayers(int countOfPlayers,Scanner input) {
        String name;
        for (int i = 0; i < countOfPlayers; i++) {
            System.out.println( "Enter name of player with number " + i+1);
            name = input.next();
            playersInGame.add(new Player(i+1,name));
        }
    }
    public boolean endGame(){
        if(playersInGame.size()==1){
            System.out.println("Víťaz monopoly je: "+playersInGame.get(0));
            return false;
        }
        return true;
    }
    public void createFieldsMap(){
        for(int i=0;i<24;i++){
            if(i==0)
                this.gameFields.add(new Start("Start",i));
            else if (i==6)
                this.gameFields.add(new Prison("Prison",i));
            else if(i==12)
                this.gameFields.add(new Tax("Tax",i));
            else if (i==18)
                this.gameFields.add(new Police("Police",i));
            else if (i==5 || i==15)
                this.gameFields.add(new Chance("Chance",i));
            else
                this.gameFields.add(new Buildings("Building",i));
        }
    }
    public int inputCountOfPlayers(Scanner console){
        int countOfPlayers;
        System.out.println("Enter number of players:");
        try {
            String numberOfPlayers= console.nextLine();
            countOfPlayers=Integer.parseInt(numberOfPlayers);
            return countOfPlayers;
        }catch (NumberFormatException e){
            System.err.println(e);
            System.out.println("Vstup musi byt cislo! Zadajze cislo: ");
             return inputCountOfPlayers(console);

        }
    }
}
