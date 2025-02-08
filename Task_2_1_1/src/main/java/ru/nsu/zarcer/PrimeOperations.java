package ru.nsu.zarcer;

import java.util.ArrayDeque;

public class PrimeOperations {
    public static boolean isNotPrime(int number){
        for(int i = 2;i<=(int)Math.sqrt(number);i++){
            if((number%i)==0){
                return true;
            }
        }
        return false;
    }

    public static int[] primeGenerator(int N){
        int x;
        ArrayDeque<Integer> list = new ArrayDeque<>();
        for(x=2;x<=N;x++){
            if(!isNotPrime(x)){
                list.push(x);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
