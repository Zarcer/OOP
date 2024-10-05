package ru.nsu.zarcer;

import java.util.*;

public class IncidenceMatrix<T> implements Graph<T> {

    private ArrayList<ArrayList<Integer>> incMat;
    private Map<Integer, T> vertexValues;
    private Map<Integer, Integer> idToIndex;
    private int edgeCount=0;
    private int nextId=0;

    public IncidenceMatrix() {
        incMat = new ArrayList<>();
        vertexValues = new HashMap<>();
        idToIndex = new HashMap<>();
    }

    public void createVertex(T vertex) {
        vertexValues.put(nextId, vertex);
        idToIndex.put(nextId, incMat.size());
        ArrayList<Integer> init = new ArrayList<Integer>();
        for(int i = 0;i<edgeCount;i++) {
            init.add(0);
        }
        incMat.add(init);
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
        for(int i = 0;i<edgeCount;i++){
            if(incMat.get(indexVertex).get(i)!=0){
                for(ArrayList<Integer> delete : incMat){
                    delete.remove(i);
                }
                edgeCount--;

            }
        }
        incMat.remove(indexVertex);
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
        for(ArrayList<Integer> vertex: incMat) {
            vertex.add(0);
        }
        incMat.get(idToIndex.get(firstVertexId)).set(edgeCount, 1);
        incMat.get(idToIndex.get(secondVertexId)).set(edgeCount, -1);
        edgeCount++;
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
        for(int i = 0;i<edgeCount;i++){
            if((incMat.get(idToIndex.get(firstVertexId)).get(i)==1)&&(incMat.get(idToIndex.get(secondVertexId)).get(i)==-1)){
                for(ArrayList<Integer> vertex : incMat){
                    vertex.remove(i);
                }
                edgeCount--;
                break;
            }
        }
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
        for(int i = 0;i<edgeCount;i++) {
            if(incMat.get(vertexIndex).get(i)==1) {
                for(int j = 0;j<incMat.size();j++){
                    if(incMat.get(j).get(i)==-1){
                        for(Integer key : idToIndex.keySet()){
                            if(idToIndex.get(key)==j){
                                output.add(vertexValues.get(key));
                                break;
                            }
                        }
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