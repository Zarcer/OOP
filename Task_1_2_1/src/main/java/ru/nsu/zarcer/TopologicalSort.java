package ru.nsu.zarcer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**TopSort algorithm.
 *
 * @param <T> generic type
 */
public class TopologicalSort<T> {
    private boolean[] visited;
    private Deque<Integer> stack;

    /**Sorting algorithm itself.
     *
     * @param graph graph on which sorted be executed
     *
     * @return returns sorted List based of graph vertices
     *
     */
    public List<T> sort(Graph<T> graph) {
        int verticesCnt = graph.getVertexCnt();
        visited = new boolean[verticesCnt];
        stack = new ArrayDeque<>();
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(i, graph);
            }
        }
        List<T> topSortedList = new ArrayList<>();
        while (!stack.isEmpty()) {
            topSortedList.add(graph.getVertex(stack.pop()));
        }
        return topSortedList;
    }

    /**Just dfs that uses recursion.
     *
     * @param vertexId from what node execute dfs
     *
     * @param graph graph that need to be sorted
     */
    private void dfs(int vertexId, Graph<T> graph) {
        if (visited[vertexId]) {
            return;
        }
        visited[vertexId] = true;
        List<T> neighbors = graph.getNeighbors(vertexId);
        for (T neigbor : neighbors) {
            int neighborId = graph.getVertexId(neigbor);
            dfs(neighborId, graph);
        }
        stack.push(vertexId);
    }
}
