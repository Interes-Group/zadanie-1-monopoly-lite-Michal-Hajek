package sk.stuba.fei.uim.oop.gameinitialization;

import sk.stuba.fei.uim.oop.fields.Buildings;
import sk.stuba.fei.uim.oop.fields.Cards.*;
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
    private List<Fields> gameFields=new ArrayList<>();
    private List<Player> playersInGame=new ArrayList<>();
    private  List<CardPackage> cards=new ArrayList<>();

    public List<CardPackage> getCards() {
        return cards;
    }

    public List<Fields> getGameFields() {
        return gameFields;
    }

    public List<Player> getPlayersInGame() {
        return playersInGame;
    }



    protected void createCardPackage(){
        cards.add(new Card1());
        cards.add(new Card2());
        cards.add(new Card3());
        cards.add(new Card4());
        cards.add(new Card5());
    }
    protected void createPlayers(int countOfPlayers,Scanner input) {
        String name;
        for (int i = 0; i < countOfPlayers; i++) {
            System.out.println( "Enter name of player with number " + i+1);
            name = input.next();
            playersInGame.add(new Player(i+1,name));
        }
    }
    protected boolean endGame(){
        int count=0;
        String name="Nikto nie je víťaz niekde je chyba";
        for (Player player:playersInGame) {
            if(!player.isOutOfgame()) {
                name = player.getName();
                count += 1;
            }
        }
        if(count==1){
            System.out.println("Víťaz monopoly je: "+name);
            return false;
        }
        return true;
    }
    protected void createFieldsMap(){
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
    protected int inputCountOfPlayers(Scanner console){
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
