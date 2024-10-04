package ru.nsu.zarcer;

import java.util.*;

public class AdjacencyList<T> implements Graph<T> {

    private HashMap<Integer, List<Integer>> adjList;
    private Map<Integer, T> vertexValues;
    private int nextId = 0;
    private T typeCheck;
    public AdjacencyList() {
        vertexValues = new HashMap<>();
        adjList = new HashMap<>();
    }

    public void createVertex(T vertex) {
        vertexValues.put(nextId, vertex);
        adjList.put(nextId, new ArrayList<>());
        nextId++;
    }

    public void deleteVertex(int vertexId) {
        if(vertexValues.get(vertexId)==null){
            return;
        }
        vertexValues.remove(vertexId);
        adjList.remove(vertexId);
        for(List<Integer> adjVert : adjList.values()){
            adjVert.remove(Integer.valueOf(vertexId));
        }
    }

    public void addEdge(int firstVertexId, int secondVertexId) {
        if(vertexValues.get(firstVertexId)==null||vertexValues.get(secondVertexId)==null){
            return;
        }
        adjList.get(firstVertexId).add(secondVertexId);
    }

    public void deleteEdge(int firstVertexId, int secondVertexId) {
        if(vertexValues.get(firstVertexId)==null||vertexValues.get(secondVertexId)==null){
            return;
        }
        adjList.get(firstVertexId).remove(Integer.valueOf(secondVertexId));
    }

    public List<T> getNeighbors(int vertexId) {
        ArrayList<T> output = new ArrayList<>();
        if(vertexValues.get(vertexId)==null){
            return output;
        }
        List<Integer> adjVert = adjList.get(vertexId);
        for(int vert : adjVert){
            output.add(vertexValues.get(vert));
        }
        return output;
    }

    public int getVertexCnt() {
        return vertexValues.size();
    }

    public int getVertexId(T vertex) {
        int key = 0;
        for(Map.Entry<Integer, T> entry : vertexValues.entrySet()) {
            if(Objects.equals(entry.getValue(), vertex)) {
                key = entry.getKey();
                break;
            }
        }
        return key;
    }

    public T getVertex(int vertexId) {
        return vertexValues.get(vertexId);
    }
}
