package ru.nsu.zarcer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Finder {
    public static ArrayList<Integer> find(String fileName, String subName) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(Finder.class.getResourceAsStream("/input.txt")));
        int length = subName.length();
        ArrayList<Integer> output = new ArrayList<>();
        int c;
        int indexRead=-1;
        while((c=br.read())!=-1){
            int i = 0;
            indexRead++;
            int startingIndex=0;
            char character = (char)c;
            while(subName.charAt(i)==character){
                if(i==0){
                    startingIndex=indexRead;
                }
                if(i==length-1){
                    output.add(startingIndex);
                }
                else{
                    i++;
                }
                if((c=br.read())==-1){
                    br.close();
                    return output;
                }
                character = (char)c;
                indexRead++;
            }
        }
        br.close();
        return output;
    }
}