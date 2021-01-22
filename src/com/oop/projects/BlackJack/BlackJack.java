package com.oop.projects.BlackJack;

import com.oop.projects.BlackJack.Actors.Player;
import com.oop.projects.CardGames.Card;

public class BlackJack {
    Table table = new Table();

    // TODO: Detect BlackJack
    // TODO: Allow players to continue playing until players either decide to quit or run out of money

    public void play() {

        table.createPlayers();
        table.getDeck().shuffle();
        deal();
        getPlayerBets();
        runPlayersTurns();
//        for (BlackJackHand player : table.getPlayers()) {
//            setBet(player);
//        }


//        setBet(table.getPlayer());
        table.getDealer().revealHand();
//        do {} while (!actorTurn(table.getPlayer()));
        do {} while (!actorTurn(table.getDealer()));
        displayTable();
        for (BlackJackHand player : table.getPlayers()) {
            endRound(player);
        }
        // TODO: Remove split hands
//        while (table.getPlayers().size() > table.getPlayerCount()) {
//            table.getPlayers().remove(table.getPlayers().size() - 1);
//        }
        table.cleanTable();
        // TODO: Add ability to repeat game.
        displayWallets();
//        endRound(table.getPlayer());
//        System.out.println(((Player)table.getPlayer().getActor()).getWallet());

    }

    private void displayWallets() {
        for (BlackJackHand hand: table.getPlayers()) {
            Player player = (Player) hand.getActor();
            System.out.println(player.getName() + " " + player.getWallet());
        }
    }

    private void getPlayerBets() {
        for (BlackJackHand player : table.getPlayers()) {
            setBet(player);
        }
    }

    private void runPlayersTurns() {
        for (int activeIndex = 0; activeIndex < table.getPlayers().size(); activeIndex++) {
            displayTable();
            BlackJackHand player = table.getPlayers().get(activeIndex);
            player.revealHand();
            do {} while (!actorTurn(player));
        }
    }

    private void endRound(BlackJackHand player) {
        char result = didWin(player);
        switch(result) {
            case 'n':
                System.out.println(player.getName() + " loses " + player.getBet());
                ((Player) player.getActor()).adjustWallet(player.getBet() * -1);
                break;
            case 'y':
                System.out.println(player.getName() + " wins " + player.getBet());
                ((Player) player.getActor()).adjustWallet(player.getBet());
                break;
            case 'p':
                System.out.println(player.getName() + " pushes with dealer keeps " + player.getBet());
                break;
            default:
                System.out.println("Did win error returned " + result);
        }
    }

    private void setBet(BlackJackHand player) {
        player.setBet();
    }

    private boolean actorTurn(BlackJackHand hand) {
        displayHand(hand);
        return performAction(hand, getAction(hand));
    }

    private int getAction(BlackJackHand hand) {
        return hand.getAction();
    }

    final int HIT = 1, STAND = 2, DOUBLE = 3, SPLIT = 4;

    private boolean performAction(BlackJackHand hand, int action){
        switch(action) {
            case DOUBLE:
                System.out.println("Double");
                hand.doubleBet();
            case HIT:
                Card card = table.getDeck().draw(true);
                System.out.println(hand.getName() +" Hit and was dealt " + card);
                hand.addCard(card);
                if (didBust(hand.getScore())){
                    System.out.println("Busted " + hand.getScore());
                    return true;
                }
                return action == DOUBLE ? true : false;
            case STAND:
                System.out.println(hand.getName() + " Stood.");
                return true;
            case SPLIT:
                split(hand);
                return false;
            default:
                System.out.println("ERROR! Default case Stand");
                return true;
        }
    }

    private void split(BlackJackHand hand) {
        Card splitCard = hand.removeCard(1);
        BlackJackHand newHand = new BlackJackHand(hand.getActor());
        newHand.addCard(splitCard);
        hand.addCard(table.getDeck().draw(true));
        newHand.addCard(table.getDeck().draw(true));
        newHand.setBet(hand.getBet());
        table.getPlayers().add(newHand);
    }

    private void deal() {
        for (int count = 0; count < 2; count++) {
//            table.getPlayer().addCard(table.getDeck().draw(count == 0 ? false : true));
            for (BlackJackHand player : table.getPlayers()) {
                player.addCard(table.getDeck().draw(count == 0 ? false : true));
            }
            table.getDealer().addCard(table.getDeck().draw(count == 0 ? false : true));
        }
    }

    private void displayTable() {
        System.out.println(table.getDealer().getName() + ": " + table.getDealer());
        for (BlackJackHand player : table.getPlayers()) {
            System.out.println(player.getName() + ": " + player);
        }
//        System.out.println(table.getPlayer().getName() + ": " + table.getPlayer());
    }

    private void displayHand(BlackJackHand hand) {
        System.out.println(hand);
        System.out.println(hand.getName() + " score is: " + hand.getScore());
    }

    private char didWin(BlackJackHand player) {
        int playerScore = player.getScore();
        int dealerScore = table.getDealer().getScore();
        if (didBust(playerScore)){
            System.out.println(player.getName() + " busted!");
            return 'n';
        }
        if (didBust(dealerScore)){
            System.out.println("Dealer busted!");
            return 'y';
        }
        System.out.println(player.getName() + " has " + playerScore + " | Dealer has " + dealerScore);
        if (playerScore < dealerScore) {
            System.out.println(player.getName() + " loses.");
            return 'n';
        }
        if (playerScore == dealerScore) {
            System.out.println("Push!");
            return 'p';
        }

        return 'y';
    }

    private boolean didBust(int score) {
        return score > 21;
    }
}
