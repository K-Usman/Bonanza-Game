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
    List<Bean> beans;
    List<String> buildings;
//    int goldCoins;
    int bonusCoins;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.fields = new ArrayList<>();
        this.coins = 0;
        this.tradedBeans = new ArrayList<>();
        this.harvestedBeans = new ArrayList<>();
//        this.beans = new ArrayList<>();
        this.buildings = new ArrayList<String>();
//        this.goldCoins = 0;
        this.bonusCoins = 0;
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

    void addBean(Bean bean) {
        beans.add(bean);
    }

    void buyBuilding(List<String> buildingData, String beanType ) {
        String buildingType = (String) buildingData.get(0);
        int price = Integer.valueOf(buildingData.get(1));
        if (coins >= price ) {
            buildings.add(buildingType);
            coins -= price;
            System.out.println(name + " bought " + buildingType + " for " + price + " coins.");
        } else {
            System.out.println(name + " does not have enough coins to buy " +buildingType);
        }
    }

    void harvest() {
        int totalValue = 0;
        for (Bean bean : beans) {
            totalValue += bean.value;
        }
        coins += totalValue;
        beans.clear();
        System.out.println(name + " harvested and earned " + totalValue + " gold coins.");
    }

    void calculateBonus() {
        int buildingCount = buildings.size();
        if (buildingCount >= 4) {
            bonusCoins = switch (buildingCount) {
                case 4 -> 1;
                case 5 -> 2;
                case 6 -> 3;
                case 7 -> 5;
                case 8 -> 8;
                default -> 0;
            };
            coins += bonusCoins;
        }
    }
}