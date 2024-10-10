package ru.nsu.zarcer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.println(Finder.find("", "бра"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}