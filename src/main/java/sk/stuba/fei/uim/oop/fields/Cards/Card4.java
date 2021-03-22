package sk.stuba.fei.uim.oop.fields.Cards;

import sk.stuba.fei.uim.oop.player.BancrotOfPlayerException;
import sk.stuba.fei.uim.oop.player.Player;

public class Card4 extends CardPackage {

    public void cardAction(Player player) throws BancrotOfPlayerException {
        System.out.println("Hadz kockou este raz");
        player.playerMovement();
    }
}
