package sk.stuba.fei.uim.oop.player;

public class WrongInputExceptions extends Throwable {
   public WrongInputExceptions(){
       System.err.println("Zly input skus to znova");
   }
}
