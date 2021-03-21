package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.fields.Buildings;
import sk.stuba.fei.uim.oop.fields.Fields;
import sk.stuba.fei.uim.oop.gamecyclus.Gamecyclus;

import java.util.List;
import java.util.Random;
public class Player extends Gamecyclus {
    private String name;
    private int order;
    private int budget;
    private int currentPosition;
    private boolean cantMove=true;

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    Random random = new Random();

    public Player(int order,String name) {
        this.currentPosition=0;
        this.order = order;
        this.budget=10000;
        this.name=name;
    }
    public int getBudget() {
        return budget;
    }
    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }

    public int rollTheDice(){
         return random.nextInt(6)+1;
    }
    public void printPLayerInfo(){
        System.out.println("Tvoje financie: "+budget);
        System.out.println("Tvoja aktuálna pozícia je : "+currentPosition+"\n");
    }

    public void playerPayments(int paymentValue){
        this.budget=this.budget-paymentValue;
    }
    public void incomes(int incomesValue) {
        this.budget=this.budget+incomesValue;
    }

    public void playerMovement() throws BancrotOfPlayerException {
        if(getBudget()<0) {
           throw new BancrotOfPlayerException("Skrachoval si");
        }
        if(cantMove)
            currentPosition+=rollTheDice();
            if(currentPosition>23)
                currentPosition=currentPosition-23;
        if (!cantMove){
            System.out.println("Toto kolo stojíš,lebo si vo vazeni");
            cantMove=true;
        }
    }
    public void buy(int price) {
        this.budget=this.budget-price;
    }

    public void goToPrison(int index){
        this.currentPosition=index;
        cantMove=false;
    }

    public void bancrot(List<Fields> fieldsInGame,Player player){
        for (Fields building:fieldsInGame) {
           if(building instanceof Buildings){
               if(((Buildings) building).getOwner().equals(player))
                   ((Buildings) building).setOwner(null);
           }
        }
    }
}
