package sk.stuba.fei.uim.oop.playingArea;

public class RealEstate  {
    private int price;
    private int index;
    private int tariff;
    private String owner;

    public RealEstate(int index) {
        this.price=index*20000;
        this.tariff=index*2000;
        this.owner="free";
        this.index=index;

    }



}
