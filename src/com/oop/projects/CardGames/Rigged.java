package com.oop.projects.CardGames;

import java.util.Scanner;

public class Rigged implements Deck {
    private final static String[] SUITS = {"♠", "♥", "♣", "♦"};

    @Override
    public void shuffle(){
        return;
    }

    @Override
    public Card draw(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Card Value: 1 - 13");
        int value = scanner.nextInt();
        System.out.println("Card suit: 1 - 4");
        String suit = scanner.next();
        return new Card(value, SUITS[Integer.parseInt(suit)]);
    }

    @Override
    public Boolean isEmpty(){
        return false;
    }
}
