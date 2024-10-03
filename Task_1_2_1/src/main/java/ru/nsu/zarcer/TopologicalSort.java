package ru.nsu.zarcer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TopologicalSort<T> {
    private Graph<T> graph;
    private boolean[] visited;
    private Deque<Integer> stack;

    TopologicalSort(Graph<T> graph) {
        this.graph = graph;
        int verticesCnt = graph.getVertexCnt();
        visited = new boolean[verticesCnt];
        stack = new ArrayDeque<>();
    }

    public List<T> sort() {
        for(int i = 0;i< visited.length;i++) {
            if(!visited[i]) {
                dfs(i);
            }
        }

        List<T> topSortedList = new ArrayList<>();
        while(!stack.isEmpty()) {
            topSortedList.add(graph.getVertex(stack.pop()));
        }
        return topSortedList;
    }

    private void dfs(int vertexId) {
        if(visited[vertexId]) {
            return;
        }
        visited[vertexId] = true;
        List<T> neighbors = graph.getNeighbors(vertexId);
        for(T neigbor : neighbors) {
            int neighborId = graph.getVertexId(neigbor);
            dfs(neighborId);
        }
        stack.push(vertexId);

    }

}
