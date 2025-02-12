package ru.nsu.zarcer;

/**
 * Class for ordinary computing non-prime numbers.
 */
public class NotPrimeFinderConsistent implements PrimeFinderInterface {
    /** Method for finding non-prime number
     *
     * @param numbers int array
     *
     * @return boolean, true if array has non-prime number, false otherwise
     */
    @Override
    public boolean checkNonPrime(int[] numbers) {
        for (int number : numbers) {
            if (PrimeOperations.isNotPrime(number)) {
                return true;
            }
        }
        return false;
    }
}
