package sk.stuba.fei.uim.oop.fields.corner;

import sk.stuba.fei.uim.oop.player.Player;

import java.util.Scanner;

public class Prison extends CornerFields {

    @Override
    public void runAction(Player player, Scanner console) {
        System.out.println("Stojíš na políčku väzenie nič sa nedeje");
    }

    public Prison(String type, int index) {
        super(type, index);
    }
}
