package ru.nsu.zarcer;

public class Main {
    public static void main(String[] args) {
        Expression e = new Add(new Number(3), new Mul(new Number(2), new Variable("x")));
        e.print();
        System.out.print("\n");
        Expression de = e.derivate("x");
        de.print();
        System.out.print("\n");
        int result = e.eval("x = 10; y = 13");
        System.out.println(result);
    }

    public static Expression parseIntoExpr(String s) {
        int parentCnt = 0;
        int operIndex=-1;
        char oper=' ';
        if(s.startsWith("(") && s.endsWith(")")) {
            s=s.substring(1, s.length()-1);
        }
        for(int i = 0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '(') {
                parentCnt++;
            }
            else if(c == ')') {
                parentCnt--;
            }
            else if(parentCnt==0 && (c=='+' || c=='-' || c=='/'||c=='*')) {
                operIndex = i;
                oper = c;
                break;
            }
        }
        if(operIndex!=-1) {
            String firstString = s.substring(0, operIndex);
            String secondString = s.substring(operIndex+1);
            Expression first = parseIntoExpr(firstString);
            Expression second = parseIntoExpr(secondString);
            switch(oper) {
                case '+':
                    return new Add(first, second);
                case '-':
                    return new Sub(first, second);
                case '/':
                    return new Div(first, second);
                case '*':
                    return new Mul(first, second);
            }
        }
        if(Character.isDigit(s.charAt(0))) {
            return new Number(Integer.parseInt(s));
        }
        else {
            return new Variable(s);
        }
    }
}