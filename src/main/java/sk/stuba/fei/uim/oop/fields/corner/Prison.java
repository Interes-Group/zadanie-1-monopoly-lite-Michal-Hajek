package sk.stuba.fei.uim.oop.fields.corner;

import sk.stuba.fei.uim.oop.fields.Cards.CardPackage;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.List;
import java.util.Scanner;

public class Prison extends CornerFields {

    @Override
    public void runAction(Player player, Scanner console) {
        System.out.println("Stojíš na políčku vazenie ak ta pred tym zadrzala policia kolo stojis");
    }

    public Prison(String type, int index) {
        super(type, index);
    }
}
