package sk.stuba.fei.uim.oop.fields.Cards;

import sk.stuba.fei.uim.oop.fields.Fields;
import sk.stuba.fei.uim.oop.player.BancrotOfPlayerException;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.*;

public  class Chance extends Fields {
    private List<CardPackage> cards;
    @Override
    public  void runAction(Player player)throws BancrotOfPlayerException {
        player.drawCard(player,cards);
    }

    public Chance(String type, int index,List<CardPackage> cards,Scanner console) {
        super(type, index,console);
        this.cards=cards;
    }
}