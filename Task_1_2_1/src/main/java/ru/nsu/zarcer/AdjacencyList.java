package ru.nsu.zarcer;

import java.util.*;

public class AdjacencyList<T> implements Graph<T> {

    private HashMap<Integer, List<Integer>> adjList;
    private Map<Integer, T> vertexValues;
    private int nextId = 0;

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
        try{
            if(vertexValues.get(vertexId)==null){
                throw new Exception("Invalid Id");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        vertexValues.remove(vertexId);
        adjList.remove(vertexId);
        for(List<Integer> adjVert : adjList.values()){
            adjVert.remove(Integer.valueOf(vertexId));
        }
    }

    public void addEdge(int firstVertexId, int secondVertexId) {
        try{
            if(vertexValues.get(firstVertexId) == null || vertexValues.get(secondVertexId)==null) {
                throw new Exception("Invalid Id");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        adjList.get(firstVertexId).add(secondVertexId);
    }

    public void deleteEdge(int firstVertexId, int secondVertexId) {
        try{
            if(vertexValues.get(firstVertexId) == null || vertexValues.get(secondVertexId)==null) {
                throw new Exception("Invalid Id");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        adjList.get(firstVertexId).remove(Integer.valueOf(secondVertexId));
    }

    public List<T> getNeighbors(int vertexId) {
        ArrayList<T> output = new ArrayList<>();
        try{
            if(vertexValues.get(vertexId)==null){
                throw new Exception("Invalid Id");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
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
        int key = -1;
        for(Map.Entry<Integer, T> entry : vertexValues.entrySet()) {
            if(Objects.equals(entry.getValue(), vertex)) {
                key = entry.getKey();
                break;
            }
        }
        try{
            if(key==-1){
                throw new Exception("No such vertex");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return key;
    }

    public T getVertex(int vertexId) {
        return vertexValues.get(vertexId);
    }
}
