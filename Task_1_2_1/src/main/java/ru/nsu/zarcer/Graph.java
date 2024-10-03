package ru.nsu.zarcer;

import java.util.List;

interface Graph<T> {
    void createVertex(T vertex);
    void deleteVertex(int indexId);
    void addEdge(int firstVertexId, int secondVertexId);
    void deleteEdge(int firstVertexId, int secondVertexId);
    List<T> getNeighbors(int vertexId);
    void readFile(String fileName);
    int getVertexCnt();
    int getVertexId(T vertex);
    T getVertex(int vertexId);
}