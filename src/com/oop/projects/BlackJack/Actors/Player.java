package com.oop.projects.BlackJack.Actors;

import com.oop.projects.Tools.Console;

public class Player implements Actor {
    static int HIT = 1, STAND = 2, DOUBLE = 3, SPLIT = 4;
    static Console console = new Console();

    private String name;
    private int wallet;

    public Player() {
        name = console.requestString("What is your name?");
        wallet = 1000;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int setBet(){
        int bet;
        do {
            System.out.println("Wallet: " + wallet);
            bet = console.requestInt("What is your bet");
        } while (validateBet(bet));
        return bet;
    }

    public void adjustWallet(int amount){
        wallet += amount;
    }

    public int getWallet() {
        return wallet;
    }

    public void adjustWallet(int amount, String method) {
        switch (method) {
            case "win":
                wallet += amount;
                break;
            case "lose":
                wallet -= amount;
                break;
        }
    }

    private boolean validateBet(int bet) {
        return bet > wallet && bet > 0;
    }

    @Override
    public int getAction(int score, boolean isPair, int cardCount) {
        int choice;
        do {
            choice = console.requestInt(cardCount == 2 ? "What would you like to do 1=Hit, 2=Stand, 3=Double?" :
                    "What would you like to do 1=Hit, 2=Stand?"
            );
        } while (choice < 1 || choice > 3);
        return choice;
    }
}
