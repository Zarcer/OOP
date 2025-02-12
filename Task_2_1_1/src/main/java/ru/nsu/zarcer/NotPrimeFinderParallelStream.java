package ru.nsu.zarcer;

import java.util.Arrays;

/**
 * Class for computing non-prime numbers stream parallelism.
 */
public class NotPrimeFinderParallelStream implements PrimeFinderInterface {
    /** Method for finding non-prime number.
     *
     * @param numbersArray int array
     *
     * @return boolean, true if array has non-prime number, false otherwise
     */
    @Override
    public boolean checkNonPrime(int[] numbersArray) {
        return Arrays.stream(numbersArray).parallel().anyMatch(PrimeOperations::isNotPrime);
    }
}
