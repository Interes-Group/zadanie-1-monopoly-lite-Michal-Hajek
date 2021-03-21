package sk.stuba.fei.uim.oop.fields.Cards;

import sk.stuba.fei.uim.oop.fields.Fields;
import sk.stuba.fei.uim.oop.player.BancrotOfPlayerException;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.*;

public class Chance extends Fields {
    private List<Integer> cards=new ArrayList<>(List.of(1, 2, 3, 4, 5));
    @Override
    public void runAction(Player player, Scanner console) throws BancrotOfPlayerException {
        System.out.println("Si na šanci");
        Integer card= cards.get(0);
        switch (card){
            case 1:
                System.out.println("Presun sa na policko vazenie");
                player.goToPrison(6);
                break;
            case 2:
                System.out.println("Zaplat banke 2000");
                player.playerPayments(2000);
                break;
            case 3:
                System.out.println("Našiel si 2000€");
                player.incomes(2000);
                break;
            case 4:
                System.out.println("Hadz kockou este raz");
                player.playerMovement();
                break;
            case 5:
                System.out.println("Posun sa o dve policka dozadu");
                player.setCurrentPosition(player.getCurrentPosition()-2);
                break;
            default:
                break;
        }
        cards.remove(card);
        cards.add(card);
    }

    public Chance(String type, int index) {
        super(type, index);
    }

}
