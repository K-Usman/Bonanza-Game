package org.example;
import java.util.* ;
public class Harvesting extends Game {

    private int numberOfHarvestedCards;
    private int calculatedScore;
    int goldCoins = 0;
    private Map<String, Map<Integer, Integer>> goldCoinStack;
    public int numberOfBeans ;
    public ArrayList<Integer> goldCoinValues;
    //this method should harvest bean cards, add to gold coid stack and add the cards to draw card pile.
    public void Harvesting() {
        for (int i = 0; i < 5; i++) {
            goldCoinValues.add(i);
        }
    }
    public  void harvestCards(beanField field, String cardType, Player player){
        List<String> cards = field.getCards();
        if (cards.isEmpty()) this.goldCoins += 0;
        numberOfBeans = cards.size();
        int coins = getCoinValue(cards.get(0), numberOfBeans);

        // Simulate removing beans and giving coins
        cards.clear();
        this.goldCoins += coins;
    }
    public int getCoinValue(String cardType, int numberOfBeans){
        Cards cards = new Cards();
        ArrayList<Integer> cardValue =  cards.cardsTypeCount.get(cardType);

            for (int i : cardValue){
                if (numberOfBeans<i){

                    System.out.println("Can Not harvest less than " + i+ " Bean Cards");
                    break;
                }
//                else if (numberOfBeans == i) {
//                goldCoins +=  goldCoinValues.get(cardValue.indexOf(i) + 1);
//                break;
//                }
//                else if (numberOfBeans > i){
//                    continue
//                }
        }
        return numberOfBeans;
    }

//    public void calculateScore(){}
//
//    public void checkBeanPortection(){}
//
//    public void harvestedCards(){}


}
