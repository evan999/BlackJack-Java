package com.oop.projects.BlackJack;

import com.oop.projects.BlackJack.Actors.Dealer;
import com.oop.projects.BlackJack.Actors.Player;
import com.oop.projects.CardGames.Deck;
import com.oop.projects.CardGames.Standard;

public class Table {
    private BlackJackHand dealer = new BlackJackHand(new Dealer());
    private BlackJackHand player = new BlackJackHand(new Player());
    private Deck deck = new Standard();

    public Deck getDeck() {
        return deck;
    }

    public BlackJackHand getDealer() {
        return dealer;
    }

    public BlackJackHand getPlayer() {
        return player;
    }
}
