package ru.nsu.zarcer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class IncidenceMatrix<T> implements Graph<T> {

    private ArrayList<ArrayList<Integer>> incMat;
    private Map<Integer, T> vertexValues;
    private Map<Integer, Integer> idToIndex;
    private int edgeCount=0;
    private int nextId=0;
    IncidenceMatrix() {
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
        for(ArrayList<Integer> vertex: incMat) {
            vertex.add(0);
        }
        incMat.get(idToIndex.get(firstVertexId)).set(edgeCount, 1);
        incMat.get(idToIndex.get(secondVertexId)).set(edgeCount, -1);
        edgeCount++;
    }

    public void deleteEdge(int firstVertexId, int secondVertexId) {
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

    public void print(){
        for(T vertex : vertexValues.values()){
            System.out.println(vertex);
        }
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