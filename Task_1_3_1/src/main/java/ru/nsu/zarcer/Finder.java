package ru.nsu.zarcer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Finder {
    public static String find(String fileName, String subName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder scanned = new StringBuilder();
        StringBuilder output = new StringBuilder();
        int c;
        while ((c = br.read()) != -1) {
            char readed = (char) c;
            scanned.append(readed);
        }
        int length = subName.length();
        int indexTemp;
        int startingIndex = 0;
        output.append("[");
        while ((indexTemp = scanned.indexOf(subName, startingIndex)) != -1) {
            startingIndex = indexTemp + length;
            output.append(indexTemp);
            if(scanned.indexOf(subName, startingIndex)==-1){
                output.append("]");
                break;
            }
            else{
                output.append(",").append(" ");
            }

        }
        br.close();
        return output.toString();
    }
}