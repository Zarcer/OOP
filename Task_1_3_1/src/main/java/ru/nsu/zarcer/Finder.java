package ru.nsu.zarcer;

import java.io.*;
import java.util.ArrayList;

public class Finder {
    private static ArrayList<Integer> find(Reader readerr, String subName) throws IOException {
        int length = subName.length();
        ArrayList<Integer> output = new ArrayList<>();
        int c;
        int indexRead=-1;
        while((c=readerr.read())!=-1){
            int i = 0;
            indexRead++;
            int startingIndex=0;
            while(subName.charAt(i)==(char)c){
                if(i==0){
                    startingIndex=indexRead;
                }
                if(i==length-1){
                    output.add(startingIndex);
                    break;
                }
                else{
                    i++;
                }
                if((c=readerr.read())==-1){
                    readerr.close();
                    return output;
                }
                indexRead++;
            }
        }
        readerr.close();
        return output;
    }

    public static ArrayList<Integer> findFile(String fileName, String subName) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            return find(br, subName);
        }
        catch(IOException e){
            throw e;
        }

    }

    public static ArrayList<Integer> findRecourse(String fileName, String subName) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(Finder.class.getResourceAsStream("/"+fileName)))){
            return find(br, subName);
        } catch (IOException e) {
            throw e;
        }
    }


}