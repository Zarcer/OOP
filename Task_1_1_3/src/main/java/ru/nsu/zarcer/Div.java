package ru.nsu.zarcer;

import java.util.HashMap;
import java.util.Objects;

/**
 * Just div class.
 */
public class Div extends Expression {
    private Expression first;
    private Expression second;

    Div(Expression first, Expression second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Just derivation.
     *
     * @param variable if there is no correct variable, all variables will just go to zero
     * @return recursive call
     */
    @Override
    public Expression derivate(String variable) {
        return new Div(new Sub(new Mul(this.first.derivate(variable), this.second),
                new Mul(this.first, this.second.derivate(variable))),
                new Mul(this.second, this.second));
    }

    /**
     * Calculation of expression.
     *
     * @param dict dictionary with pairs variable name value
     * @return recursive call
     */
    @Override
    public int evaluate(HashMap<String, Integer> dict) {
        return first.evaluate(dict) / second.evaluate(dict);
    }

    /**
     * Recursively cuts expression.
     *
     * @return returns new expression
     */
    @Override
    public Expression cut() {
        Expression temp;
        if ((temp = checkAndFinale(first, second)) == null) {
            return new Div(this.first.cut(), this.second.cut());
        }
        return temp;
    }

    /**
     * Recursively checks if expression has variables.
     *
     * @return true if has, false otherwise
     */
    @Override
    public boolean checkVariable() {
        return (first.checkVariable() || second.checkVariable());
    }

    /**
     * Override for equals method.
     *
     * @param obj with what compare
     * @return recursive call
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Div)) {
            return false;
        }
        Div div = (Div) obj;
        return first.equals(div.first) && second.equals(div.second);
    }

    /**
     * Override for toString method.
     *
     * @return recursive call
     */
    @Override
    public String toString() {
        return "(" + first.toString() + "/" + second.toString() + ")";
    }

    /**
     * Override for hash method.
     *
     * @return hash for multiple objects
     */
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
