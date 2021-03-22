package sk.stuba.fei.uim.oop;
import sk.stuba.fei.uim.oop.gamecyclus.Gamecyclus;
/**
 ****************************************************************
VYPRACOVAL: Michal Hájek 104463
 ****************************************************************
 **/
public class Assignment1 {
    public static void main(String[] args) {
        Gamecyclus game=new Gamecyclus();
        game.gameRun(game.getPlayersInGame(),game.getGameFields());

    }
}
