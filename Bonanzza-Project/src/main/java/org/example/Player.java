package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<String> hand;
    private List<List<String>> fields;
    private int coins;
    private List<String> tradedBeans;
    private List<String> harvestedBeans;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.fields = new ArrayList<>();
        this.coins = 0;
        this.tradedBeans = new ArrayList<>();
        this.harvestedBeans = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getHand() {
        return hand;
    }

    public void addCardToHand(String card) {
        hand.add(card);
    }

    public List<List<String>> getFields() {
        return fields;
    }

    public void addField() {
        fields.add(new ArrayList<>());
    }

    public List<String> getTradedBeans() {
        return tradedBeans;
    }

    public void addTradedBean(String bean) {
        tradedBeans.add(bean);
    }

    public List<String> getHarvestedBeans() {
        return harvestedBeans;
    }

    public void addHarvestedBeans(List<String> beans) {
        harvestedBeans.addAll(beans);
    }

    public void addCoins(int coins) {
        this.coins += coins;
    }

    public int getCoins() {
        return coins;
    }

    @Override
    public String toString() {
        return name + " - Hand: " + hand + ", Fields: " + fields + ", Coins: " + coins + ", Traded Beans: " + tradedBeans + ", Harvested Beans: " + harvestedBeans;
    }
}