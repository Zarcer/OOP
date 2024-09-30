package ru.nsu.zarcer;

import java.util.HashMap;
import java.util.Objects;

public class Variable extends Expression {
    private String name;

    Variable(String tag) {
        this.name = tag;
    }

    /**Just derivation.
     *
     * @param variable if there is no correct variable, all variables will just go to zero
     *
     * @return returns number depending on variable name
     */
    @Override
    public Expression derivate(String variable) {
        if(Objects.equals(variable, name)) {
            return new Number(1);
        }
        else {
            return new Number(0);
        }
    }

    /**Calculation of expression.
     *
     * @param dict dictionary with pairs variable name-> value
     *
     * @return returns variable value, using as a key name of variable
     */
    @Override
    public int evaluate(HashMap<String, Integer> dict) {
        return dict.get(name);
    }

    /**Override for equals method.
     *
     * @param obj with what compare
     *
     * @return return boolean value
     */
    @Override
    public boolean equals(Object obj) {
        Variable vari = (Variable) obj;
        return Objects.equals(name, vari.name);
    }

    /**Override for toString method.
     *
     * @return just returns name of variable, it is already in String
     */
    @Override
    public String toString() {
        return name;
    }

    /**Override for hash method.
     *
     * @return hash for single object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
