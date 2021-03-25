package sk.stuba.fei.uim.oop.fields;

import sk.stuba.fei.uim.oop.player.BancrotOfPlayerException;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.*;

public class Chance extends Fields {
    private List<CardPackage> cards;

    @Override
    public void runAction(Player player) throws BancrotOfPlayerException {
        System.out.println("Stojis na poličku šanca, potiahni si kartu!");
        player.drawCard(player, cards);
    }

    public Chance(String type, int index, List<CardPackage> cards) {
        super(type, index);
        this.cards = cards;
    }
}