package sk.stuba.fei.uim.oop.fields.Cards;

import sk.stuba.fei.uim.oop.player.BancrotOfPlayerException;
import sk.stuba.fei.uim.oop.player.Player;

public class Card2 extends CardPackage {

    @Override
    public void cardAction(Player player) throws BancrotOfPlayerException {
        System.out.println("Potiahol si si kartu2.Zaplat banke 2000");
        player.playerPayments(2000);

    }
}

