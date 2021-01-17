package com.oop.projects;

import com.oop.projects.BlackJack.BlackJackHand;
import com.oop.projects.CardGames.Card;
import com.oop.projects.CardGames.Deck;
import com.oop.projects.CardGames.Rigged;
import com.oop.projects.CardGames.Standard;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Deck deck = new Standard();
        deck.shuffle();
        BlackJackHand hand = new BlackJackHand();

        hand.addCard(deck.draw());
        hand.addCard(deck.draw());
        System.out.println(hand);
        System.out.println(hand.getScore());
        hand.addCard(deck.draw());
        System.out.println(hand);
        System.out.println(hand.getScore());
        hand.addCard(deck.draw());
        System.out.println(hand);
        System.out.println(hand.getScore());

    }
}
