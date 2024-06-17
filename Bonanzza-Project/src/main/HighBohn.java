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

//class Building {
//    String type;
//    String bean;
//    int price;
//    String attribute;
//
//    Building(String type,String bean, int price, String attribute) {
//        this.type = type;
//        this.bean = bean ;
//        this.price = price;
//        this.attribute = attribute;
//    }
//}




public class HighBohn extends Game {
    Building building ;

    private Cards cards;
//    List<Bean> beanDeck;
    List<Player> players;
    int round;
    int totalRounds;
    private Player activePlayer ;

    public HighBohn(int numPlayers) {
        System.out.println("Inside the Highbohn Constructor");
        this.players = new ArrayList<Player>();
        this.building = new Building();
        this.cards = new Cards();
        this.round = 0;
        this.totalRounds = numPlayers < 5 ? 3 : 4;
        startGame();
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
        System.out.println("Start Game next is create  building deck");
        //        shuffleBuilding();
        selectStartingPlayer();
        displayInitialState();


        // Main game loop
        while (!cards.getDeck().isEmpty()) {
            takeTurn(activePlayer);

            moveToNextPlayer();
        }

        // Game ends when draw pile is empty
        System.out.println("The draw pile is empty. The game is over.");
        displayFinalState();

        endGame();
    }
    @Override
    public void takeTurn(Player player) {
        System.out.println("It's " + player.getName() + "'s turn.");
        plantBeans(player);
        drawCards(player, 2);  // Drawing 2 cards as an example
        displayStateAfterDrawing();

        System.out.println(" Working here "+ building.buildingDeck);
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

    public void promptBuilding(Player player){
        System.out.println("Do you want to buy Buildings? enter Yes or No ");
        Scanner scanner = new Scanner(System.in);
        String buyBuildings = scanner.nextLine();

        if (buyBuildings.equalsIgnoreCase("Yes")) {
            System.out.println(building.getBuildingDeck());
            for(String beans :player.getHarvestedBeans() ){
                Map<String, List<String>> buildingData =  building.getBuildingdata();
                List<String> buildingtype = buildingData.get(beans);

                player.buyBuilding(buildingtype , beans);
            }
        } else{
            System.out.println("Does any other player wants to buy Buildings? enter Player Name/Names separated by space or No ");
            ArrayList<String>  playerNames = new ArrayList<String>();
            String playerName = scanner.nextLine();
//            String[] plyrs= playerName.split(",");
            for (String plyr : playerName.split(",") ){
                playerNames.add(plyr);
            }
            for(Player player1 : players){
                if (playerNames.equals("No")){break;}
                if (player1!= activePlayer && playerName.contains(player1.getName()) ){
                    for(String beans :player1.getHarvestedBeans() ){
                        Map<String, List<String>> buildingData =  building.getBuildingdata();
                        List<String> buildingtype = buildingData.get(beans);
                        player1.buyBuilding(buildingtype , beans);
                    }

                }
            }

        }
    }
    public static void main(String[] args) {
        System.out.println("Inside Main ");
        HighBohn game = new HighBohn(4);
        System.out.println("Inside Main ");
//        game.HighBohn(4);

    }
}
