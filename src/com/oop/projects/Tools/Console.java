package com.oop.projects.Tools;

import java.util.Scanner;

public class Console {
    Scanner scanner = new Scanner(System.in);


    public int requestInt(String text){
        System.out.println(text);
        return scanner.nextInt();
    }

    public String requestString(String text){
        System.out.println(text);
        return scanner.nextLine();
    }
}
