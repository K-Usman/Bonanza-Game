package org.example;

import java.util.ArrayList;
import java.util.Map;

public class Player extends Game{
    public int playerId ;
    private int numberOfFields;
    //this will be provided by game class using distribute cards method
    private ArrayList<String> cardsInHand;
    private Map<String, Map<Integer, Integer>> cardsInFields;
    private Map<String, Map<Integer, Integer>> goldCoinStack;
    private ArrayList<String> turnedOverCards;
    public int score = 0 ;
    public Player(int playerId){
        playerId = playerId;
    }
    public int scoreCalculation(){
        return score;

    }

    public void drawCards(){

    }

    public void purchaseField(){

    }

}
