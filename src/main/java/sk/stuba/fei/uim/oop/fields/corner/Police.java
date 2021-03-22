package sk.stuba.fei.uim.oop.fields.corner;

import sk.stuba.fei.uim.oop.player.Player;

import java.util.Scanner;

public class Police extends CornerFields {
    @Override
    public void runAction(Player player) {
        System.out.println("Policia ťa zadržala ideš na jedno kolo do vazenia");
        cantMoveForTurn(player);
    }

    public Police(String type, int index, Scanner console) {
        super(type, index,console);
    }

    void cantMoveForTurn(Player player){
        player.goToPrison(6);
    }
}