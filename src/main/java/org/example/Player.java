package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player extends Game {
    private int playerId;
    private int numberOfFields;  
    private List<String> beanFields;
    private List<String> cardsInHand;
    private List<String> goldCoinStack;
    private List<String> turnedOverCards;
    private int score;

    public Player(int playerId, int numberOfFields) {
        this.playerId = playerId;
        this.numberOfFields = numberOfFields;
        this.beanFields = new ArrayList<>();
        this.cardsInHand = new ArrayList<>();
        this.goldCoinStack = new ArrayList<>();
        this.turnedOverCards = new ArrayList<>();
        this.score = 0;

        for (int i = 0; i < numberOfFields; i++) {
            beanFields.add(new beanField());
        }
    }

    public int scoreCalculation() {
        return score;
    }

    public void drawCards(Cards deck) {
        // Implement the logic to draw cards from the deck
    }

    public void purchaseField() {
        // Implement the logic to purchase a field
    }

    public List<String> getHand() {
        return cardsInHand;
    }

    public List<String> getFields() {
        return beanFields;
    }

    public void addCardToHand(String card) {
        cardsInHand.add(card);
    }

    public void removeCardFromHand(String card) {
        cardsInHand.remove(card);
    }

   
}
