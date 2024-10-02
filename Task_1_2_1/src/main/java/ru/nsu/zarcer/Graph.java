package ru.nsu.zarcer;

import java.io.IOException;
import java.util.List;

interface Graph<T> {
    void createVertex(T vertex);
    void deleteVertex(int index);
    void addEdge(int firstVertexIndex, int secondVertexIndex);
    void deleteEdge(int firstVertexIndex, int secondVertexIndex);
    List<T> getNeighbors(int vertexIndex);
    void readFile(String fileName) throws IOException;
}