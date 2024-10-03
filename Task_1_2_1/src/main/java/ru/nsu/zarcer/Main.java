package ru.nsu.zarcer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IncidenceMatrix<String> graph = new IncidenceMatrix<>();
        graph.readFile("input.txt");
        TopologicalSort<String> topSort = new TopologicalSort<>(graph);
        List<String> test = topSort.sort();
        for(String line : test){
            System.out.println(line);
        }
    }
}