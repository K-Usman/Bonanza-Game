package org.example;
import java.util.ArrayList;
import java.util.List;

public class beanField {
    private static List<String> cards;
    private String currentBeanType;

    public beanField() {
        this.cards = new ArrayList<>();
        this.currentBeanType = null;
    }

    public boolean canPlant(String card) {
        return currentBeanType == null || currentBeanType.equals(card);
    }

    public void plant(String card) {
        if (canPlant(card)) {
            cards.add(card);
            currentBeanType = card;
        } else {
            throw new IllegalStateException("Cannot plant this bean in the current field");
        }
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public String getCurrentBeanType() {
        return currentBeanType;
    }

    public List<String> getCards() {
        return cards;
    }


}
