package sk.stuba.fei.uim.oop.fields.Cards;

import sk.stuba.fei.uim.oop.player.Player;

public class Card3 extends CardPackage {

    public void cardAction(Player player) {
        System.out.println("Našiel si 2000€");
        player.incomes(2000);
    }
}
