package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Cards cards;
    private List<Player> players;
    private List<String> drawCardsPile;
    private Player activePlayer;

    public Game() {
        cards = new Cards();
        players = new ArrayList<>();
        drawCardsPile = new ArrayList<>();
        initializeGame();
    }

    private void initializeGame() {
        String[] playerNames = {"Usman", "Pratiksha", "Surabhi", "Teresa"};
        for (String name : playerNames) {
            players.add(new Player(name));
        }

        shuffle();
        distributeCards();
        selectStartingPlayer();
        displayInitialState();
        plantBeans(activePlayer);
        drawCards(activePlayer, 2);  // Drawing 2 cards as an example
        displayStateAfterDrawing();
        promptTrade();
        promptHarvest(); // Prompt to harvest fields at the end
    }

    public void shuffle() {
        cards.shuffle();
    }

    public void distributeCards() {
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                player.addCardToHand(cards.drawCard());
            }
            for (int i = 0; i < 3; i++) {
                player.addField();
            }
        }
        addCardsToDrawPile();
    }

    public void addCardsToDrawPile() {
        drawCardsPile.addAll(cards.getDeck());
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

    public void drawCards(Player player, int numberOfCards) {
        for (int i = 0; i < numberOfCards && !drawCardsPile.isEmpty(); i++) {
            String card = drawCardsPile.remove(0);
            player.addCardToHand(card);
        }
    }

    public void promptTrade() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to initiate a trade? (yes/no)");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Enter the trade you want to make (format: OfferedBean:RequestedBean):");
            String tradeOffer = scanner.nextLine();
            String[] tradeParts = tradeOffer.split(":");

            if (tradeParts.length == 2) {
                String offeredBean = tradeParts[0].trim();
                String requestedBean = tradeParts[1].trim();
                initiateTrade(offeredBean, requestedBean);
            } else {
                System.out.println("Invalid trade format. Trade should be in the format OfferedBean:RequestedBean.");
            }
        }
    }

    public void initiateTrade(String offeredBean, String requestedBean) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who wants to trade with " + activePlayer.getName() + "?");
        String responderName = scanner.nextLine();

        Player responder = null;
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(responderName)) {
                responder = player;
                break;
            }
        }

        if (responder != null && !responder.equals(activePlayer)) {
            processTrade(activePlayer, responder, offeredBean, requestedBean);
        } else {
            System.out.println("Invalid player selected for trade or player is the same as active player.");
        }
    }

    public void processTrade(Player initiator, Player responder, String offeredBean, String requestedBean) {
        if (initiator.getHand().contains(offeredBean) && responder.getHand().contains(requestedBean)) {
            initiator.getHand().remove(offeredBean);
            responder.getHand().remove(requestedBean);
            initiator.getHand().add(requestedBean);
            responder.getHand().add(offeredBean);

            initiator.addTradedBean(requestedBean);
            responder.addTradedBean(offeredBean);

            System.out.println("Trade successful!");
        } else {
            System.out.println("Trade failed. One or both players do not have the required beans.");
        }
        displayFinalState();  // Display state after trade
    }

    public void promptHarvest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to harvest any fields? (yes/no)");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Enter the fields to harvest (1, 2, and/or 3), separated by commas:");
            String fieldsInput = scanner.nextLine();
            String[] fieldIndices = fieldsInput.split(",");
            for (String fieldIndex : fieldIndices) {
                try {
                    int index = Integer.parseInt(fieldIndex.trim()) - 1;
                    harvestField(activePlayer, index);
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("Invalid field index: " + fieldIndex);
                }
            }
        }
    }

    public void harvestField(Player player, int fieldIndex) {
        if (fieldIndex < 0 || fieldIndex >= player.getFields().size()) {
            System.out.println("Invalid field index.");
            return;
        }

        List<String> field = player.getFields().get(fieldIndex);
        if (field.isEmpty()) {
            System.out.println("Field " + (fieldIndex + 1) + " is empty, nothing to harvest.");
            return;
        }

        String beanType = field.get(0);
        int beanCount = field.size();
        int coinsEarned = calculateEarnings(beanType, beanCount);

        player.addCoins(coinsEarned);
        player.addHarvestedBeans(new ArrayList<>(field));
        field.clear();

        System.out.println(player.getName() + " harvested " + beanCount + " " + beanType + " and earned " + coinsEarned + " coins.");
        displayFinalState(); // Update the display after harvesting
    }

    private int calculateEarnings(String beanType, int beanCount) {
        Map<Integer, Integer> earningsMap = cards.getEarnings().get(beanType);
        int coins = 0;

        for (Map.Entry<Integer, Integer> entry : earningsMap.entrySet()) {
            if (beanCount >= entry.getKey()) {
                coins = entry.getValue();
            }
        }

        return coins;
    }

    public void displayInitialState() {
        System.out.println("Initial State:");
        for (Player player : players) {
            System.out.println(player);
        }
        System.out.println("Draw Pile: " + drawCardsPile);
    }

    public void displayStateAfterDrawing() {
        System.out.println("State After Planting and Drawing:");
        for (Player player : players) {
            System.out.println(player);
        }
        System.out.println("Draw Pile: " + drawCardsPile);
    }

    public void displayFinalState() {
        System.out.println("Final State After Planting, Drawing, and Trading:");
        for (Player player : players) {
            System.out.println(player);
        }
        System.out.println("Draw Pile: " + drawCardsPile);
    }

    public static void main(String[] args) {
        new Game();
    }
}