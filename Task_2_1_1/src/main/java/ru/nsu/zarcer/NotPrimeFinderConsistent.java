package ru.nsu.zarcer;

public class NotPrimeFinderConsistent implements PrimeFinderInterface {
    @Override
    public boolean checkNonPrime(int[] numbers) {
        for(int number : numbers){
            if(PrimeOperations.isNotPrime(number)){
                return true;
            }
        }
        return false;
    }
}
