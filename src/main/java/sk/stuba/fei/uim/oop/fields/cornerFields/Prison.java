package sk.stuba.fei.uim.oop.fields.cornerFields;

import sk.stuba.fei.uim.oop.player.Player;

public class Prison extends CornerFields {
    @Override
    public void runAction(Player player) {
        System.out.println("Stojíš na políčku vazenie ak ta pred tym zadrzala policia kolo stojis ak nie ďalšie kolo budeš na ťahu!");
    }

    public Prison(String type, int index) {
        super(type, index);
    }
}