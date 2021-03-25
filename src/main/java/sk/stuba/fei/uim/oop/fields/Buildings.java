package sk.stuba.fei.uim.oop.fields;

import sk.stuba.fei.uim.oop.player.BancrotOfPlayerException;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Buildings extends Fields {
    private int price;
    private int rent;
    private Player owner;
    private Scanner console;

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public int getPrice() {
        return price;
    }

    public Buildings(String type, int index, Scanner console) {
        super(type, index);
        this.price = index * 2000;
        this.rent = index * 2000;
        this.console = console;
    }

    @Override
    public void runAction(Player player) throws BancrotOfPlayerException {
        if (owner == null) {
            System.out.println("Budova je volna, môžeš ju kúpiť za " + getPrice() + "\nTvoj stav uctu je: " +
                    player.getBudget() + " stlač 1-kupit/ iné číslo -nemam zaujem");

            boolean error = false;
            int menu = 0;
            do {
                try {
                    menu = console.nextInt();
                    error = false;
                } catch (InputMismatchException e) {
                    console.next();
                    System.out.println("Prosim stlač 1-kupit/ iné číslo -nemam zaujem!!!");
                    error = true;
                }
            } while (error);

            switch (menu) {
                case 1:
                    buyBulding(player);
                    break;
                case 0:
                    System.out.println("Nekupil si budovu.");
                    break;
                default:
                    System.out.println("Nekupil si budovu.");
                    break;
            }
        } else {
            payment(player);
        }
    }

    public void payment(Player playerPaid) throws BancrotOfPlayerException {
        if (owner != null && !playerPaid.equals(owner)) {
            System.out.println("PLatiš hráčovi :" + owner.getName() + " Suma na zaplatenie: " + rent);
            playerPaid.playerPayments(rent);
            owner.incomes(rent);
            if (playerPaid.getBudget() < 0) {
                System.out.println("Skrachoval si");
                throw new BancrotOfPlayerException("Skrachoval si");
            }

            System.out.println("Tvoj stav uctu:" + playerPaid.getBudget());
        } else System.out.println("Stojis na vlastnej budove");
    }

    public void buyBulding(Player client) {
        if (owner == null && client.getBudget() > price) {
            client.buy(price);
            owner = client;
            System.out.println("Kupil si budovu:");
            System.out.println("Tvoj stav uctu:" + client.getBudget());
        } else
            System.out.println("Nemas dostatok penazi na to aby si mohol kupit budovu");
    }
}