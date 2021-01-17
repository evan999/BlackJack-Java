package com.oop.projects.BlackJack;

import com.oop.projects.CardGames.Card;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHand {
    List<Card> cards = new ArrayList<>();
    private int score;
    private boolean hasAce;

    public int getCount(){
        return cards.size();
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public Card removeCard(int index){
        return cards.remove(index);
    }

    @Override
    public String toString() {
        String output = "";
        for (var card : cards){
            output += card + " ";
        }
        return output.trim();
    }

    private int determineValue(int card) {
        if (isAce(card) && isSafe()) {
            card = 11;
            hasAce = true;
        }
        else if (isFace(card)) {
            card = 10;
        }

        return card;
    }

    public int getScore() {
        hasAce = false;
        score = 0;
        for (var card : cards){
            score += determineValue(card.getValue());
            if (score > 21 && hasAce) {
                score -= 10;
                hasAce = false;
            }
        }
        return score;
    }

    private boolean isAce (int value) {
        return value == 1;
    }

    private boolean isSafe () {
        return score + 11 <= 21;
    }

    private boolean isFace (int value) {
        return value > 10;
    }
}
