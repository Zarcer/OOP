package ru.nsu.zarcer;

import java.util.*;

public class AdjacencyMatrix<T> implements Graph<T> {

    private ArrayList<ArrayList<Integer>> adjMat;
    private Map<Integer, T> vertexValues;
    private Map<Integer, Integer> idToIndex;
    private int nextId = 0;

    public AdjacencyMatrix() {
        adjMat = new ArrayList<>();
        vertexValues = new HashMap<>();
        idToIndex = new HashMap<>();
    }

    public void createVertex(T vertex) {
        vertexValues.put(nextId, vertex);
        int newIndex = adjMat.size();
        idToIndex.put(nextId, newIndex);
        for(ArrayList<Integer> test : adjMat) {
            test.add(0);
        }
        ArrayList<Integer> newVert = new ArrayList<Integer>();
        for(int i = 0; i <= newIndex; i++) {
            newVert.add(0);
        }
        adjMat.add(newVert);
        nextId++;
    }

    public void deleteVertex(int vertexId) {
        try{
            if(idToIndex.get(vertexId)==null){
                throw new Exception("Invalid Id");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        vertexValues.remove(vertexId);
        int indexVertex = idToIndex.get(vertexId);
        adjMat.remove(indexVertex);
        for(ArrayList<Integer> test : adjMat) {
            test.remove(indexVertex);
        }
        idToIndex.remove(vertexId);
        for(Map.Entry<Integer, Integer> entry : idToIndex.entrySet()){
            if(entry.getValue()>indexVertex){
                idToIndex.put(entry.getKey(), entry.getValue()-1);
            }
        }
    }

    public void addEdge(int firstVertexId, int secondVertexId) {
        try{
            if(idToIndex.get(firstVertexId) == null || idToIndex.get(secondVertexId)==null) {
                throw new Exception("Invalid Id");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        adjMat.get(idToIndex.get(firstVertexId)).set(idToIndex.get(idToIndex.get(secondVertexId)), 1);
    }

    public void deleteEdge(int firstVertexId, int secondVertexId) {
        try{
            if(idToIndex.get(firstVertexId) == null || idToIndex.get(secondVertexId)==null) {
                throw new Exception("Invalid Id");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        adjMat.get(idToIndex.get(firstVertexId)).set(idToIndex.get(idToIndex.get(secondVertexId)), 0);
    }

    public List<T> getNeighbors(int vertexId) {
        ArrayList<T> output = new ArrayList<>();
        try{
            if(idToIndex.get(vertexId)==null){
                throw new Exception("Invalid Id");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        int vertexIndex = idToIndex.get(vertexId);
        for(int i = 0;i< adjMat.size();i++){
            if(adjMat.get(vertexIndex).get(i)!=0){
                for(Integer key : idToIndex.keySet()){
                    if(idToIndex.get(key) == i){
                        output.add(vertexValues.get(key));
                        break;
                    }
                }
            }
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