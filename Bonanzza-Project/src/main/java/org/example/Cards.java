package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

import static java.util.Arrays.asList;

public class Cards{

    private Hashtable<String, ArrayList<Integer>> cardsTypeCount;
    private Map<String, Map<Integer, Integer>> scoreInfo;
    private int numberOfTypes = 8;

    public Cards(){
//        The Value is a list containing 5 items where 0th item is number of card of that type
//        1st to 4th represents the number of cards needed to harvest 1,2,3 and 4 gold coins respectively.
         cardsTypeCount.put("Coffee Bean", (ArrayList<Integer>) asList(24,4,7,10,12));
         cardsTypeCount.put("Wax Bean", (ArrayList<Integer>) asList(22, 4, 7, 9, 11));
         cardsTypeCount.put("Blue Bean", (ArrayList<Integer>) asList(20,4,6,8,10));
         cardsTypeCount.put("Chilli Bean", (ArrayList<Integer>) asList(18,3,6,8,9));
         cardsTypeCount.put("Stink Bean", (ArrayList<Integer>) asList(16,3,5,7,8));
         cardsTypeCount.put("Green Bean",(ArrayList<Integer>) asList(14,3,5,6,7));
         cardsTypeCount.put("Soy Bean", (ArrayList<Integer>) asList(12,2,4,6,7));
         cardsTypeCount.put("Black-eyed Bean", (ArrayList<Integer>) asList(10,2,4,5,6));
         cardsTypeCount.put("Red Bean", (ArrayList<Integer>) asList(8,2,3,4,5));
         cardsTypeCount.put("Garden Bean", (ArrayList<Integer>) asList(6,0,2,3,0));
         cardsTypeCount.put("Cocoa Bean", (ArrayList<Integer>) asList(4,0,2,3,4));
         cardsTypeCount.put("Garden Bean", (ArrayList<Integer>) asList(3,0,2,3,0));

    }

}
    public void shuffle() {
        Collections.shuffle(deck);
    }

    public String drawCard() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        }
        return null;
    }

    public List<String> getDeck() {
        return deck;
    }
}