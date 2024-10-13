package ru.nsu.zarcer;

import java.util.HashMap;
import java.util.Objects;

/**
 * Just class for sub.
 */
public class Sub extends Expression {
    private Expression first;
    private Expression second;

    Sub(Expression first, Expression second) {
        this.first = first;
        this.second = second;
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
        return new Sub(this.first.derivate(variable), this.second.derivate(variable));
    }

    /**
     * Calculation of expression.
     *
     * @param dict dictionary with pairs variable name value
     *
     * @return recursive call
     */
    @Override
    public int evaluate(HashMap<String, Integer> dict) {
        return first.evaluate(dict) - second.evaluate(dict);
    }

    @Override
    public Expression cut() {
        if(!first.checkVariable()&&!second.checkVariable()){
            int result = this.eval("x = 666");
            return new Number(result);
        }
        if(first.equals(second)){
            return new Number(0);
        }
        return new Sub(first.cut(), second.cut());
    }

    @Override
    public boolean checkVariable() {
        return (first.checkVariable() || second.checkVariable());
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
        if(!(obj instanceof Sub)){
            return false;
        }
        Sub sub = (Sub) obj;
        return first.equals(sub.first) && second.equals(sub.second);
    }

    /**
     * Override for toString method.
     *
     * @return recursive call
     */
    @Override
    public String toString() {
        return "(" + first.toString() + "-" + second.toString() + ")";
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
