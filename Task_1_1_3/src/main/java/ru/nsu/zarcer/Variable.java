package ru.nsu.zarcer;

import java.util.Objects;

public class Variable extends Expression {

    String name;
    Variable(String tag) {
        this.name = tag;
    }
    @Override
    public void print() {
        System.out.print(name);
    }

    @Override
    public Expression derivate(String variable) {
        if(Objects.equals(variable, name)) {
            return new Number(1);
        }
        else {
            return new Number(0);
        }
    }


    @Override
    public int eval(String variables) {
        String[] words = variables.split(";");
        for(int i = 0;i < words.length;i++) {
            words[i] = words[i].trim();
            int wordLength = words[i].length();
            int lastSpaceIndex = words[i].lastIndexOf(' ');
            int firstSpaceIndex = words[i].indexOf(' ');
            String nameVariable = words[i].substring(0, firstSpaceIndex);
            String valueVariableString = words[i].substring(lastSpaceIndex+1, wordLength);
            int valueVariableInt = Integer.parseInt(valueVariableString);
            if(nameVariable.equals(this.name)) {
                return valueVariableInt;
            }
        }
        return -1;
    }
}
