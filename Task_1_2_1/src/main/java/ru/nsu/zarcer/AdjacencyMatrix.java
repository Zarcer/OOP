package ru.nsu.zarcer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**Graph representation as adjMatrix.
 *
 * @param <T> generic type
 */
public class AdjacencyMatrix<T> implements Graph<T> {

    private ArrayList<ArrayList<Integer>> adjMat;
    private Map<Integer, T> vertexValues;
    private Map<Integer, Integer> idToIndex;
    private int nextId = 0;

    /**
     * Constructor that initializes lists and maps.
     */
    public AdjacencyMatrix() {
        adjMat = new ArrayList<>();
        vertexValues = new HashMap<>();
        idToIndex = new HashMap<>();
    }

    /**Just creation of vertex.
     *
     * @param vertex value of vertex generic type
     *
     */
    public void createVertex(T vertex) {
        vertexValues.put(nextId, vertex);
        int newIndex = adjMat.size();
        idToIndex.put(nextId, newIndex);
        for (ArrayList<Integer> test : adjMat) {
            test.add(0);
        }
        ArrayList<Integer> newVert = new ArrayList<Integer>();
        for (int i = 0; i <= newIndex; i++) {
            newVert.add(0);
        }
        adjMat.add(newVert);
        nextId++;
    }

    /**Just deletion of vertex.
     *
     * @param vertexId id of vertex, indexation starting with zero
     *
     */
    public void deleteVertex(int vertexId) throws IndexOutOfBoundsException {
        if (idToIndex.get(vertexId) == null) {
            throw new IndexOutOfBoundsException("Invalid Id");
        }
        vertexValues.remove(vertexId);
        int indexVertex = idToIndex.get(vertexId);
        adjMat.remove(indexVertex);
        for (ArrayList<Integer> test : adjMat) {
            test.remove(indexVertex);
        }
        idToIndex.remove(vertexId);
        for (Map.Entry<Integer, Integer> entry : idToIndex.entrySet()) {
            if (entry.getValue() > indexVertex) {
                idToIndex.put(entry.getKey(), entry.getValue() - 1);
            }
        }
    }

    /**Just addition of edge based on ids.
     *
     * @param firstVertexId id of initial vertex
     *
     * @param secondVertexId id of ending vertex
     *
     */
    public void addEdge(int firstVertexId, int secondVertexId) throws IndexOutOfBoundsException {
        if (idToIndex.get(firstVertexId) == null
            || idToIndex.get(secondVertexId) == null) {
            throw new IndexOutOfBoundsException("Invalid Id");
        }
        adjMat.get(idToIndex.get(firstVertexId))
            .set(idToIndex.get(idToIndex.get(secondVertexId)), 1);
    }

    /**Just deletion of edge based on ids.
     *
     * @param firstVertexId id of initial vertex
     *
     * @param secondVertexId id of ending vertex
     *
     */
    public void deleteEdge(int firstVertexId, int secondVertexId) throws IndexOutOfBoundsException {
        if (idToIndex.get(firstVertexId) == null
            || idToIndex.get(secondVertexId) == null) {
            throw new IndexOutOfBoundsException("Invalid Id");
        }
        adjMat.get(idToIndex.get(firstVertexId))
            .set(idToIndex.get(idToIndex.get(secondVertexId)), 0);
    }

    /**Get neighbors of vertex, returns their values.
     *
     * @param vertexId id of vertex
     *
     * @return returns List of values of vertices
     */
    public List<T> getNeighbors(int vertexId) throws IndexOutOfBoundsException {
        ArrayList<T> output = new ArrayList<>();
        if (idToIndex.get(vertexId) == null) {
            throw new IndexOutOfBoundsException("Invalid Id");
        }
        int vertexIndex = idToIndex.get(vertexId);
        for (int i = 0; i < adjMat.size(); i++) {
            if (adjMat.get(vertexIndex).get(i) != 0) {
                for (Integer key : idToIndex.keySet()) {
                    if (idToIndex.get(key) == i) {
                        output.add(vertexValues.get(key));
                        break;
                    }
                }
            }
        }
        return output;
    }

    /**Returns number of vertices.
     *
     * @return just int
     *
     */
    public int getVertexCnt() {
        return vertexValues.size();
    }

    /**Returns id of vertex based on id.
     *
     * @param vertex value of vertex which id method will return
     *
     * @return just int
     *
     */
    public int getVertexId(T vertex) throws IndexOutOfBoundsException {
        int key = -1;
        for (Map.Entry<Integer, T> entry : vertexValues.entrySet()) {
            if (Objects.equals(entry.getValue(), vertex)) {
                key = entry.getKey();
                break;
            }
        }
        if (key == -1) {
            throw new IndexOutOfBoundsException("No such vertex");
        }
        return key;
    }

    /**Just returns value of vertex based on id.
     *
     * @param vertexId id of vertex
     *
     * @return generic type T
     *
     */
    public T getVertex(int vertexId) {
        return vertexValues.get(vertexId);
    }

}