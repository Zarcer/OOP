package ru.nsu.zarcer;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TopologicalSortTest {

    @ParameterizedTest
    @ArgumentsSource(TopologicalSortTest.testArgumentsProvider.class)
    void topSortTest(Graph<String> graph) {
        try {
            graph.readFile("input.txt", "string");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        TopologicalSort<String> topSort = new TopologicalSort<>();
        List<String> test = topSort.sort(graph);
        List<String> testNew = new ArrayList<String>();
        testNew.add("A");
        testNew.add("C");
        testNew.add("B");
        assertEquals(testNew, test);
    }

    static class testArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of(new AdjacencyList<String>()),
                Arguments.of(new AdjacencyMatrix<String>()),
                Arguments.of(new IncidenceMatrix<String>()));
        }
    }

}