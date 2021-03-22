package sk.stuba.fei.uim.oop.gameinitialization;

import sk.stuba.fei.uim.oop.fields.Buildings;
import sk.stuba.fei.uim.oop.fields.Cards.*;
import sk.stuba.fei.uim.oop.fields.Fields;
import sk.stuba.fei.uim.oop.fields.corner.Police;
import sk.stuba.fei.uim.oop.fields.corner.Prison;
import sk.stuba.fei.uim.oop.fields.corner.Start;
import sk.stuba.fei.uim.oop.fields.corner.Tax;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.player.WrongInputExceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public abstract class GameInitialization {
    protected List<Fields> gameFields = new ArrayList<>();
    protected List<Player> playersInGame = new ArrayList<>();
    private List<CardPackage> cards = new ArrayList<>();
    protected Scanner console = new Scanner(System.in);

    private void createCardPackage() {
        cards.add(new Card1());
        cards.add(new Card2());
        cards.add(new Card3());
        cards.add(new Card4());
        cards.add(new Card5());
    }

    protected void createPlayers(int countOfPlayers, Scanner input) {
        String name;
        for (int i = 1; i < countOfPlayers+1; i++) {
            System.out.println("Zadaj meno hraca cislo:  " + i);
            name = input.next();
            playersInGame.add(new Player(i + 1, name));
        }
    }

    protected boolean endGame() {
        int count = 0;
        String name = "Nikto nie je víťaz niekde je chyba";
        for (Player player : playersInGame) {
            if (!player.isOutOfgame()) {
                name = player.getName();
                count += 1;
            }
        }
        if (count == 1) {
            System.out.println("Víťaz monopoly je: " + name);
            return false;
        }
        return true;
    }

    protected void createFieldsMap() {
        createCardPackage();
        for (int i = 0; i < 24; i++) {
            if (i == 0)
                this.gameFields.add(new Start("Start", i,console));
            else if (i == 6)
                this.gameFields.add(new Prison("Prison", i,console));
            else if (i == 12)
                this.gameFields.add(new Tax("Tax", i,console));
            else if (i == 18)
                this.gameFields.add(new Police("Police", i,console));
            else if (i == 5 || i == 15)
                this.gameFields.add(new Chance("Chance", i,cards,console));
            else
                this.gameFields.add(new Buildings("Building", i,console));
        }
    }

    protected int inputCountOfPlayers(Scanner console) {
        int countOfPlayers;
        System.out.println("Zadaj pocet hracov(min-max)2-6:");
        try {
            String numberOfPlayers = console.nextLine();
            countOfPlayers = Integer.parseInt(numberOfPlayers);
            if(countOfPlayers<2|countOfPlayers>6)
                throw new WrongInputExceptions();
            return countOfPlayers;
        } catch (NumberFormatException | WrongInputExceptions e) {
            System.err.println(e);
            if(e instanceof NumberFormatException)
                System.out.println("Vstup musi byt cislo! Zadajze cislo: ");
            else
                System.out.println("Vstup musi byt v rozmedzi 2-6!");
            return inputCountOfPlayers(console);
        }
    }
}