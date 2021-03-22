package sk.stuba.fei.uim.oop.fields.Cards;

import sk.stuba.fei.uim.oop.player.Player;

public class Card2 extends CardPackage {

    @Override
    public void cardAction(Player player) {
        System.out.println("Zaplat banke 2000");
        player.playerPayments(2000);

    }
}

