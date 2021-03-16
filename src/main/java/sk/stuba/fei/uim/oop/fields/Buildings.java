package sk.stuba.fei.uim.oop.fields;
import sk.stuba.fei.uim.oop.player.Player;
import java.util.Scanner;

public class Buildings extends Fields {
    private int price;
    private int rent;
    private Player owner;

    public int getPrice() {
        return price;
    }

    public Buildings(String type, int index) {
        super(type, index);
        this.price = index * 2000;
        this.rent = index * 2000;
    }

    @Override
    public void runAction(Player player, Scanner console) {
        if (owner == null) {
            System.out.println("Budova je volna, môžeš ju kúpiť za "+getPrice()+"Tvoj stav uctu je: "+
                    player.getBudget()+" stlač y/n");
            String s = console.nextLine();
            switch (s) {
                case "y":
                    buyBulding(player);
                    System.out.println("Kupil si budovu:");
                    break;
                case "n":
                    System.out.println("Nekupil si budovu:");
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("PLatiš hráčovi :" + owner);
            payment(player);
        }
    }


    public void payment(Player playerPaid) {
        if (owner != null)
            playerPaid.playerPayments(rent);
        owner.incomes(rent);
    }

    public void buyBulding(Player client) {
        if (owner == null) {
            client.buy(price);
            owner = client;
        }
    }
}
