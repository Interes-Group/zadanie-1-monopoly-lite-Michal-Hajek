package sk.stuba.fei.uim.oop.gamecyclus;

import sk.stuba.fei.uim.oop.fields.Fields;
import sk.stuba.fei.uim.oop.gameinitialization.GameInitialization;
import sk.stuba.fei.uim.oop.player.BancrotOfPlayerException;
import sk.stuba.fei.uim.oop.player.Player;

public class Gamecyclus extends GameInitialization {
    private boolean endGame = true;

    public void gameRun() {
        createFieldsMap();
        int countOfPlayers = inputCountOfPlayers(console);
        createPlayers(countOfPlayers, console);
        while (endGame) {
            for (Player player : playersInGame) {
                try {
                    if (!player.isOutOfgame()) {
                        System.out.println("************************************");
                        player.playerMovement();
                        player.printPLayerInfo(player);
                        Fields actual = gameFields.get(player.getCurrentPosition());
                        actual.runAction(player);
                        System.out.println("************************************");
                    }
                } catch (BancrotOfPlayerException e) {
                    player.bancrot(gameFields, player);
                    endGame = endGame();
                    break;
                }
            }
        }
        System.out.println("------------------------------------------------");
        System.out.println("Vypracoval: Michal Hájek 104463");
    }
}
