package sk.stuba.fei.uim.oop.fields.cards;

import sk.stuba.fei.uim.oop.fields.CardPackage;
import sk.stuba.fei.uim.oop.player.Player;

public class Card3 extends CardPackage {

    public void cardAction(Player player) {
        System.out.println("Potiahol si si kartu3.Našiel si 2000€");
        player.incomes(2000);
    }
}