package sk.stuba.fei.uim.oop.fields;

import sk.stuba.fei.uim.oop.player.Player;

import java.io.IOException;
import java.util.Scanner;

public abstract class Fields {
    private String type;
    private int index;

    public abstract void runAction(Player player, Scanner console) throws IOException;

    public Fields(String type, int index) {
        this.type = type;
        this.index = index;
    }
}
