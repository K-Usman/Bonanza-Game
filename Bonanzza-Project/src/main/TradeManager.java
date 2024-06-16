package main;

import java.util.List;
import java.util.Scanner;

public class TradeManager {

    public void initiateTrade(Player activePlayer, List<Player> players) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to initiate a trade?");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Enter the beans you want to exchange:");
            String tradeOffer = scanner.nextLine();
            String[] tradeParts = tradeOffer.split(":");

            if (tradeParts.length == 2) {
                String offeredBean = tradeParts[0].trim();
                String requestedBean = tradeParts[1].trim();
                executeTrade(activePlayer, players, offeredBean, requestedBean);
            } else {
                System.out.println("Invalid trade format. Trade should be in the format OfferedBean:RequestedBean.");
            }
        }
    }

    private void executeTrade(Player activePlayer, List<Player> players, String offeredBean, String requestedBean) {
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

    private void processTrade(Player initiator, Player responder, String offeredBean, String requestedBean) {
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
    }
}