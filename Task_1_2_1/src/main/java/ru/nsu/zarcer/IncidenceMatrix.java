package ru.nsu.zarcer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IncidenceMatrix<T> implements Graph<T> {

    private ArrayList<ArrayList<Integer>> incMat;
    private ArrayList<T> vertexValues;
    private int edgeCount;
    IncidenceMatrix() {
        incMat = new ArrayList<>();
        vertexValues = new ArrayList<T>();
        edgeCount = 0;
    }

    public void createVertex(T vertex) {
        vertexValues.add(vertex);
        ArrayList<Integer> init = new ArrayList<Integer>();
        for(int i = 0;i<edgeCount;i++) {
            init.add(0);
        }
        incMat.add(init);
    }

    public void deleteVertex(int index) {
        vertexValues.remove(index);
        for(int i = 0;i<edgeCount;i++) {
            if(incMat.get(index).get(i)!=0) {
                for(int j = 0;j<incMat.size();j++) {
                    if(incMat.get(j).get(i)!=0){
                        deleteEdge(index, j);
                        break;
                    }
                }
            }
        }
        incMat.remove(index);
    }

    public void addEdge(int firstVertexIndex, int secondVertexIndex) {
        for(ArrayList<Integer> vertex: incMat) {
            vertex.add(0);
        }
        edgeCount++;
        incMat.get(firstVertexIndex).set(edgeCount-1, 1);
        incMat.get(secondVertexIndex).set(edgeCount-1, -1);
    }

    public void deleteEdge(int firstVertexIndex, int secondVertexIndex) {
        for(int i = 0;i<edgeCount;i++){
            if((incMat.get(firstVertexIndex).get(i)==1)&&(incMat.get(secondVertexIndex).get(i)==-1)){
                for(ArrayList<Integer> vertex: incMat){
                    vertex.remove(i);
                }
                edgeCount--;
                break;
            }
        }
    }

    public List<T> getNeighbors(int vertexIndex) {
        ArrayList<T> output = new ArrayList<>();
        for(int i = 0;i<edgeCount;i++) {
            if(incMat.get(vertexIndex).get(i)==1) {
                for(int j = 0;j<vertexValues.size();j++){
                    if(incMat.get(j).get(i)==-1){
                        output.add(vertexValues.get(j));
                        break;
                    }
                }
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