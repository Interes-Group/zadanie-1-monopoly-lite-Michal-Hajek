package sk.stuba.fei.uim.oop.player;

public class WrongInputExceptions extends Throwable {
   public WrongInputExceptions(){
       System.err.println("Zadajte cislo v rozmedzi 2-6");
   }
}
