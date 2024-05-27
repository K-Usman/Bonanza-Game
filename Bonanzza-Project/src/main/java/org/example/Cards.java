package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cards {
    private List<String> deck;
    private Map<String, Map<Integer, Integer>> earnings;

    public Cards() {
        deck = new ArrayList<>();
        earnings = new HashMap<>();
        initializeDeck();
    }

    private void initializeDeck() {
        addCards("Blue Beans", 20, new int[]{2, 3, 5}, new int[]{3, 5, 10});
        addCards("Chili Beans", 18, new int[]{2, 4, 6}, new int[]{3, 6, 8});
        addCards("Stink Beans", 16, new int[]{3, 5, 7}, new int[]{2, 4, 7});
        addCards("Green Beans", 14, new int[]{1, 2, 3}, new int[]{1, 3, 5});
        addCards("Soy Beans", 12, new int[]{2, 3, 4}, new int[]{2, 4, 6});
        addCards("Black-eyed Beans", 10, new int[]{2, 3, 5}, new int[]{1, 3, 5});
        addCards("Red Beans", 8, new int[]{2, 4, 6}, new int[]{1, 4, 7});
        addCards("Garden Beans", 6, new int[]{1, 2, 3}, new int[]{2, 3, 6});
        addCards("Bean Field Mats", 5, new int[]{1}, new int[]{0});
    }

    private void addCards(String type, int count, int[] thresholds, int[] values) {
        Map<Integer, Integer> earningsMap = new HashMap<>();
        for (int i = 0; i < thresholds.length; i++) {
            earningsMap.put(thresholds[i], values[i]);
        }
        earnings.put(type, earningsMap);
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

    public Map<String, Map<Integer, Integer>> getEarnings() {
        return earnings;
    }
}