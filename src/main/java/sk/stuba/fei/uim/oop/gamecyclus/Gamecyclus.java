package sk.stuba.fei.uim.oop.gamecyclus;

import sk.stuba.fei.uim.oop.fields.Fields;
import sk.stuba.fei.uim.oop.gameinitialization.GameInitialization;
import sk.stuba.fei.uim.oop.player.EndGameException;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.List;
import java.util.Scanner;

public class Gamecyclus extends GameInitialization {
    private boolean endGame=true;
    public void gameRun(List<Player> playersInGame, List<Fields> fieldsInGame, Scanner console) {
       while(endGame){
           for (Player player:playersInGame) {
               try{
                   System.out.println("Je na ťahu:"+player.getName());
                   player.printPLayerInfo();
                   player.playerMovement();
                   Fields actual=fieldsInGame.get(player.getCurrentPosition());
                   actual.runAction(player,console);
                   player.printPLayerInfo();
                   System.out.println("---------------------------------");
               }
               catch (EndGameException e){
                   player.bancrot(fieldsInGame,player);
                   playersInGame.remove(player);
                   if(playersInGame.size()==1) {
                       System.err.println(e);
                       endGame = false;
                       break;
                   }
               }
           }
       }
   }
}