package sk.stuba.fei.uim.oop.fields.corner;

import sk.stuba.fei.uim.oop.player.BancrotOfPlayerException;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.Scanner;

public class Tax extends CornerFields {
    @Override
    public void runAction(Player player) throws BancrotOfPlayerException {
        System.out.println("Si na políčku Tax, platíš daň Banke vo výške 10000");
        payTaxes(player);
        System.out.println("Stav tvojho účtu je:"+player.getBudget());
    }

    public Tax(String type, int index, Scanner console) {
        super(type, index,console);
    }

    private void payTaxes(Player player) throws BancrotOfPlayerException {
        player.playerPayments(10000);
    }
}