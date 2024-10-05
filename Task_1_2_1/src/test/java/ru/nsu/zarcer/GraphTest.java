package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class GraphTest {
    @ParameterizedTest
    @ArgumentsSource(TestArgumentsProvider.class)
    void createVertexTest(Graph<String> graph) {
        try {
            graph.readFile("input.txt", "string");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        graph.createVertex("stringTest");
        assertEquals(3, graph.getVertexId("stringTest"));
        assertEquals("stringTest", graph.getVertex(3));
    }

    @ParameterizedTest
    @ArgumentsSource(TestArgumentsProvider.class)
    void deleteVertexTest(Graph<String> graph) {
        try {
            graph.readFile("input.txt", "string");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            graph.deleteVertex(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        List<String> neighborsTest = graph.getNeighbors(0);
        List<String> test = new ArrayList<String>();
        test.add("C");
        assertEquals(test, neighborsTest);
    }

    @ParameterizedTest
    @ArgumentsSource(TestArgumentsProvider.class)
    void addEdgeTest(Graph<String> graph) {
        try {
            graph.readFile("input.txt", "string");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        graph.addEdge(1, 0);
        List<String> neighborsTest = graph.getNeighbors(1);
        List<String> test = new ArrayList<String>();
        test.add("A");
        assertEquals(test, neighborsTest);
    }

    @ParameterizedTest
    @ArgumentsSource(TestArgumentsProvider.class)
    void deleteEdgeTest(Graph<String> graph) {
        try {
            graph.readFile("input.txt", "string");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        graph.deleteEdge(0, 1);
        List<String> neighborsTest = graph.getNeighbors(0);
        List<String> test = new ArrayList<String>();
        test.add("C");
        assertEquals(test, neighborsTest);
    }

    @ParameterizedTest
    @ArgumentsSource(TestArgumentsProvider.class)
    void getNeighborsTest(Graph<String> graph) {
        try {
            graph.readFile("input.txt", "string");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        List<String> neighborsTest = graph.getNeighbors(0);
        List<String> test = new ArrayList<String>();
        test.add("B");
        test.add("C");
        assertEquals(test, neighborsTest);
    }

    @ParameterizedTest
    @ArgumentsSource(TestArgumentsProvider.class)
    void getVertexCnt(Graph<String> graph) {
        try {
            graph.readFile("input.txt", "string");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(3, graph.getVertexCnt());
    }

    @ParameterizedTest
    @ArgumentsSource(TestArgumentsProvider.class)
    void getVertexIdTest(Graph<String> graph) {
        try {
            graph.readFile("input.txt", "string");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(0, graph.getVertexId("A"));
    }

    @ParameterizedTest
    @ArgumentsSource(TestArgumentsProvider.class)
    void getVertexTest(Graph<String> graph) {
        try {
            graph.readFile("input.txt", "string");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("A", graph.getVertex(0));
    }


    static class TestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of(new AdjacencyList<String>()),
                Arguments.of(new AdjacencyMatrix<String>()),
                Arguments.of(new IncidenceMatrix<String>()));
        }
    }
}