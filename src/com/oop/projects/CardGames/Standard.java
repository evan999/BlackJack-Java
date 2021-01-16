package com.oop.projects.CardGames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Standard implements Deck {
    private final String[] SUITS = {"♠", "♥", "♣", "♦"};
    private final int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private List<Card> cards;

    public Standard(){
        cards = new ArrayList<>();
        for (var suit : SUITS){
            for (var value : VALUES){
                cards.add(new Card(value, suit));
            }
        }
    }

    // TODO: Add constructor that will allow custom suit and values

    // TODO: Add in jokers.

    // TODO: Fisher-Yates Algorithm for shuffling deck

    @Override
    public void shuffle(){
        Collections.shuffle(cards);
    }

    @Override
    public Card draw(){
        return cards.remove(cards.size() - 1);
    }

    @Override
    public Boolean isEmpty(){
        if (cards.size() == 0) return true;
        return false;
    }






}
