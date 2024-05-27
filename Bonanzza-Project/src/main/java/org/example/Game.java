package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Cards cards; // Instance of the Cards class
    private List<Player> players;
    private List<String> drawCardsPile;

    public Game() {
        cards = new Cards();
        players = new ArrayList<>();
        drawCardsPile = new ArrayList<>();
        initializeGame();
    }

    private void initializeGame() {
        // Define player names
        String[] playerNames = {"Usman", "Pratiksha", "Surabhi"};
        for (String name : playerNames) {
            players.add(new Player(name));
        }

        shuffle();
        distributeCards();
        displayInitialState();
    }

    public void shuffle() {
        cards.shuffle();
    }

    public void distributeCards() {
        for (Player player : players) {
            // Give each player 5 cards
            for (int i = 0; i < 5; i++) {
                player.addCardToHand(cards.drawCard());
            }
            // Give each player 3 fields
            for (int i = 0; i < 3; i++) {
                player.addField();
            }
        }
        addCardsToDrawPile();
    }

    public void addCardsToDrawPile() {
        drawCardsPile.addAll(cards.getDeck());
    }

    public void displayInitialState() {
        for (Player player : players) {
            System.out.println(player);
        }
        System.out.println("Draw Pile: " + drawCardsPile);
    }

    public static void main(String[] args) {
        new Game();
    }
}