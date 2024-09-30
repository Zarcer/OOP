package ru.nsu.zarcer;

import java.util.HashMap;
import java.util.Objects;

public class Number extends Expression {
    private int value;

    Number(int value) {
        this.value = value;
    }

    /**Just derivation.
     *
     * @param variable if there is no correct variable, all variables will just go to zero
     *
     * @return returns number with 0 value
     */
    @Override
    public Expression derivate(String variable) {
        return new Number(0);
    }

    /**Calculation of expression.
     *
     * @param dict dictionary with pairs variable name-> value
     *
     * @return returns value of number
     */
    @Override
    public int evaluate(HashMap<String, Integer> dict) {
        return value;
    }

    /**Override for equals method.
     *
     * @param obj with what compare
     *
     * @return compare just by values
     */
    @Override
    public boolean equals(Object obj) {
        Number numb = (Number)obj;
        return value == numb.value;
    }

    /**Override for toString method.
     *
     * @return cast value to string and returns it
     */
    @Override
    public String toString() {
        return Integer.toString(value);
    }

    /**Override for hash method.
     *
     * @return hash for single object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
