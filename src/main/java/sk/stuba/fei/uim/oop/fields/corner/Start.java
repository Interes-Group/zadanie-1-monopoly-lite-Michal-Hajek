package sk.stuba.fei.uim.oop.fields.corner;

import sk.stuba.fei.uim.oop.player.Player;

import java.util.Scanner;

public class Start extends CornerFields {
    @Override
    public void runAction(Player player, Scanner console) {
        System.out.println("Prešiel si štartom a dostávaš bonus za kolo: 10000");
        startBonus(player);
        System.out.println("Tvoj stav konta je:"+player.getBudget());
    }

    public Start(String type, int index) {
        super(type,index);
    }
    public void startBonus(Player player){
        System.out.println("your start bonus is 10000");
        player.incomes(10000);
    }
}
