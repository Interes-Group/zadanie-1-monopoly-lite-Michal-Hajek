package sk.stuba.fei.uim.oop;


import java.util.ArrayList;
import java.util.List;

public class PLayer {
    private String name;
    private int order;
    private int budget;
    private int currentPosition;
    private List<Integer> indexOfOwnedRealEstate=new ArrayList<Integer>();


    public PLayer(int order,String name) {
        this.currentPosition=0;
        this.order = order;
        this.budget=1000;
        this.name=name;
    }
}
