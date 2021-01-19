package com.oop.projects.BlackJack;

import com.oop.projects.BlackJack.Actors.Player;
import com.oop.projects.CardGames.Card;

public class BlackJack {
    Table table = new Table();

    public void play() {
        table.getDeck().shuffle();
        deal();
        setBet(table.getPlayer());
        displayTable();
        table.getPlayer().revealHand();

        endRound(table.getPlayer());

    }

    private void endRound(BlackJackHand player) {
        char result = didWin(player);
        switch(result) {
            case 'n':
                System.out.println(player.getName() + " loses" + player.getBet());
                ((Player) player.getActor()).adjustWallet(player.getBet() * -1);
                break;
            case 'y':
                System.out.println(player.getName() + " wins" + player.getBet());
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
            default:
                System.out.println("error! default case Stand");
                return true;
        }
    }

    private void deal() {
        for (int count = 0; count < 2; count++) {
            table.getPlayer().addCard(table.getDeck().draw(count == 0 ? false : true));
            table.getDealer().addCard(table.getDeck().draw(count == 0 ? false : true));
        }
    }

    private void displayTable() {
        System.out.println(table.getDealer().getName() + ": " + table.getDealer());
        System.out.println(table.getPlayer().getName() + ": " + table.getPlayer());
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
