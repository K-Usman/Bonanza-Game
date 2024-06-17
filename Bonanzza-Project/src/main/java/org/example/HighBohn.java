package org.example;

import java.util.*;

class Bean {
    String type;
    int value;

    Bean(String type, int value) {
        this.type = type;
        this.value = value;
    }
}

class Building {
    String type;
    String bean;
    int price;
    String attribute;

    Building(String type,String bean, int price, String attribute) {
        this.type = type;
        this.bean = bean ;
        this.price = price;
        this.attribute = attribute;
    }
}




public class HighBohn   extends Game {
    List<Building> buildingDeck;
    List<Bean> beanDeck;
    List<Player> players;
    int round;
    int totalRounds;
    private Player activePlayer ;

    HighBohn(int numPlayers) {
        this.players = new ArrayList<Player>();
        this.buildingDeck = createBuildingDeck();
        this.beanDeck = createBeanDeck();
        this.round = 0;
        this.totalRounds = numPlayers < 5 ? 3 : 4;

    }

    private List<Building> createBuildingDeck() {
        List<Building> buildings = new ArrayList<>();
        // Add building data
        buildings.add(new Building("1 Jail","Blue Beans", 1, "None"));
        buildings.add(new Building("2 Jail","Blue Beans", 2, "Uses beanometer on the 2 Jail card"));
        buildings.add(new Building("3 Jail","Blue Beans", 3, "Uses beanometer on the 3 Jail card"));
        buildings.add(new Building("4 Jail","Blue Beans", 4, "The owner of the 4 Jail must watch for any harvest of blue beans by any player (including himself)"));
        buildings.add(new Building("1 Blacksmith","Chili beans", 1, "None"));
        buildings.add(new Building("2 Blacksmith","Chili beans", 2, "The 2 Blacksmith is like a “3rd bean field"));
        buildings.add(new Building("3 Blacksmith","Chili beans", 3, "The 3 Blacksmith uses the beanometer on the 3 blacksmith card when harvesting chili beans instead of the beanometer on the chili bean cards"));
        buildings.add(new Building("4 Blacksmith","Chili beans", 4, "The owner of the 4 Blacksmith may harvest a field with only one bean"));
        buildings.add(new Building("1 General Store", "Stink beans", 1, "None"));
        buildings.add(new Building("2 General Store", "Stink beans", 2, "The owner may store 1 Bean Card"));
        buildings.add(new Building("3 General Store", "Stink beans", 3, "The owner may store 2 Bean Card"));
        buildings.add(new Building("4 General Store", "Stink beans", 4, "The owner may store 3 Bean Card"));
        buildings.add(new Building("1 Saloon", "Green beans", 1, "None"));
        buildings.add(new Building("2 Saloon", "Green beans", 2, "The 2 Saloon is like a “3rd bean field”, but only green beans may be planted there"));
        buildings.add(new Building("3 Saloon", "Green beans", 3, "The owner may may choose to plant one bean each of different types in one or more of his fields (BeanStewPlanting)"));
        buildings.add(new Building("4 Saloon", "Green beans", 4, "The owner may may choose to plant one bean each of different types in one or more of his fields (BeanStewPlanting)"));
        buildings.add(new Building("1 Farm", "Soy beans", 1, "None"));
        buildings.add(new Building("2 Farm", "Soy beans", 2, "The attribute of the 2 Farm allows a player to plant soy beans in a field that already has other beans (numbered 14 or higher)"));
        buildings.add(new Building("3 Farm", "Soy beans", 3, "The owner of the 3 Farm must always, like others, plant at least one bean card in phase"));
        buildings.add(new Building("4 Farm", "Soy beans", 4, "The owner earns 5 gold coins from a harvest that would normally earn him exactly 4 gold coins"));
        buildings.add(new Building("1 Bank", "Black-eyed beans", 1, "None"));
        buildings.add(new Building("2 Bank", "Black-eyed beans", 2, " The attribute of the Bank must be taken at the exact time indicated on the card."));
        buildings.add(new Building("3 Bank", "Black-eyed beans", 3, " The attribute of the Bank must be taken at the exact time indicated on the card."));
        buildings.add(new Building("4 Bank", "Black-eyed beans", 4, " The attribute of the Bank must be taken at the exact time indicated on the card."));
        buildings.add(new Building("1 Indian tipi", "Red beans", 1, "None"));
        buildings.add(new Building("2 Indian tipi", "Red beans", 2, "Earns an additional gold coin"));
        buildings.add(new Building("3 Indian tipi", "Red beans", 3, "Earns an additional gold coin"));
        buildings.add(new Building("4 Indian tipi", "Red beans", 4, "Earns an additional gold coin"));
        buildings.add(new Building("1 Gold mine", "Garden beans", 1, "None"));
        buildings.add(new Building("2 Gold mine", "Garden beans", 2, "Pays only 1 gold coin for a 3rd bean field"));
        buildings.add(new Building("3 Gold mine", "Garden beans", 3, "Uses beanometer on the gold mine card"));
        buildings.add(new Building("4 Gold mine", "Garden beans", 4, "Additional bean field"));
        // Add other buildings as per rules
        return buildings;
    }

