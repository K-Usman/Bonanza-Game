package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private CardManager cardManager;
    private TradeManager tradeManager;
    private HarvestManager harvestManager;
    private List<Player> players;
    private Player activePlayer;

    public Game() {
        cardManager = new CardManager();
        tradeManager = new TradeManager();
        harvestManager = new HarvestManager();
        players = new ArrayList<>();
        initializeGame();
    }

    private void initializeGame() {
        String[] playerNames = {"Usman", "Pratiksha", "Surabhi"};
        for (String name : playerNames) {
            players.add(new Player(name));
        }

        cardManager.shuffle();
        distributeCards();
        selectStartingPlayer();
        displayInitialState();

        while (!cardManager.isDrawPileEmpty()) {
            takeTurn(activePlayer);
            moveToNextPlayer();
        }

        System.out.println("The draw pile is empty. The game is over.");
        calculateFinalCoins();
        displayFinalState();
    }

    public void takeTurn(Player player) {
        System.out.println("It's " + player.getName() + "'s turn.");
        plantBeans(player);
        cardManager.drawCards(player, 2);
        displayStateAfterDrawing();
        tradeManager.initiateTrade(player, players);
        harvestManager.promptHarvest(player);
    }

    public void moveToNextPlayer() {
        int currentIndex = players.indexOf(activePlayer);
        int nextIndex = (currentIndex + 1) % players.size();
        activePlayer = players.get(nextIndex);
    }

    public void distributeCards() {
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                player.addCardToHand(cardManager.drawCard());
            }
            for (int i = 0; i < 3; i++) {
                player.addField();
            }
        }
        cardManager.addCardsToDrawPile();
    }

    public void selectStartingPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select starting player from: ");
        for (Player player : players) {
            System.out.println(player.getName());
        }
        String selectedName = scanner.nextLine();
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(selectedName)) {
                activePlayer = player;
                break;
            }
        }
        System.out.println("Starting player: " + activePlayer.getName());
    }

    public void plantBeans(Player player) {
        List<String> hand = player.getHand();
        List<List<String>> fields = player.getFields();

        for (int i = 0; i < 3 && i < hand.size(); i++) {
            String card = hand.get(i);
            boolean planted = false;

            for (List<String> field : fields) {
                if (field.isEmpty() || field.get(0).equals(card)) {
                    field.add(card);
                    planted = true;
                    break;
                }
            }

            if (!planted) {
                System.out.println("Cannot plant " + card + " due to planting rules.");
                break;
            }
        }

        hand.subList(0, Math.min(3, hand.size())).clear();
    }

    public void calculateFinalCoins() {
        for (Player player : players) {
            for (List<String> field : player.getFields()) {
                if (!field.isEmpty()) {
                    String beanType = field.get(0);
                    int beanCount = field.size();
                    int coinsEarned = cardManager.calculateCoins(beanType, beanCount);
                    player.addCoins(coinsEarned);
                    player.addHarvestedBeans(new ArrayList<>(field));
                    field.clear();
                }
            }
        }

        System.out.println("Final coin count:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getCoins() + " coins");
        }
    }

    public void displayInitialState() {
        System.out.println("Initial State:");
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public void displayStateAfterDrawing() {
        System.out.println("State After Planting and Drawing:");
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public void displayFinalState() {
        System.out.println("Final State After Planting, Drawing, and Trading:");
        for (Player player : players) {
            System.out.println(player);
        }
    }
}