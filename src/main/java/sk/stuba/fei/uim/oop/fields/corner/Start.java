package sk.stuba.fei.uim.oop.fields.corner;

import sk.stuba.fei.uim.oop.player.Player;

import java.util.Scanner;

public class Start extends CornerFields {
    @Override
    public void runAction(Player player) {
        System.out.println("Si na políčku štart nic sa nedeje ked, prejdes startom dostanes bonus:");
    }

    public Start(String type, int index, Scanner console) {
        super(type,index,console);
    }
}
