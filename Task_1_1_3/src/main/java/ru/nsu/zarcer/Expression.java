package ru.nsu.zarcer;

import java.util.HashMap;

/**
 * Baseclass for other classes.
 */
public abstract class Expression {

    /**
     * Outer function that calculates expression.
     *
     * @param s string that need to be calculated
     *
     * @return call that calculate expression
     */
    public int eval(String s) {
        return evaluate(stringToMap(s));
    }

    /**
     * Transform String to hashmap, giving each value its name.
     *
     * @param variables string that be transformed to map
     *
     * @return returns hashmap dictionary
     */
    private HashMap<String, Integer> stringToMap(String variables) {
        String[] words = variables.split(";");
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].trim();
            int wordLength = words[i].length();
            int lastSpaceIndex = words[i].lastIndexOf(' ');
            int firstSpaceIndex = words[i].indexOf(' ');
            String nameVariable = words[i].substring(0, firstSpaceIndex);
            String valueVariableString = words[i].substring(lastSpaceIndex + 1, wordLength);
            int valueVariableInt = Integer.parseInt(valueVariableString);
            dict.put(nameVariable, valueVariableInt);
        }
        return dict;
    }

    /**
     * Using string from toString() method to print expression.
     */
    public void print() {
        System.out.print(this.toString());
    }

    /**
     * Abstract method for recursive derivation.
     *
     * @param variable variable name of what derivation will go
     * @return returns derivated expression
     */
    public abstract Expression derivate(String variable);

    /**
     * Abstract method for recursive evaluation.
     *
     * @param dict dictionary with pairs where key it is variable name
     * @return returns int value, result of expression calculation
     */
    public abstract int evaluate(HashMap<String, Integer> dict);
}
