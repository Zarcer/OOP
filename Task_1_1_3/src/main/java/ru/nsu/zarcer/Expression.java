package ru.nsu.zarcer;

import java.util.HashMap;

public abstract class Expression {
    public int eval(String s) {
        return evaluate(stringToMap(s));
    }
    private HashMap<String, Integer> stringToMap(String variables) {
        String[] words = variables.split(";");
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(int i = 0;i < words.length;i++) {
            words[i] = words[i].trim();
            int wordLength = words[i].length();
            int lastSpaceIndex = words[i].lastIndexOf(' ');
            int firstSpaceIndex = words[i].indexOf(' ');
            String nameVariable = words[i].substring(0, firstSpaceIndex);
            String valueVariableString = words[i].substring(lastSpaceIndex+1, wordLength);
            int valueVariableInt = Integer.parseInt(valueVariableString);
            dict.put(nameVariable, valueVariableInt);
        }
        return dict;
    }
    public abstract void print();
    public abstract Expression derivate(String variable);
    public abstract int evaluate(HashMap<String, Integer> dict);
}
