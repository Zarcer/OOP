package ru.nsu.zarcer;

import java.util.HashMap;
import java.util.Objects;

public class Add extends Expression {
    private Expression First;
    private Expression Second;

    Add(Expression first, Expression second) {
        this.First = first;
        this.Second = second;
    }

    /**
     * Just derivation.
     *
     * @param variable if there is no correct variable, all variables will just go to zero
     *
     * @return recursive call
     */
    @Override
    public Expression derivate(String variable) {
        return new Add(this.First.derivate(variable), this.Second.derivate(variable));
    }

    /**
     * Calculation of expression.
     *
     * @param dict dictionary with pairs variable name and value
     *
     * @return recursive call
     */
    @Override
    public int evaluate(HashMap<String, Integer> dict) {
        return First.evaluate(dict) + Second.evaluate(dict);
    }

    /**
     * Override for equals method.
     *
     * @param obj with what compare
     *
     * @return recursive call
     */
    @Override
    public boolean equals(Object obj) {
        Add add = (Add) obj;
        return First.equals(add.First) && Second.equals(add.Second);
    }

    /**
     * Override for toString method.
     *
     * @return recursive call
     */
    @Override
    public String toString() {
        return "(" + First.toString() + "+" + Second.toString() + ")";
    }

    /**
     * Override for hash method.
     *
     * @return hash for multiple objects
     */
    @Override
    public int hashCode() {
        return Objects.hash(First, Second);
    }
}
