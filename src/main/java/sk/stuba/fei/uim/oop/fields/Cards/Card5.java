package sk.stuba.fei.uim.oop.fields.Cards;

import sk.stuba.fei.uim.oop.player.Player;

public class Card5 extends CardPackage {

    public void cardAction(Player player) {
        System.out.println("Posun sa o dve policka dozadu");
        player.setCurrentPosition(player.getCurrentPosition()-2);
    }

}
