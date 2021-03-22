package sk.stuba.fei.uim.oop.fields;

import sk.stuba.fei.uim.oop.player.BancrotOfPlayerException;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.Scanner;

public abstract class Fields {
    private String type;
    private int index;

    public Scanner getConsole() {
        return console;
    }

    private Scanner console;

    public abstract void runAction(Player player) throws BancrotOfPlayerException;

    protected Fields(String type, int index,Scanner console) {
        this.type = type;
        this.index = index;
        this.console=console;
    }
}