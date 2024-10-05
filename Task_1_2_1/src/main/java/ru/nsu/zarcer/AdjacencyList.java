package ru.nsu.zarcer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**Graph representation as adjList.
 *
 * @param <T> generic type
 */
public class AdjacencyList<T> implements Graph<T> {

    private HashMap<Integer, List<Integer>> adjList;
    private Map<Integer, T> vertexValues;
    private int nextId = 0;

    public AdjacencyList() {
        vertexValues = new HashMap<>();
        adjList = new HashMap<>();
    }

    /**Just creation of vertex.
     *
     * @param vertex value of vertex generic type
     *
     */
    public void createVertex(T vertex) {
        vertexValues.put(nextId, vertex);
        adjList.put(nextId, new ArrayList<>());
        nextId++;
    }

    /**Just deletion of vertex.
     *
     * @param vertexId id of vertex, indexation starting with zero
     *
     */
    public void deleteVertex(int vertexId) throws IndexOutOfBoundsException {
        if (vertexValues.get(vertexId) == null) {
            throw new IndexOutOfBoundsException("Invalid Id");
        }
        vertexValues.remove(vertexId);
        adjList.remove(vertexId);
        for (List<Integer> adjVert : adjList.values()) {
            adjVert.remove(Integer.valueOf(vertexId));
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
        if (vertexValues.get(firstVertexId) == null ||
            vertexValues.get(secondVertexId) == null) {
            throw new IndexOutOfBoundsException("Invalid Id");
        }
        adjList.get(firstVertexId).add(secondVertexId);
    }

    /**Just deletion of edge based on ids.
     *
     * @param firstVertexId id of initial vertex
     *
     * @param secondVertexId id of ending vertex
     *
     */
    public void deleteEdge(int firstVertexId, int secondVertexId) throws IndexOutOfBoundsException {
        if (vertexValues.get(firstVertexId) == null ||
            vertexValues.get(secondVertexId) == null) {
            throw new IndexOutOfBoundsException("Invalid Id");
        }
        adjList.get(firstVertexId).remove(Integer.valueOf(secondVertexId));
    }

    /**Get neighbors of vertex, returns their values.
     *
     * @param vertexId id of vertex
     *
     * @return returns List of values of vertices
     */
    public List<T> getNeighbors(int vertexId) throws IndexOutOfBoundsException {
        ArrayList<T> output = new ArrayList<>();
        if (vertexValues.get(vertexId) == null) {
            throw new IndexOutOfBoundsException("Invalid Id");
        }
        List<Integer> adjVert = adjList.get(vertexId);
        for (int vert : adjVert) {
            output.add(vertexValues.get(vert));
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
