package ru.nsu.zarcer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdjacencyMatrix<T> implements Graph<T> {

    private ArrayList<ArrayList<Integer>> adjMat;
    private ArrayList<T> vertexValues;
    AdjacencyMatrix() {
        adjMat = new ArrayList<>();
        vertexValues = new ArrayList<T>();
    }

    public void createVertex(T vertex) {
        vertexValues.add(vertex);
        for(ArrayList<Integer> test : adjMat) {
            test.add(0);
        }
        ArrayList<Integer> newVert = new ArrayList<Integer>();
        for(int i = 0; i< vertexValues.size(); i++) {
            newVert.add(0);
        }
        adjMat.add(newVert);
    }

    public void deleteVertex(int index) {
        vertexValues.remove(index);
        adjMat.remove(index);
        for(ArrayList<Integer> test : adjMat) {
            test.remove(index);
        }
    }

    public void addEdge(int firstVertexIndex, int secondVertexIndex) {
        adjMat.get(firstVertexIndex).set(secondVertexIndex, 1);
    }

    public void deleteEdge(int firstVertexIndex, int secondVertexIndex) {
        adjMat.get(firstVertexIndex).set(secondVertexIndex, 0);
    }

    public List<T> getNeighbors(int vertexIndex) {
        ArrayList<T> output = new ArrayList<>();
        for(int i = 0;i<vertexValues.size();i++) {
            if(adjMat.get(vertexIndex).get(i)!=0) {
                output.add(vertexValues.get(i));
            }
        }
        return output;
    }

    public void readFile(String fileName) {
        try (BufferedReader scaning = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean readingVertices = true;
            while((line = scaning.readLine()) != null) {
                if(Objects.equals(line, "VERTEX")) {
                    continue;
                }
                else if(Objects.equals(line, "EDGE")) {
                    readingVertices = false;
                    continue;
                }
                if(readingVertices) {
                    createVertex((T) line);
                }
                else {
                    String[] parts = line.split(" ");
                    int firstVertexIndex = Integer.parseInt(parts[0]);
                    int secondVertexIndex = Integer.parseInt(parts[1]);
                    addEdge(firstVertexIndex, secondVertexIndex);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}