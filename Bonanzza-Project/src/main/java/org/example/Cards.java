package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

import static java.util.Arrays.asList;

public class Cards{

    public Hashtable<String, ArrayList<Integer>> cardsTypeCount;
    private Map<String, Map<Integer, Integer>> scoreInfo;
    private int numberOfTypes = 8;


    private List<String> deck;

    public Cards() {
        deck = new ArrayList<>();
        addCards("Blue Beans", 20);
        addCards("Chili Beans", 18);
        addCards("Stink Beans", 16);
        addCards("Green Beans", 14);
        addCards("Soy Beans", 12);
        addCards("Black-eyed Beans", 10);
        addCards("Red Beans", 8);
        addCards("Garden Beans", 6);

         cardsTypeCount.put("Blue Bean", (ArrayList<Integer>) asList(4,6,8,10));
         cardsTypeCount.put("Chilli Bean", (ArrayList<Integer>) asList(3,6,8,9));
         cardsTypeCount.put("Stink Bean", (ArrayList<Integer>) asList(3,5,7,8));
         cardsTypeCount.put("Green Bean",(ArrayList<Integer>) asList(3,5,6,7));
         cardsTypeCount.put("Soy Bean", (ArrayList<Integer>) asList(2,4,6,7));
         cardsTypeCount.put("Black-eyed Bean", (ArrayList<Integer>) asList(2,4,5,6));
         cardsTypeCount.put("Red Bean", (ArrayList<Integer>) asList(2,3,4,5));
         cardsTypeCount.put("Garden Bean", (ArrayList<Integer>) asList(0,2,3,0));
    }

    private void addCards(String type, int count) {
        for (int i = 0; i < count; i++) {
            deck.add(type);
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