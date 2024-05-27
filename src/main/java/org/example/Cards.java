package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards extends Game {
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
