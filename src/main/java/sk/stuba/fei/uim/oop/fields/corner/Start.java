package sk.stuba.fei.uim.oop.fields.corner;

import sk.stuba.fei.uim.oop.fields.Cards.CardPackage;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.List;
import java.util.Scanner;

public class Start extends CornerFields {
    @Override
    public void runAction(Player player, Scanner console) {
        System.out.println("Si na políčku štart nic sa nedeje ked, prejdes startom dostanes bonus:");
    }

    public Start(String type, int index) {
        super(type,index);
    }

}
