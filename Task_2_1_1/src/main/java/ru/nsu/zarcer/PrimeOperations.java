package ru.nsu.zarcer;

import java.util.ArrayDeque;

/**
 * Class with all operating which interacting with prime numbers.
 */
public class PrimeOperations {
    /**Method for checking if number is prime or not.
     *
     * @param number number to be checked
     *
     * @return true if non-prime, false otherwise
     */
    public static boolean isNotPrime(int number) {
        if ((number == 1 || number == 0)) {
            return true;
        }
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if ((number % i) == 0) {
                return true;
            }
        }
        return false;
    }

    /**Method for generating prime numbers.
     *
     * @param n how many prime numbers should be generated
     *
     * @return int array of prime numbers
     */
    public static int[] primeGenerator(int n) {
        if ((n == 1 || n == 0)) {
            return new int[0];
        }
        int x;
        ArrayDeque<Integer> list = new ArrayDeque<>();
        for (x = 2; x <= n; x++) {
            if (!isNotPrime(x)) {
                list.push(x);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**Method for calculating speed.
     *
     * @param operation what class use to calculate non-prime numbers
     *
     * @param workingArray array of int itself
     *
     * @return first word if result of checkNonPrime, second is calculation time
     */
    public static String findNonPrimeCountSpeed(PrimeFinderInterface operation,
                                                int[] workingArray) {
        long start = System.currentTimeMillis();
        return (operation.checkNonPrime(workingArray)) + " " + (System.currentTimeMillis() - start);
    }
}