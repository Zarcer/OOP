package ru.nsu.zarcer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Task for thread task.
 */
public class PrimeCore implements Runnable {
    private int[] numbers;
    private boolean notPrimeFound = false;
    private AtomicInteger atomicIndex;
    private int size;

    /**Constructor.
     *
     * @param numbers int array where non-prime number should be found
     *
     * @param index of current number in the array to calculated
     *
     * @param arraySize size of int array, added to program not calculate size everytime
     */
    PrimeCore(int[] numbers, AtomicInteger index, int arraySize) {
        this.numbers = numbers;
        this.atomicIndex = index;
        this.size = arraySize;
    }

    /**
     * Mostly iterating through array and calling isNotPrime method.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            int number;
            int currIndex = atomicIndex.getAndIncrement();
            if (currIndex >= size) {
                return;
            }
            number = numbers[currIndex];
            if (PrimeOperations.isNotPrime(number)) {
                notPrimeFound = true;
            }
        }
    }

    public boolean notPrimeFoundGetter() {
        return this.notPrimeFound;
    }
}