    private List<Bean> createBeanDeck() {
        List<Bean> beans = new ArrayList<>();
        // Add bean data excluding cocoa, coffee, and wax
        beans.add(new Bean("Garden bean", 1));
        beans.add(new Bean("Red bean", 2));
        // Add other beans as per rules
        return beans;
    }

    void startGame() {

        String[] playerNames = {"Usman", "Pratiksha", "Surabhi", "Teresa"};
        for (String player: playerNames) {
            players.add(new Player(player));
        }
        shuffleCards();
        distributeCards();
        shuffleBuilding();
        selectStartingPlayer();
        displayInitialState();

        // Main game loop
        while (!beanDeck.isEmpty()) {
            takeTurn(activePlayer);
            moveToNextPlayer();
        }

        // Game ends when draw pile is empty
        System.out.println("The draw pile is empty. The game is over.");
        displayFinalState();

//        while (round < totalRounds) {
//            for (Player player : players) {
//                // Simulate player's turn
//                player.harvest();
//                player.buyBuilding(buildingDeck.get(new Random().nextInt(buildingDeck.size())));
//            }
//            round++;
//        }
        endGame();
    }
    @Override
    public void takeTurn(Player player) {
        System.out.println("It's " + player.getName() + "'s turn.");
        plantBeans(player);
        drawCards(player, 2);  // Drawing 2 cards as an example
        displayStateAfterDrawing();
        promptTrade();
        promptHarvest(); // Prompt to harvest fields at the end of the turn
        promptBuilding(player);
    }

    void endGame() {
        for (Player player : players) {
            player.calculateBonus();
            System.out.println(player.getName() + " has " + player.getCoins() + " gold coins.");
        }

        Player winner = players.stream().max(Comparator.comparingInt(p -> p.getCoins())).orElse(null);
        if (winner != null) {
            System.out.println(winner.getName() + " is the winner with " + winner.getCoins() + " gold coins!");
        }
    }
    public void shuffleBuilding() {
        Collections.shuffle(buildingDeck) ;
    }
    public void promptBuilding(Player player){
        System.out.println("Do you want to buy Buildings? enter Yes or No ");
        Scanner scanner = new Scanner(System.in);
        String buyBuildings = scanner.nextLine();

        if (buyBuildings.equalsIgnoreCase("Yes")) {
            for(String beans :player.getHarvestedBeans() ){
                player.buyBuilding(buildingDeck.get(buildingDeck.indexOf(beans)), beans);
            }
        } else{
            System.out.println("Does any player wants to buy Buildings? enter Player Name/Names separated by space or No ");
            ArrayList<String>  playerNames = new ArrayList<String>;
            String playerName = scanner.nextLine();
//            String[] plyrs= playerName.split(",");
            for (String plyr : playerName.split(",") ){
                playerNames.add(plyr);
            }
            for(Player player1 : players){
                if (playerNames.equals("No")){break;}
                if (player1!= activePlayer && playerName.contains(player1.getName()) ){
                    for(String beans :player1.getHarvestedBeans() ){
                        player1.buyBuilding(buildingDeck.get(buildingDeck.indexOf(beans)), beans);
                    }

                }
            }

        }
    }
    public static void main(String[] args) {
        HighBohn game = new HighBohn(4);
        game.startGame();
    }
}
