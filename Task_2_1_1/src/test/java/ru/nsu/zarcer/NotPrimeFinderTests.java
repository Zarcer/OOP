package ru.nsu.zarcer;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NotPrimeFinderTests {

    @ParameterizedTest
    @ArgumentsSource(NotPrimeFinderProvider.class)
    void NotPrimeFalse(PrimeFinderInterface operation) {
        int[] test = {3, 5, 7};
        assertFalse(operation.checkNonPrime(test));
    }

    @ParameterizedTest
    @ArgumentsSource(NotPrimeFinderProvider.class)
    void NotPrimeTrue(PrimeFinderInterface operation) {
        int[] test = {3, 6, 5};
        assertTrue(operation.checkNonPrime(test));
    }

    @ParameterizedTest
    @ArgumentsSource(NotPrimeFinderProvider.class)
    void NotPrimeSameNumberFalse(PrimeFinderInterface operation) {
        int[] test = {3, 3, 3, 3, 3, 3, 3};
        assertFalse(operation.checkNonPrime(test));
    }


    @ParameterizedTest
    @ArgumentsSource(NotPrimeFinderProvider.class)
    void NotPrimeSameNumbersTrue(PrimeFinderInterface operation) {
        int[] test = {6, 6, 6, 6, 6, 6, 6};
        assertTrue(operation.checkNonPrime(test));
    }

    @ParameterizedTest
    @ArgumentsSource(NotPrimeFinderProvider.class)
    void NotPrimeZeros(PrimeFinderInterface operation) {
        int[] test = {0, 0, 0, 0, 0, 0, 0};
        assertTrue(operation.checkNonPrime(test));
    }

    @ParameterizedTest
    @ArgumentsSource(NotPrimeFinderProvider.class)
    void NotPrimeOnes(PrimeFinderInterface operation) {
        int[] test = {1, 1, 1, 1, 1, 1, 1};
        assertTrue(operation.checkNonPrime(test));
    }

    static class NotPrimeFinderProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                Arguments.of(new NotPrimeFinderConsistent()),
                Arguments.of(new NotPrimeFinderParallelStream()),
                Arguments.of(new NotPrimeFinderThreads(1)),
                Arguments.of(new NotPrimeFinderThreads(2)),
                Arguments.of(new NotPrimeFinderThreads(3)),
                Arguments.of(new NotPrimeFinderThreads(4)));
        }
    }

}