package com.oop.projects.CardGames;

public interface Deck {
    void shuffle();
    Card draw(boolean facing);
    Boolean isEmpty();
}
