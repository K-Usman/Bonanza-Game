package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<String> hand;
//    private List<List<String>> fields;
    List<beanField> fields = new ArrayList<>();
    private int coins;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.fields = new ArrayList<>();
        this.coins = 0;
    }
    public Player getPlayer(String name) {
        return new Player(name);
    }
    public String getName() {
        return name;
    }

    public List<String> getHand() {
        return hand;
    }

    public List<List<String>> getFields() {
        return fields;
    }

    public void addCardToHand(String card) {
        hand.add(card);
    }

    public void addField() {
        fields.add(new ArrayList<>());
    }

    @Override
    public String toString() {
        return name + " - Hand: " + hand + ", Fields: " + fields;
    }
}