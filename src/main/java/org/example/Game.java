package org.example;
import java.util.Map;

import java.util.ArrayList;
import java.util.List;

public class Game {
     private Cards cards; //instance of the card class
     private int numberOfPlayers;
     private int deckSize;
     private List<String> players;
     private String startingPlayer;
     private String activePlayer;
     private String winningPlayer;
     private int winnerScore;
     private List<String> drawCardsPile;
     public Game() {
        cards = new Cards();
        players = new ArrayList<>();
        drawCardsPile = new ArrayList<>();
        initializeGame();
    }


    public int countPlayers(){
        return numberOfPlayers;
    }
   
    public void selectStartingPlayer(){

    }
    public void identifyActivePlayer(){

    }

    public void decideWinningPlayer(){

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





