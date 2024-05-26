package org.example;

import java.util.*;

public class Cards{

    private Hashtable<String, ArrayList<Integer>> cardsTypeCount;
    private Map<String, Map<Integer, Integer>> scoreInfo;
    private int numberOfTypes = 12;

    public Cards(){
        cardsTypeCount = new Hashtable<String, ArrayList<Integer>>();
        cardsTypeCount.put("Coffee Bean", [24,4,7,10,12],);
        cardsTypeCount.put("Wax Bean", [22,4,7,9,11]);
        cardsTypeCount.put("Blue Bean", [20,4,6,8,10]);
        cardsTypeCount.put("Chilli Bean", [18,3,6,8,9]);
        cardsTypeCount.put("Stink Bean", [16,3,5,7,8]);
        cardsTypeCount.put("Green Bean", [14,3,5,6,7]);
        cardsTypeCount.put("Soy Bean", [12,2,4,6,7]);
        cardsTypeCount.put("Black-eyed Bean", [10,2,4,5,6]);
        cardsTypeCount.put("Red Bean", [8,2,3,4,5]);
        cardsTypeCount.put("Garden Bean", [6,0,2,3,0]);
        cardsTypeCount.put("Cocoa Bean", [4,0,2,3,4]);
        cardsTypeCount.put("Garden Bean", [3,0,2,3,0]);
    }

}
