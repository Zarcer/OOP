package ru.nsu.zarcer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

interface Graph<T> {
    void createVertex(T vertex);
    void deleteVertex(int indexId);
    void addEdge(int firstVertexId, int secondVertexId);
    void deleteEdge(int firstVertexId, int secondVertexId);
    List<T> getNeighbors(int vertexId);
    default void readFile(String fileName, T typeCheck) throws IOException {
            BufferedReader scaning = new BufferedReader(new FileReader(fileName));
            String line;
            boolean readingVertices = true;
            while((line = scaning.readLine()) != null) {
                if(Objects.equals(line, "VERTEX")) {
                    continue;
                }
                if(Objects.equals(line, "EDGE")) {
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
                    int firstVertexId = Integer.parseInt(parts[0]);
                    int secondVertexId = Integer.parseInt(parts[1]);
                    addEdge(firstVertexId, secondVertexId);
                }
            }
    }
    int getVertexCnt();
    int getVertexId(T vertex);
    T getVertex(int vertexId);
}