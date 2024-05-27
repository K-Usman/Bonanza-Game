package org.example;

import java.util.List;

public class Planting extends beanField {

    public static void plantBeans(Player player) {
        List<String> hand = player.getHand();

        if (!hand.isEmpty()) {
            // Player must plant the first card
            String firstCard = hand.get(0);
            plantSingleBean(player, firstCard);
            player.removeCardFromHand(firstCard);

            // Player can optionally plant the second card
            if (hand.size() > 1) {
                String secondCard = hand.get(1);
                plantSingleBean(player, secondCard);
                player.removeCardFromHand(secondCard);
            }
        }
    }

    private static void plantSingleBean(Player player, String card) {
        for (String field : player.getFields()) {
            if (field.canPlant(card)) {
                field.plant(card);
                return;
            }
        }

        // If no field can accept the bean, force the player to harvest a field (assume the first field)
        String firstField = player.getFields().get(0);
        firstField.plant(card);
    }
}