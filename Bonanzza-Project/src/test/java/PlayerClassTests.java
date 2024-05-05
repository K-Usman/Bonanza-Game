import org.example.Player;

public class PlayerClassTests {
    @Test
    public void scoreCalculationTest(){
        Player player=new Player();
        List<CardType> cardTypes = new ArrayList<>();
        cardTypes.add(new CardType("CardType1", 2, 5));
        cardTypes.add(new CardType("CardType2", 3, 8));
        int score=player.scoreCalculation(cardTypes);
        assertEquals(13,score);

    }
    @Test
    public void drawCardsTest(){
        Player player = new Player();
        List<CardType> cards = new ArrayList<>();
        cards.add(new CardType("Card1", 2, 5));
        cards.add(new CardType("Card1", 3, 8));
        List<CardType> cardsInHands=player.drawCards(cards);
        //add drawn cards and cards in hands
        int handCardsCount=3;
        assertEquals(6,cardsInHands);
    }
    @Test
    public void purchaseFieldTest(){
        Player player=new Player();
        int numberOfFields=2;
        int totalFields=player.purchaseField(1);
        assertEquals(3,totalFields);
    }
}
