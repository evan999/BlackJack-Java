package com.oop.projects;

import com.oop.projects.CardGames.Card;
import com.oop.projects.CardGames.Deck;
import com.oop.projects.CardGames.Rigged;
import com.oop.projects.CardGames.Standard;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Deck deck = new Rigged();
        deck.shuffle();
        Card card = deck.draw();
        System.out.println(card);
    }
}
