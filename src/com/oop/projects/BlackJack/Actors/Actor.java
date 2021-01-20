package com.oop.projects.BlackJack.Actors;

public interface Actor {

    String getName();
    int setBet();
    int getAction(int score, boolean isPair, int cardCount);

}
