package sk.stuba.fei.uim.oop.fields.cards;

import sk.stuba.fei.uim.oop.fields.CardPackage;
import sk.stuba.fei.uim.oop.player.Player;

public class Card4 extends CardPackage {

    public void cardAction(Player player) {
        System.out.println("Potiahol si si kartu4.Hadz kockou este raz");
        player.setCurrentPosition(player.getCurrentPosition()+ player.rollTheDice());
    }
}