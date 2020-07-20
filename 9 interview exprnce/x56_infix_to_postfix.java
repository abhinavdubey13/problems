import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/?ref=rp
 * 
 * convert infix expression to postfix expresion
 * 
 * 
 * 
 */

/**
 * 
 * https://www.youtube.com/watch?v=vq-nUF0G4fI&ab_channel=mycodeschool
 * 
 * using stack
 * 
 * 
 * ============
 * TC = n
 * SC = n
 * 
 * 
 */

class x56_infix_to_postfix {

    public static void main(String[] args) {

        // String exp = "a+b+c";
        // String exp = "a+b*c";
        // String exp = "(a+b)*c";
        String exp = "a+b*c-(d/e+f*g*h)";

        try {
            String answer = Solution.function(exp);
            System.out.println(answer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

class Solution {

    static String function(String expression) throws Exception {

        int n = expression.length();

        Stack<Character> stk = new Stack<>();

        String postfix = "";

        for (int i = 0; i < n; i++) {

            char curr = expression.charAt(i);

            if (curr == ' ') {
                continue;
            }

            //digit
            else if (is_operand(curr)) {
                postfix += String.valueOf(curr);
            }

            //operator
            //if operator at top of stack has precedence over the current operand
            //then we need to pop the topmost operator 
            else if (is_operator(curr)) {
                while (stk.size() > 0 && stk.peek() != '(' && has_precedence(stk.peek(), curr)) {
                    postfix += String.valueOf(stk.pop());
                }
                stk.push(curr);
            }

            else if (curr == '(') {
                stk.push(curr);
            }

            //when we see a closing brace , thats the end of one logical group of operators and operands
            //which need to be treated independently , so we pop untill we see (
            else if (curr == ')') {
                while (stk.size() > 0 && stk.peek() != '(') {
                    postfix += String.valueOf(stk.pop());
                }
                stk.pop(); //remove the ( at last
            }

        }

        while (stk.size() > 0) {
            postfix += String.valueOf(stk.pop());
        }

        return postfix;

    }

    // Function to get weight of an operator. An operator with higher weight will have higher precedence. 
    static int get_operator_weight(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Function to verify whether an operator is right associative or not. 
    static boolean is_left_associative(char op) {
        if (op == '^')
            return false;
        return true;
    }

    //check if op1 has more precedence than op2
    //if equal weights , check for associativity , op1 will have higher precendence if op1 is left associtive
    static boolean has_precedence(char op1, char op2) {

        int op1Weight = get_operator_weight(op1);
        int op2Weight = get_operator_weight(op2);

        // If operators have equal precedence, return true if they are left associative. 
        if (op1Weight == op2Weight) {
            return (is_left_associative(op1)) ? true : false;
        }
        return op1Weight > op2Weight ? true : false;

    }

    static boolean is_operand(char x) {
        if (x >= '0' && x <= '9' || x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z') {
            return true;
        }
        return false;
    }

    static boolean is_operator(char x) {
        if (x == '^' || x == '+' || x == '-' || x == '*' || x == '/') {
            return true;
        }
        return false;
    }
}
