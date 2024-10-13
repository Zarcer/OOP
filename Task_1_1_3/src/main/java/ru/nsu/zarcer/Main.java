package ru.nsu.zarcer;

/**
 * Main class for executing program.
 */
public class Main {
    public static void main(String[] args) {
        Expression e = new Add(new Number(3), new Mul(new Number(2), new Variable("x")));
        Expression cuted = e.cut();
        System.out.println(cuted.toString());
    }

    public static Expression parseIntoExpr(String s) {
        String[] opers = {"+-", "*/"};
        for(String op : opers){
            for (int i = s.length()-1; i>=0; i--) {
                char c = s.charAt(i);
                if (op.indexOf(c) != -1) {
                    String firstString = s.substring(0, i);
                    String secondString = s.substring(i+1);
                    Expression first = parseIntoExpr(firstString);
                    Expression second = parseIntoExpr(secondString);
                    switch (c) {
                        case '+':
                            return new Add(first, second);
                        case '-':
                            return new Sub(first, second);
                        case '/':
                            return new Div(first, second);
                        case '*':
                            return new Mul(first, second);
                        default:
                            return new Number(-1);
                    }
                }
            }
        }
        if (Character.isDigit(s.charAt(0))) {
            return new Number(Integer.parseInt(s));
        } else {
            return new Variable(s);
        }
    }
}