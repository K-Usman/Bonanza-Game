package org.example;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
     private Cards cards; //instance of the card class
     private int numberOfPlayers = 3;
     public static final int deckSize = 157;
     private ArrayList<String> players;
     private int startingPlayer;
     private String activePlayer;
     private String winningPlayer;
     private int winnerScore;
     private ArrayList<Integer> drawCardsPile;
    // public static final int deckSize = 157;
     public Game() {
         System.out.print("WLCOME TO THE BOHNANZA GAME!");
         numberOfPlayers =  countPlayers();
            ArrayList<Player> players = new ArrayList<Player>();
            for (int i = 1; i <= numberOfPlayers; i++) {
                players.add(new Player(i));
            }

            startingPlayer = selectStartingPlayer(players);
            distributeCards(numberOfPlayers);
     }
    public int countPlayers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of players: ");
        numberOfPlayers = sc.nextInt();
        if(numberOfPlayers <= 3){
          // Initiate general version of the game with 3 players having 3 fields.
            return numberOfPlayers;
        }
        else{
            // Initiate the variation of game having 2 fields
            return numberOfPlayers ;
        }
    }
    public void distributeCards(int numberOfPlayers){
        Cards cards = new Cards();
        shuffle();
         for (int i = 0; i < numberOfPlayers; i++) {

        }
    }

    public int selectStartingPlayer(ArrayList<Player> players ){
            Random rndm = new Random();
            int id = players.get(rndm.nextInt(players.size())).playerId ;
            System.out.println("The starting Player is player no: " + id );
             return id;

    }
    public void identifyActivePlayer(){

    }

    public void decideWinningPlayer(){

    }

    public void addCardsToDrawPile(){

    }

    public void shuffle(){

        for (int i = 0; i < deckSize; ++i) drawCardsPile.add(i);

        ArrayList<Integer> shuffledDeck = new ArrayList<>();

        while (drawCardsPile.size() > 0) {
            int index = (int) (Math.random() * drawCardsPile.size());
            shuffledDeck.add(drawCardsPile.remove(index));

        }

        System.out.println(shuffledDeck.toString());

     }

}






