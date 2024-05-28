package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cards {
    private List<String> deck;
    private Map<String, Map<Integer, Integer>> coins;

    public Cards() {
        deck = new ArrayList<>();
        coins = new HashMap<>();
        initializeDeck();
    }

    private void initializeDeck() {
        addCards("Blue Beans", 2, new int[]{2, 3, 5}, new int[]{3, 5, 10});
        addCards("Chili Beans", 3, new int[]{2, 4, 6}, new int[]{3, 6, 8});
        addCards("Stink Beans", 3, new int[]{3, 5, 7}, new int[]{2, 4, 7});
        addCards("Green Beans", 3, new int[]{1, 2, 3}, new int[]{1, 3, 5});
        addCards("Soy Beans", 2, new int[]{2, 3, 4}, new int[]{2, 4, 6});
        addCards("Black-eyed Beans", 3, new int[]{2, 3, 5}, new int[]{1, 3, 5});
        addCards("Red Beans", 2, new int[]{2, 4, 6}, new int[]{1, 4, 7});
        addCards("Garden Beans", 5, new int[]{1, 2, 3}, new int[]{2, 3, 6});
    }

    private void addCards(String type, int count, int[] thresholds, int[] values) {
        Map<Integer, Integer> earningsMap = new HashMap<>();
        for (int i = 0; i < thresholds.length; i++) {
            earningsMap.put(thresholds[i], values[i]);
        }
        coins.put(type, earningsMap);
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

    public Map<String, Map<Integer, Integer>> getCoins() {
        return coins;
    }
}