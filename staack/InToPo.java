import java.util.Stack;

public class InToPo {
    static class Node {
        public int data;
        public Node next;
    }

    static class CustomStack {
        private Node top;

        CustomStack() {
            top = null;
        }

        void push(int x) {
            Node t = new Node();
            t.data = x;
            t.next = top;
            top = t;
        }

        int pop() {
            Node p;
            int x = -1;
            if (top == null) {
                System.out.println("Stack Underflow!");
            } else {
                p = top;
                x = p.data;
                top = top.next;
                p = null;
            }
            return x;
        }

        int isEmpty() {
            return top == null ? 1 : 0;
        }
    }

    static int operation(char op, int x, int y) {
        switch (op) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
        }
        return 0;
    }

    static int isOperand(char x) {
        return (x == '+' || x == '-' || x == '*' || x == '/' || x == '^' || x == '(' || x == ')') ? 0 : 1;
    }

    static int outPrecedence(char x) {
        switch (x) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 3;
            case '^':
                return 6;
            case '(':
                return 7;
            case ')':
                return 0;
        }
        return -1;
    }

    static int inPrecedence(char x) {
        switch (x) {
            case '+':
            case '-':
                return 2;
            case '*':
            case '/':
                return 4;
            case '^':
                return 5;
            case '(':
                return 0;
        }
        return -1;
    }

    static String convert(String infix) {
        char[] postfix = new char[infix.length() + 1];
        Stack<Character> stk = new Stack<>();
        int i = 0, j = 0;

        while (i < infix.length()) {
            if (isOperand(infix.charAt(i)) == 1) {
                postfix[j++] = infix.charAt(i++);
            } else {
                if (stk.empty() || outPrecedence(infix.charAt(i)) > inPrecedence(stk.peek())) {
                    stk.push(infix.charAt(i++));
                } else if (outPrecedence(infix.charAt(i)) == inPrecedence(stk.peek())) {
                    stk.pop();
                } else {
                    postfix[j++] = stk.pop();
                }
            }
        }

        while (!stk.empty() && stk.peek() != ')') {
            postfix[j++] = stk.pop();
        }
        postfix[j] = '\0';
        return new String(postfix).trim();
    }

    static int evaluate(String postfix) {
        CustomStack stk = new CustomStack();
        int x, y, result;
        for (int i = 0; i < postfix.length(); i++) {
            if (isOperand(postfix.charAt(i)) == 1) {
                stk.push(postfix.charAt(i) - '0');
            } else {
                y = stk.pop();
                x = stk.pop();
                result = operation(postfix.charAt(i), x, y);
                stk.push(result);
            }
        }
        result = stk.pop();
        return result;
    }

    public static void main(String[] args) {
        String infix = "(3*4)/(9-3)+3";
        String postfix = convert(infix);
        System.out.println(postfix);
        System.out.println(evaluate(postfix));
    }
}
