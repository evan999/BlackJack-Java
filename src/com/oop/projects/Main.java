package com.oop.projects;

import com.oop.projects.BlackJack.Actors.Actor;
import com.oop.projects.BlackJack.Actors.Dealer;
import com.oop.projects.BlackJack.BlackJack;
import com.oop.projects.BlackJack.BlackJackHand;
import com.oop.projects.CardGames.Card;
import com.oop.projects.CardGames.Deck;
import com.oop.projects.CardGames.Rigged;
import com.oop.projects.CardGames.Standard;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BlackJack game = new BlackJack();
        game.play();
//        Deck deck = new Rigged();
//        deck.shuffle();
//        Actor dealer = new Dealer();
//        BlackJackHand hand = new BlackJackHand(dealer);

//        hand.addCard(deck.draw());
//        hand.addCard(deck.draw());
//        System.out.println(hand);
//        System.out.println(hand.getScore());
//        System.out.println(hand.getActor().getAction(hand.getScore()));
//        hand.addCard(deck.draw());
//        System.out.println(hand);
//        System.out.println(hand.getScore());
//        System.out.println(hand.getActor().getAction(hand.getScore()));
//        hand.addCard(deck.draw());
//        System.out.println(hand);
//        System.out.println(hand.getScore());
//        System.out.println(hand.getActor().getAction(hand.getScore()));

    }
}
