import java.util.Arrays;
import java.util.Stack;
import java.util.Scanner;
public class StackProblems {
    static Stack<Character> stack = new Stack<Character>(); // for infix, postfix
    static Stack<Integer> stack1 = new Stack<Integer>(); // for reverse stack's elements
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        System.out.println(exp + " Convert to: " + convertToPostfix(exp));
        System.out.println(convertToPostfix(exp) + " Convert to: " + convertToInfix(convertToPostfix(exp)));
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        System.out.println(Arrays.toString(stack1.toArray()));
        reverseStack();
        System.out.println(Arrays.toString(stack1.toArray()));
        System.out.println(reverseEachWord("DSA ASD"));
    }

    private static int precedence(char op) throws IllegalArgumentException {
        switch (op) {
            case '+' : return 1;
            case '-' : return 1;
            case '*' : return 2;
            case '/' : return 2;
            case '^' : return 3;
            default :throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static String convertToPostfix(String s) {
        String exp = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') exp += c + " ";
            else if (c == '(') stack.push(c);
            else if (c == ')') {
                while (stack.peek() != '(') {
                    exp += stack.pop() + " ";
                }
                stack.pop();
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                while (!stack.isEmpty() && stack.peek() != '(' && precedence(c) <= precedence(stack.peek())) {
                    exp += stack.pop() + " ";
                }
                stack.push(c);
            }
            else continue;
        }
        while (!stack.isEmpty()) {
            exp += stack.pop() + " ";
        }
        stack.removeAllElements();
        return exp;
    }

    public static String convertToInfix(String s) {
        Stack<String> stack = new Stack<String>();
        s = s.replaceAll(" ", "");
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9')
                stack.push(c + "");
            else {

                String op1 = stack.peek() + "";
                stack.pop();
                String op2 = stack.peek() + "";
                stack.pop();
                stack.push("(" + op2 + s.charAt(i) + op1 + ")");
            }
        }
        return stack.peek();
    }

    public static void reverseStack() { //
        if (!stack1.isEmpty()) {
            int tmp = stack1.peek();
            stack1.pop();
            reverseStack();

            insert_to_bottom(tmp);
        }
    }
    private static void insert_to_bottom(int data) {
        if (stack1.isEmpty()) {
            stack1.push(data);
        }
        else {
            int tmp = stack1.peek();
            stack1.pop();
            insert_to_bottom(data);

            stack1.push(tmp);
        }
    }
    public static String reverseEachWord(String s) {
        Stack<Character> stack = new Stack<Character>();
        String rs = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                stack.push(c);
            }
            else {
                while (!stack.isEmpty()) {
                    rs += (stack.pop() + "");
                }
                rs += (c + "");
            }
        }
        while (!stack.isEmpty()) {
            rs += stack.pop() + "";
        }
        return rs;
    }
}
