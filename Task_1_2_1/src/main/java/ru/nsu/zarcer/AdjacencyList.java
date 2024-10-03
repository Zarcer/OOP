package ru.nsu.zarcer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AdjacencyList<T> implements Graph<T> {

    private HashMap<Integer, List<Integer>> adjList;
    private Map<Integer, T> vertexValues;
    private int nextId = 0;
    private T typeCheck;
    AdjacencyList() {
        vertexValues = new HashMap<>();
        adjList = new HashMap<>();
    }


    public void createVertex(T vertex) {
        vertexValues.put(nextId, vertex);
        adjList.put(nextId, new ArrayList<>());
        nextId++;
    }

    public void deleteVertex(int indexId) {
        vertexValues.remove(indexId);
        adjList.remove(indexId);
        for(List<Integer> adjVert : adjList.values()){
            adjVert.remove(Integer.valueOf(indexId));
        }
    }

    public void addEdge(int firstVertexId, int secondVertexId) {
        adjList.get(firstVertexId).add(secondVertexId);
    }

    public void deleteEdge(int firstVertexId, int secondVertexId) {
        adjList.get(firstVertexId).remove(Integer.valueOf(secondVertexId));
    }

    public List<T> getNeighbors(int vertexId) {
        ArrayList<T> output = new ArrayList<>();
        List<Integer> adjVert = adjList.get(vertexId);
        for(int vert : adjVert){
            output.add(vertexValues.get(vert));
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
                    if(typeCheck instanceof String){
                        createVertex((T) line);
                    }
                    else if(typeCheck instanceof Integer){
                        createVertex((T)Integer.valueOf(line));
                    }
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

    public int getVertexCnt() {
        return vertexValues.size();
    }

    public int getVertexId(T vertex) {
        for(Map.Entry<Integer, T> entry : vertexValues.entrySet()) {
            if(entry.getValue()==vertex) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public T getVertex(int vertexId) {
        return vertexValues.get(vertexId);
    }
}
