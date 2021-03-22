package sk.stuba.fei.uim.oop.fields.Cards;

import sk.stuba.fei.uim.oop.player.Player;

public class Card1 extends CardPackage {

    public void cardAction(Player player) {
        System.out.println("Presun sa na policko vazenie");
        player.goToPrison(6);
    }
}


