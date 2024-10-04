package ru.nsu.zarcer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IncidenceMatrix<String> graph = new IncidenceMatrix<>();
        graph.readFile("input.txt", "string");
        TopologicalSort<String> topSort = new TopologicalSort<>();
        List<String> test = topSort.sort(graph);
        List<String> test2 = topSort.sort(graph);
        for(String line : test){
            System.out.println(line);
        }

    }
}