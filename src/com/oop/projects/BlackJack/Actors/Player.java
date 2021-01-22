package com.oop.projects.BlackJack.Actors;

import com.oop.projects.Tools.Console;

public class Player implements Actor {
    static int HIT = 1, STAND = 2, DOUBLE = 3, SPLIT = 4;

    private String name;
    private int wallet;

    public Player() {
        name = Console.requestString("What is your name?");
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
            System.out.println(name + "'s Wallet: " + wallet);
            bet = Console.requestInt("What is your bet?");
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
    public int getAction(int score, String query, int minChoice, int maxChoice) {
        int choice;
        do {
            choice = Console.requestInt(query);
        } while (choice < minChoice || choice > maxChoice);
        return choice;
    }
}
