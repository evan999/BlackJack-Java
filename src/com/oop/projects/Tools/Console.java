package com.oop.projects.Tools;

import java.util.Scanner;

public class Console {
    static Scanner scanner = new Scanner(System.in);


    public static int requestInt(String text){
        System.out.println(text);
        String input = scanner.nextLine();
        return Integer.parseInt(input);
        // TODO: Add a try/catch for entering in a bad number.
    }


    public static String requestString(String text){
        System.out.println(text);
        return scanner.nextLine();
    }
}
