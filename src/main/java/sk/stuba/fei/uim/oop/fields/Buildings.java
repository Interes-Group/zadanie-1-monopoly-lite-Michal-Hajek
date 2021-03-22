package sk.stuba.fei.uim.oop.fields;
import sk.stuba.fei.uim.oop.player.Player;
import java.util.Scanner;

public class Buildings extends Fields {
    private int price;
    private int rent;
    private Player owner;

    public void setOwner(Player owner) { this.owner = owner; }

    public Player getOwner() {
        return owner;
    }

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
                    player.getBudget()+" stlač 1/0");
            int s = console.nextInt();
            switch (s) {
                case 1:
                    buyBulding(player);
                    break;
                case 0:
                    System.out.println("Nekupil si budovu:");
                    break;
                default:
                    break;
            }
        } else {
            payment(player);
        }
    }

    public void payment(Player playerPaid) {
        if (owner != null && !playerPaid.equals(owner)){
            System.out.println("PLatiš hráčovi :" + owner.getName());
            playerPaid.playerPayments(rent);
            owner.incomes(rent);
            System.out.println("Tvoj stav uctu:"+playerPaid.getBudget());
        }
        else System.out.println("Stojis na vlastnej budove");

    }

    public void buyBulding(Player client) {
        if (owner == null && client.getBudget()>price ) {
            client.buy(price);
            owner = client;
            System.out.println("Kupil si budovu:");
            System.out.println("Tvoj stav uctu:"+client.getBudget());
        }
        else
            System.out.println("Nemas dostatok penazi na to aby si mohol kupit budovu");
    }
}
