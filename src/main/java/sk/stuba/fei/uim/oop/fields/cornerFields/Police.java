package sk.stuba.fei.uim.oop.fields.cornerFields;

import sk.stuba.fei.uim.oop.player.Player;

public class Police extends CornerFields {
    @Override
    public void runAction(Player player) {
        System.out.println("Policia ťa zadržala ideš na jedno kolo do vazenia");
        cantMoveForTurn(player);
    }

    public Police(String type, int index) {
        super(type, index);
    }

    private void cantMoveForTurn(Player player){
        player.goToPrison(6);
    }
}