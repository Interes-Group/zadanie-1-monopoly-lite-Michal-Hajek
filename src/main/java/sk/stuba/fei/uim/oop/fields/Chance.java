package sk.stuba.fei.uim.oop.fields;

import sk.stuba.fei.uim.oop.player.Player;

import java.util.Scanner;

public class Chance extends Fields{
    @Override
    public void runAction(Player player, Scanner console) {
        System.out.println("Si na šanci");
    }

    public Chance(String type, int index) {
        super(type, index);
    }

}
