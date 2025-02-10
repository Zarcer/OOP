package ru.nsu.zarcer;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NotPrimeFinderParallelStream implements PrimeFinderInterface{
    public boolean checkNonPrime(int[] numbersArray){
        ArrayDeque<Integer> numbers = Arrays.stream(numbersArray).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        for(Object item : numbers.parallelStream().map(PrimeOperations::isNotPrime).toArray()){
            if((Boolean)item){
                return true;
            }
        }
        return false;
    }
}
