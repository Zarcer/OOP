package ru.nsu.zarcer;

import java.util.HashMap;
import java.util.Objects;

public class Variable extends Expression {

    private String name;
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
    public int evaluate(HashMap<String, Integer> dict) {
        return dict.get(name);
    }
}
