package ru.nsu.zarcer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            String test = Finder.find("input.txt", "бра");
            System.out.println(test);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}