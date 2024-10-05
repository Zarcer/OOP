package ru.nsu.zarcer;

import java.util.*;

public class IncidenceMatrix<T> implements Graph<T> {

    private ArrayList<ArrayList<Integer>> incMat;
    private Map<Integer, T> vertexValues;
    private Map<Integer, Integer> idToIndex;
    private int edgeCount = 0;
    private int nextId = 0;

    public IncidenceMatrix() {
        incMat = new ArrayList<>();
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
        idToIndex.put(nextId, incMat.size());
        ArrayList<Integer> init = new ArrayList<Integer>();
        for (int i = 0; i < edgeCount; i++) {
            init.add(0);
        }
        incMat.add(init);
        nextId++;
    }

    /**Just deletion of vertex.
     *
     * @param vertexId id of vertex, indexation starting with zero
     *
     */
    public void deleteVertex(int vertexId) {
        try {
            if (idToIndex.get(vertexId) == null) {
                throw new Exception("Invalid Id");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        vertexValues.remove(vertexId);
        int indexVertex = idToIndex.get(vertexId);
        for (int i = 0; i < edgeCount; i++) {
            if (incMat.get(indexVertex).get(i) != 0) {
                for (ArrayList<Integer> delete : incMat) {
                    delete.remove(i);
                }
                edgeCount--;

            }
        }
        incMat.remove(indexVertex);
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
    public void addEdge(int firstVertexId, int secondVertexId) {
        try {
            if (idToIndex.get(firstVertexId) == null || idToIndex.get(secondVertexId) == null) {
                throw new Exception("Invalid Id");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (ArrayList<Integer> vertex : incMat) {
            vertex.add(0);
        }
        incMat.get(idToIndex.get(firstVertexId)).set(edgeCount, 1);
        incMat.get(idToIndex.get(secondVertexId)).set(edgeCount, -1);
        edgeCount++;
    }

    /**Just deletion of edge based on ids.
     *
     * @param firstVertexId id of initial vertex
     *
     * @param secondVertexId id of ending vertex
     *
     */
    public void deleteEdge(int firstVertexId, int secondVertexId) {
        try {
            if (idToIndex.get(firstVertexId) == null || idToIndex.get(secondVertexId) == null) {
                throw new Exception("Invalid Id");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < edgeCount; i++) {
            if ((incMat.get(idToIndex.get(firstVertexId)).get(i) == 1) && (incMat.get(idToIndex.get(secondVertexId)).get(i) == -1)) {
                for (ArrayList<Integer> vertex : incMat) {
                    vertex.remove(i);
                }
                edgeCount--;
                break;
            }
        }
    }

    /**Get neighbors of vertex, returns their values.
     *
     * @param vertexId id of vertex
     *
     * @return returns List of values of vertices
     */
    public List<T> getNeighbors(int vertexId) {
        ArrayList<T> output = new ArrayList<>();
        try {
            if (idToIndex.get(vertexId) == null) {
                throw new Exception("Invalid Id");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        int vertexIndex = idToIndex.get(vertexId);
        for (int i = 0; i < edgeCount; i++) {
            if (incMat.get(vertexIndex).get(i) == 1) {
                for (int j = 0; j < incMat.size(); j++) {
                    if (incMat.get(j).get(i) == -1) {
                        for (Integer key : idToIndex.keySet()) {
                            if (idToIndex.get(key) == j) {
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
    public int getVertexId(T vertex) {
        int key = -1;
        for (Map.Entry<Integer, T> entry : vertexValues.entrySet()) {
            if (Objects.equals(entry.getValue(), vertex)) {
                key = entry.getKey();
                break;
            }
        }
        try {
            if (key == -1) {
                throw new Exception("No such vertex");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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