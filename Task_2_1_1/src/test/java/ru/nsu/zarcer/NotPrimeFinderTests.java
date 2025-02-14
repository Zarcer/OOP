package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class NotPrimeFinderTests {

    @ParameterizedTest
    @ArgumentsSource(NotPrimeFinderProvider.class)
    void notPrimeFalse(PrimeFinderInterface operation) {
        int[] test = {3, 5, 7};
        assertFalse(operation.checkNonPrime(test));
    }

    @ParameterizedTest
    @ArgumentsSource(NotPrimeFinderProvider.class)
    void notPrimeTrue(PrimeFinderInterface operation) {
        int[] test = {3, 6, 5};
        assertTrue(operation.checkNonPrime(test));
    }

    @ParameterizedTest
    @ArgumentsSource(NotPrimeFinderProvider.class)
    void notPrimeSameNumberFalse(PrimeFinderInterface operation) {
        int[] test = {3, 3, 3, 3, 3, 3, 3};
        assertFalse(operation.checkNonPrime(test));
    }


    @ParameterizedTest
    @ArgumentsSource(NotPrimeFinderProvider.class)
    void notPrimeSameNumbersTrue(PrimeFinderInterface operation) {
        int[] test = {6, 6, 6, 6, 6, 6, 6};
        assertTrue(operation.checkNonPrime(test));
    }

    @ParameterizedTest
    @ArgumentsSource(NotPrimeFinderProvider.class)
    void notPrimeZeros(PrimeFinderInterface operation) {
        int[] test = {0, 0, 0, 0, 0, 0, 0};
        assertTrue(operation.checkNonPrime(test));
    }

    @ParameterizedTest
    @ArgumentsSource(NotPrimeFinderProvider.class)
    void notPrimeOnes(PrimeFinderInterface operation) {
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