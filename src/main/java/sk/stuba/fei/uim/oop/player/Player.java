package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.fields.Buildings;
import sk.stuba.fei.uim.oop.fields.Cards.*;
import sk.stuba.fei.uim.oop.fields.Fields;

import java.util.List;
import java.util.Random;

public class Player  {
    private String name;
    private int order;
    private int budget;
    private int currentPosition;
    private boolean cantMove = true;
    private boolean outOfgame = false;

    public boolean isOutOfgame() {
        return outOfgame;
    }

    public void setOutOfgame(boolean outOfgame) {
        this.outOfgame = outOfgame;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    Random random = new Random();

    public Player(int order, String name) {
        this.currentPosition = 0;
        this.order = order;
        this.budget = 100000;
        this.name = name;
    }

    public int getBudget() {
        return budget;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }

    public int rollTheDice() {
        return random.nextInt(6) + 1;
    }

    public void printPLayerInfo(Player player) {
        System.out.println("Je na ťahu:" + player.getName());
        System.out.println("Tvoje financie: " + budget);
        System.out.println("Tvoja aktuálna pozícia je : " + currentPosition);
    }

    public void playerPayments(int paymentValue) throws BancrotOfPlayerException {
        this.budget = this.budget - paymentValue;
        if(this.budget<0)
            throw new BancrotOfPlayerException("Skrachoval si");
    }

    public void incomes(int incomesValue) {
        this.budget = this.budget + incomesValue;
    }

    public void playerMovement() throws BancrotOfPlayerException {
        if (budget < 0) {
            throw new BancrotOfPlayerException("Skrachoval si");
        }
        if (cantMove)
            currentPosition += rollTheDice();
        if (currentPosition > 23){
            System.out.println("Presiel si startom a ziskavas bonus 10000");
            this.budget=this.budget+10000;
            currentPosition = currentPosition - 23;
        }
        if (!cantMove) {
            System.out.println("Toto kolo stojíš,lebo si vo vazeni");
            cantMove = true;
        }
    }

    public void buy(int price) {
        this.budget = this.budget - price;
    }

    public void goToPrison(int index) {
        this.currentPosition = index;
        cantMove = false;
    }

    public void drawCard(Player player,List<CardPackage> cards) throws BancrotOfPlayerException {
        CardPackage actualCard = cards.get(0);
        if (actualCard instanceof Card1)
            ((Card1) actualCard).cardAction(player);
        if (actualCard instanceof Card2)
            ((Card2) actualCard).cardAction(player);
        if (actualCard instanceof Card3)
            ((Card3) actualCard).cardAction(player);
        if (actualCard instanceof Card4)
            ((Card4) actualCard).cardAction(player);
        if (actualCard instanceof Card5)
            ((Card5) actualCard).cardAction(player);
        cards.remove(0);
        cards.add(actualCard);
    }

    public void bancrot(List<Fields> fieldsInGame, Player player) {
        player.setOutOfgame(true);
        for (Fields building : fieldsInGame) {
            if (building instanceof Buildings) {
                if (((Buildings) building).getOwner() != null && ((Buildings) building).getOwner().equals(player))
                    ((Buildings) building).setOwner(null);
            }
        }
        System.out.println("!!TVOJE BUDOVY PREPADLI BANKE LEBO SI SKRACHOVAL, HRACI ICH MOZU ZNOVA KUPIT!!");
    }
}